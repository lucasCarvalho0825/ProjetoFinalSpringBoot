package compvb.projeto.pagametoserver.domain.DTO;

import compvb.projeto.pagametoserver.domain.enumerated.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPagamentoDTO {

    private Integer id;
    private double valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Integer eventoId;
}
