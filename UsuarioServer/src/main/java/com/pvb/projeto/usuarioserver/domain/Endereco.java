package com.pvb.projeto.usuarioserver.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    @NotBlank
    private String logradouro;
    @NotBlank
    private String numero;
    private String complemento;
    @NotBlank
    private String bairro;
    @Column(name = "cidade")
    @NotBlank
    private String localidade;
    @Column(name = "estado")
    @NotBlank
    private String uf;
    @NotBlank
    private String cep;

    public Endereco ( Endereco e){
        this(e.logradouro, e.numero, e.complemento,
                e.bairro, e.localidade, e.uf, e.cep);
    }
}
