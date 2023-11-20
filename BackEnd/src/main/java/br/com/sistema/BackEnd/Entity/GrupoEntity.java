package br.com.sistema.BackEnd.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Entity(name = "tbgrupo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoEntity {
    @Id
    @Column(name = "Grupo_Codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "Grupo_Nome",length = 50,nullable = false, unique = true)
    @NotEmpty(message = "Campo")
    private String nome ;

    @Column(name = "Grupo_Situacao", nullable = false,length = 1)
    private String situacao;

    @Column(name = "Grupo_Dtcadastro", updatable = false)
    private LocalDate dataCadastro;

    @PrePersist
    @JsonFormat(pattern = "dd/MM/yyyy")
    private void incluiDataCadastro(){
        setDataCadastro(LocalDate.now());

    }

}
