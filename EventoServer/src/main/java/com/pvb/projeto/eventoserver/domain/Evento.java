package com.pvb.projeto.eventoserver.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.pvb.projeto.eventoserver.domain.enumerated.Categoria;
import com.pvb.projeto.eventoserver.domain.enumerated.Pagamento;
import com.pvb.projeto.eventoserver.domain.enumerated.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String titulo;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataInicial;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataFinal;
    private Integer idadeMin;
    @Enumerated(EnumType.STRING)
    private Pagamento pagamento;
    @NotBlank
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private  Integer idUser;
}
