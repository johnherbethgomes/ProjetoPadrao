package br.com.sistema.BackEnd.Service;

import br.com.sistema.BackEnd.Entity.MenuEntity;
import br.com.sistema.BackEnd.ModelDTO.MenuDTO;
import br.com.sistema.BackEnd.Repository.MenuRepository;
import br.com.sistema.BackEnd.Specification.MenuSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository repository;

    public List<MenuEntity> Listar(MenuDTO filtro){
        Specification<MenuEntity> specs = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

        if (filtro.codigo != null){
            specs = specs.and(MenuSpec.codigoEqual(filtro.getCodigo()));
        }
        if (StringUtils.hasText(filtro.getNome())){
            specs = specs.and(MenuSpec.nomeLike(filtro.getNome()));
        }
        if (StringUtils.hasText(filtro.getDescricao())){
            specs = specs.and(MenuSpec.descricaoLike(filtro.getDescricao()));
        }
        return repository.findAll(specs);

    }
    public MenuEntity Pesquisar(MenuDTO filtro){
        return repository.findById(filtro.getCodigo())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro não encontrado!"));
    }
    public MenuEntity Incluir(MenuEntity dados){

        if (repository.existsByNome(dados.getNome())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Nome já existe cadastrado!");
        }

        if (dados.getOrdem().toString().matches("[0-9]")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Campo Ordem só aceita número!");
        }

        return  repository.save(dados);
    }
    public void Atualizar(MenuEntity dados){
        System.out.println("Dados para atualiazar ...: "+dados);
        if (dados.getOrdem().toString().matches("[0-9]")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Campo Ordem só aceita número!");
        }
        repository.findById(dados.getCodigo())
                .map(registroEncontrdo ->{
                    dados.setCodigo(registroEncontrdo.getCodigo());
                    return repository.save(dados);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro não encontrado!"));
    }
    public void Excluir(MenuEntity dados){

        repository.findById(dados.getCodigo())
                .map(registroEncontrdo ->{
                    repository.delete(registroEncontrdo);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro não encontrado!"));
    }
}
