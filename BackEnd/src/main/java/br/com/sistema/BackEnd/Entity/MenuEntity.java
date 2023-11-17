package br.com.sistema.BackEnd.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "tbmenu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity {
    @Id
    @Column(name = "Menu_Codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "Menu_Nome", length = 50,unique = true, updatable = false)
    @NotEmpty(message = "Campo Nome, obrigatório!")
    private String nome;

    @Column(name = "Menu_Descricao", length = 100, nullable = false)
    @NotEmpty(message = "Campo Descrição, obrigatório!")
    private String descricao;

    @Column(name = "Menu_Ordem",length = 5,nullable = false)
    @NotNull(message = "Campo Ordem, obrigatório!")
    private Integer ordem;


}
