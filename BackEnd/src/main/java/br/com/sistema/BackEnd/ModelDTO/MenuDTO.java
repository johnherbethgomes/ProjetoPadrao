package br.com.sistema.BackEnd.ModelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    public Integer codigo;
    public String nome;
    public  String descricao;
    public Integer ordem;
}