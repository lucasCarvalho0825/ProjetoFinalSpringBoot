package com.pvb.projeto.usuarioserver.domain;

import com.pvb.projeto.usuarioserver.domain.DTO.ResponseUserDTO;
import com.pvb.projeto.usuarioserver.httpClient.EventoClient;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UsuarioResource {

    private UsuarioService service;


    @PostMapping("create")
    public ResponseEntity create (@Valid @RequestBody ResponseUserDTO dto){
        ResponseUserDTO u = service.create(dto);
        return u != null ?
                ResponseEntity.ok().body(u) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("find")
    public ResponseEntity<List<ResponseUserDTO>> findAll(){
        List<ResponseUserDTO> list = service.findAll();
        return list.size() > 0 ?
                ResponseEntity.ok().body(list) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ResponseUserDTO> findById(@PathVariable Integer id){
        ResponseUserDTO u = service.findById(id);
        return u != null ?
                ResponseEntity.ok().body(u) :
                ResponseEntity.notFound().build();
    }

    /**
     * INVOCANDO O MÉTODO DA API DE EVENTO PARA DENTRO DA API DO USUÁRIO
     * */
    @GetMapping("find/me/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Integer id){
        Optional op = service.findAllById(id);
        return op.isPresent() ?
                ResponseEntity.ok().body(op) :
                ResponseEntity.ok().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseUserDTO> update(@PathVariable Integer id, @Valid @RequestBody ResponseUserDTO dto){
        ResponseUserDTO u = service.update(id, dto);
        return u != null ?
                ResponseEntity.ok().body(u) :
                ResponseEntity.badRequest().build();
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
