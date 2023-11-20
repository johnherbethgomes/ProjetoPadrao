package br.com.sistema.BackEnd.Service;

import br.com.sistema.BackEnd.Entity.GrupoEntity;
import br.com.sistema.BackEnd.ModelDTO.GrupoDTO;
import br.com.sistema.BackEnd.Repository.GrupoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Data
public class GrupoService {

    @Autowired
    GrupoRepository repository;
    public List<GrupoEntity> Listar(GrupoEntity filtro){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                //withIgnoreCase("nomecampo1","nomecampo2) - com essa opção você pode especificar quais campos poderá ignorar a caixa dos caracteres
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<GrupoEntity> example = Example.of(filtro,matcher);
       return  repository.findAll(example);
    }
    public GrupoEntity pesquisar(GrupoDTO filtro){
        return  repository.findById(filtro.getCodigo())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado!"));
    }

    public GrupoEntity incluir(GrupoEntity registro){
        boolean existeNome = repository.existsByNome(registro.getNome());
        if (existeNome){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Já existe esse Grupo Cadastrado !");
        }
        return  repository.save(registro);
    }

    public void Atualizar(GrupoEntity dados){
        repository.findById(dados.getCodigo())
                .map(registroEncontrado->{
                    dados.setCodigo(registroEncontrado.getCodigo());
                    return  repository.save(dados);
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro não encontrado!"));
    }
    public void Excluir(GrupoEntity dados){
        repository.findById(dados.getCodigo())
                .map(registroEncontrado->{
                    repository.delete (registroEncontrado);
                    return  Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro não encontrado!"));
    }
}
