package com.pvb.projeto.avaliacaoserver.domain;

import com.pvb.projeto.avaliacaoserver.domain.DTO.RequestAvaliacaoDTO;
import com.pvb.projeto.avaliacaoserver.domain.DTO.ResponseAvaliacaoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AvaliacoesResource {

    private AvaliacaoService service;

    @PostMapping("create")
    public ResponseEntity<ResponseAvaliacaoDTO> create(@RequestBody @Valid RequestAvaliacaoDTO dto) {
        ResponseAvaliacaoDTO a = service.create(dto);
        return a != null ?
                ResponseEntity.ok().body(a) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("find")
    public ResponseEntity<List<ResponseAvaliacaoDTO>> findAll() {
        List<ResponseAvaliacaoDTO> list = service.findAll();
        return list.size() > 0 ?
                ResponseEntity.ok().body(list) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("find/me/{id}")
    public ResponseEntity<List<ResponseAvaliacaoDTO>> findAllMeId(@PathVariable @NotNull Integer id) {
        List<ResponseAvaliacaoDTO> list = service.findAllMeId(id);
        return list.size() > 0 ?
                ResponseEntity.ok().body(list) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ResponseAvaliacaoDTO> findById(@PathVariable @NotNull Integer id) {
        ResponseAvaliacaoDTO a = service.findById(id);
        return a != null ?
                ResponseEntity.ok().body(a) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseAvaliacaoDTO> update(@PathVariable @NotNull Integer id, @RequestBody @Valid RequestAvaliacaoDTO dto) {
        ResponseAvaliacaoDTO a = service.update(id, dto);
        return a != null ?
                ResponseEntity.ok().body(a) :
                ResponseEntity.badRequest().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseAvaliacaoDTO> delete(@PathVariable @NotNull Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
