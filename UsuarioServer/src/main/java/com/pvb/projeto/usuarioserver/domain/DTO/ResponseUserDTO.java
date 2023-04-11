package com.pvb.projeto.usuarioserver.domain.DTO;

import com.pvb.projeto.usuarioserver.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseUserDTO {
    private String nome;
    private String bio;
    private Endereco endereco;
}
