package compvb.projeto.pagametoserver.domain;

import compvb.projeto.pagametoserver.domain.DTO.RequestPagamentoDTO;
import compvb.projeto.pagametoserver.domain.DTO.ResponsePagamentoDTO;
import compvb.projeto.pagametoserver.domain.enumerated.Status;
import compvb.projeto.pagametoserver.httpClient.EventoClient;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PagamentoService {
    private PagamentoRepository repository;
    private ModelMapper modelMapper;
    private EventoClient eventoClient;

    public ResponsePagamentoDTO create(RequestPagamentoDTO dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);

        return modelMapper.map(pagamento, ResponsePagamentoDTO.class);
    }

    public List<ResponsePagamentoDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(p -> modelMapper.map(p, ResponsePagamentoDTO.class))
                .toList();
    }

    public ResponsePagamentoDTO findById(Integer id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pagamento, ResponsePagamentoDTO.class);
    }

    public ResponsePagamentoDTO update(Integer id, RequestPagamentoDTO dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);
        return modelMapper.map(pagamento, ResponsePagamentoDTO.class);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void confirmarPagamento(Integer id){
        Optional<Pagamento> pagamento = repository.findById(id);

        if (!pagamento.isPresent()) {
            throw new EntityNotFoundException();
        }

        eventoClient.eventopagamento(pagamento.get().getEventoId());

        pagamento.get().setStatus(Status.CONFIRMADO);
        repository.save(pagamento.get());
    }

}
