package br.com.sistema.BackEnd.Service;

import br.com.sistema.BackEnd.Entity.MenuEntity;
import br.com.sistema.BackEnd.Entity.PaginaEntity;
import br.com.sistema.BackEnd.ModelDTO.PaginaDTO;
import br.com.sistema.BackEnd.Repository.MenuRepository;
import br.com.sistema.BackEnd.Repository.PaginaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PaginaService {
    @Autowired
    PaginaRepository repository;
    @Autowired
    MenuRepository menuRepository;

    public List<PaginaEntity> Listar(PaginaEntity filtro){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<PaginaEntity> example = Example.of(filtro,matcher);
        return repository.findAll(example);
    }
    public PaginaEntity Pesquisar(PaginaDTO filtro){
        return repository.findById(filtro.getCodigo())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro não encontrado"));


    }
    public PaginaEntity Incluir(PaginaDTO dados){

        MenuEntity menu = menuRepository.findById(dados.getCodigoMenu()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Menu não cadastrado!"));
        PaginaEntity gravar = new PaginaEntity();

        gravar.setDescricao(dados.getDescricao());
        gravar.setSituacao(dados.getSituacao());
        gravar.setOrdem(dados.getOrdem());
        gravar.setMenu(menu);
        return repository.save(gravar);
    }

    public void Atualizar(PaginaDTO dados){

        MenuEntity menu = menuRepository.findById(dados.getCodigoMenu()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Menu não cadastrado!"));
        repository.findById(dados.getCodigo())
                .map(registroEncontrado->{
                    registroEncontrado.setDescricao(dados.getDescricao());
                    registroEncontrado.setSituacao(dados.getSituacao());
                    registroEncontrado.setOrdem(dados.getOrdem());
                    registroEncontrado.setMenu(menu);
                    return repository.save(registroEncontrado);
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));

    }
    public void Excluir(PaginaDTO dados){
        repository.findById(dados.getCodigo())
                .map(registroEncontrado->{
                    repository.delete(registroEncontrado);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));

    }
}
