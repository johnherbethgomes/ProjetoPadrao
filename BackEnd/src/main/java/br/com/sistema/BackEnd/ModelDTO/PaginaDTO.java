package br.com.sistema.BackEnd.ModelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginaDTO {
    private Integer codigo;
    private String descricao;
    private String situacao;
    private String descricaoMenu;
    private Integer codigoMenu;
    private Integer ordem;


}
