package com.pvb.projeto.eventoserver.domain.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pvb.projeto.eventoserver.domain.Endereco;
import com.pvb.projeto.eventoserver.domain.enumerated.Categoria;
import com.pvb.projeto.eventoserver.domain.enumerated.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEventoDto {

    private Integer id;
    private String titulo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataInicial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataFinal;
    private Integer idadeMin;
    private String descricao;
    private Status status;
    private Endereco endereco;
    private Categoria categoria;
    private Integer idUser;
}
