package br.com.sistema.BackEnd.Controller;

import br.com.sistema.BackEnd.Entity.PaginaEntity;
import br.com.sistema.BackEnd.ModelDTO.PaginaDTO;
import br.com.sistema.BackEnd.Service.PaginaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pagina")
public class PaginaController {

    @Autowired
    PaginaService service;

    @GetMapping("/listar")
    public List<PaginaEntity> Listar(@RequestBody PaginaEntity filtro){
        return service.Listar(filtro);
    }
    @GetMapping("/pesquisar")
    public PaginaEntity pesquisar(@RequestBody PaginaDTO filtro){
        return service.Pesquisar(filtro);
    }
    @PostMapping("/incluir")
    @ResponseStatus(HttpStatus.CREATED)
    public PaginaEntity Incluir(@RequestBody @Valid PaginaDTO dados){
        return service.Incluir(dados);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Atualizar(@RequestBody @Valid PaginaDTO dados){
        service.Atualizar(dados);
    }

    @DeleteMapping("/excluir")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Excluir(@RequestBody PaginaDTO dados){
        service.Excluir(dados);
    }
}
