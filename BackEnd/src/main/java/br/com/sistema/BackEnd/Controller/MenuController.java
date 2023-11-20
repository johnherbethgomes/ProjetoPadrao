package br.com.sistema.BackEnd.Controller;

import br.com.sistema.BackEnd.Entity.MenuEntity;
import br.com.sistema.BackEnd.ModelDTO.MenuDTO;
import br.com.sistema.BackEnd.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    MenuService service;

    @GetMapping("/listar")
    public List<MenuEntity> Listar( @RequestBody MenuDTO filtro){
     return service.Listar(filtro);
    }
    @GetMapping("/pesquisar")
    public MenuEntity Pesquisar( @RequestBody MenuDTO filtro){
        return service.Pesquisar(filtro);
    }
    @PostMapping("/incluir")
    @ResponseStatus(HttpStatus.CREATED)
    public MenuEntity Incluir(@RequestBody @Valid MenuEntity dados){
        return  service.Incluir(dados);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Atualizar(@RequestBody @Valid MenuEntity dados){
        service.Atualizar(dados);
    }

    @DeleteMapping("/excluir")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Excluir(@RequestBody MenuEntity dados){
        service.Excluir(dados);
    }

}
