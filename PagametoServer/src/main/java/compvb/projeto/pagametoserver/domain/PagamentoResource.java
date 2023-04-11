package compvb.projeto.pagametoserver.domain;

import compvb.projeto.pagametoserver.domain.DTO.RequestPagamentoDTO;
import compvb.projeto.pagametoserver.domain.DTO.ResponsePagamentoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class PagamentoResource {

    private PagamentoService service;

    @PostMapping("create")
    public ResponseEntity<ResponsePagamentoDTO> create(@RequestBody @Valid RequestPagamentoDTO dto) {
        ResponsePagamentoDTO p = service.create(dto);
        return p != null ?
                ResponseEntity.ok().body(p) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("find")
    public ResponseEntity<List<ResponsePagamentoDTO>> findAll() {
        List<ResponsePagamentoDTO> list = service.findAll();
        return list.size() > 0 ?
                ResponseEntity.ok().body(list) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ResponsePagamentoDTO> findById(@PathVariable @NotNull Integer id) {
        ResponsePagamentoDTO p = service.findById(id);
        return p != null ?
                ResponseEntity.ok().body(p) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponsePagamentoDTO> update(@PathVariable @NotNull Integer id, @RequestBody @Valid RequestPagamentoDTO dto) {
        ResponsePagamentoDTO p = service.update(id, dto);
        return p != null ?
                ResponseEntity.ok().body(p) :
                ResponseEntity.badRequest().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponsePagamentoDTO> delete(@PathVariable @NotNull Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("confirmar/{id}")
    public void confirmarPagamento(@PathVariable @NotNull Integer id){
        service.confirmarPagamento(id);
    }
}
