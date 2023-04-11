package com.pvb.projeto.eventoserver.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    @Column(name = "cidade")
    private String localidade;
    @Column(name = "estado")
    private String uf;
    private String cep;

    public Endereco(Endereco e){
        this(e.logradouro, e.numero, e.complemento,
                e.bairro, e.localidade, e.uf, e.cep);
    }
}
