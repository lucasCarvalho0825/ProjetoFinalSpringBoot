package compvb.projeto.pagametoserver.domain;

import compvb.projeto.pagametoserver.domain.enumerated.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String numero;
    @NotBlank
    private String expiracao;
    private String codigo;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    private double valor;
    @NotNull
    private Integer eventoId;
}
