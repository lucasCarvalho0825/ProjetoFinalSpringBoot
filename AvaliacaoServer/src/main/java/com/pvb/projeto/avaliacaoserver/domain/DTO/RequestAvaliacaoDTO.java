package com.pvb.projeto.avaliacaoserver.domain.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAvaliacaoDTO {

    @NotNull
    private Integer id;
    @NotNull
    private Integer idUsuario;
    @NotNull
    private Integer idEvento;
    @NotNull
    private Integer nota;
}
