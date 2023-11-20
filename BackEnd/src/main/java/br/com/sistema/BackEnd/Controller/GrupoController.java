package br.com.sistema.BackEnd.Controller;

import br.com.sistema.BackEnd.Entity.GrupoEntity;
import br.com.sistema.BackEnd.ModelDTO.GrupoDTO;
import br.com.sistema.BackEnd.Service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

    @Autowired
    GrupoService service;

    @GetMapping("/listar")
    public List<GrupoEntity> Listar(@RequestBody GrupoEntity filtro){
        return service.Listar(filtro);
    }
    @GetMapping("/pesquisar")
    public GrupoEntity Pesquisar(@RequestBody GrupoDTO filtro){
        return service.pesquisar(filtro);
    }

    @PostMapping("/incluir")
    @ResponseStatus(HttpStatus.CREATED)
    public GrupoEntity Incluir(@RequestBody @Valid GrupoEntity dados){
        return  service.incluir(dados);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void Atualizar(@RequestBody @Valid GrupoEntity dados){
            service.Atualizar(dados);

    }
    @DeleteMapping("/excluir")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void Excluir(@RequestBody GrupoEntity dados){
        service.Excluir(dados);

    }
}
