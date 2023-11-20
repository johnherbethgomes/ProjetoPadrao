package br.com.sistema.BackEnd.ModelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoDTO {
    private Integer codigo;
    private String nome;
    private String situacao;
    private String dataCadastro;
}
