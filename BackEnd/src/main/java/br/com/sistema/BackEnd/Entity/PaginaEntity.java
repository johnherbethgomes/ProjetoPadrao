package br.com.sistema.BackEnd.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "tbpaginanova")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pagina_Codigo")
    private Integer codigo;

    @NotEmpty(message = "Campo Descrição é pbrigatório!")
    @Column(name = "Pagina_Descricao", length = 100,nullable = false)
    private String descricao;

    @NotEmpty(message = "Campo Situação é obrigatório!")
    @Column(name = "Pagina_Situacao", length = 1,nullable = false)
    private String situacao;

    @ManyToOne
    @JoinColumn(name = "Pagina_Menu")
    private MenuEntity menu;

    @NotNull(message = "Campo Ordem é obrigatório")
    @Column(name = "Pagina_Ordem", length = 5,nullable = false)
    private Integer ordem;


}
