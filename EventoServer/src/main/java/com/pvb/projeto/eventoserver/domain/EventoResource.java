package com.pvb.projeto.eventoserver.domain;


import com.pvb.projeto.eventoserver.domain.DTO.RequestEventoDto;
import com.pvb.projeto.eventoserver.domain.DTO.ResponseEventoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class EventoResource {

    private EventoService service;

    @PostMapping("create")
    public ResponseEntity<ResponseEventoDto> create (@Valid @RequestBody RequestEventoDto dto){
        ResponseEventoDto e = service.create(dto);
        return e != null ?
                ResponseEntity.ok().body(e) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("find")
    public ResponseEntity<List<ResponseEventoDto>> findAll(){
        List<ResponseEventoDto> list = service.findAll();
        return list.size() > 0 ?
                ResponseEntity.ok().body(list) :
                ResponseEntity.badRequest().build();
    }

    /**
     * metodo que alimenta a api de usuarios
     * */
    @GetMapping("find/me/{id}")
    public ResponseEntity<List<ResponseEventoDto>> findAllById(@PathVariable Integer id){
        List<ResponseEventoDto> list = service.findAllById(id);
        return list.size() > 0 ?
                ResponseEntity.ok().body(list) :
                ResponseEntity.badRequest().build();
    }


    /**
     * metodo que retorna a api de avaliacoes
     * */
    @GetMapping("find/me/avaliacoes/{id}")
    public ResponseEntity<?> findMeAvaliacoes(@PathVariable Integer id){
        Optional op = service.findMeAvaliacoes(id);
        return op.isPresent() ?
                ResponseEntity.ok().body(op) :
                ResponseEntity.badRequest().build();
    }
    @GetMapping("find/{id}")
    public ResponseEntity<ResponseEventoDto> findById(@PathVariable Integer id){
        ResponseEventoDto e = service.findById(id);
        return e != null ?
                ResponseEntity.ok().body(e) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseEventoDto> update(@PathVariable Integer id, @Valid @RequestBody RequestEventoDto dto){
        ResponseEventoDto e = service.update(id, dto);
        return e != null ?
                ResponseEntity.ok().body(e) :
                ResponseEntity.badRequest().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("pagamento/{id}")
    public ResponseEntity<ResponseEventoDto> pagamento(@PathVariable @NotNull Integer id) {
        ResponseEventoDto e = service.pagamento(id);
        return e != null ?
                ResponseEntity.ok().body(e) :
                ResponseEntity.badRequest().build();

    }
}
