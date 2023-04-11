package compvb.projeto.pagametoserver.domain.DTO;

import compvb.projeto.pagametoserver.domain.enumerated.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePagamentoDTO {

    private double valor;
    private Status status;
    private Integer eventoId;
}
