package com.pvb.projeto.usuarioserver.domain;


import com.pvb.projeto.usuarioserver.domain.DTO.ResponseUserDTO;
import com.pvb.projeto.usuarioserver.httpClient.EventoClient;
import com.pvb.projeto.usuarioserver.infra.excepition.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository repository;
    private ModelMapper modelMapper;

    private EventoClient eventoClient;

    public ResponseUserDTO create (ResponseUserDTO dto){
        Usuario u = modelMapper.map(dto, Usuario.class);
        u = repository.save(u);
        return modelMapper.map(u, ResponseUserDTO.class);
    }

    public List<ResponseUserDTO> findAll (){
        List<Usuario> list = repository.findAll();
        return list.stream()
                .map(user -> modelMapper.map(user, ResponseUserDTO.class))
                .toList();
    }

    public Optional findAllById (Integer id){
        return eventoClient.findMeById(id);
    }

    public ResponseUserDTO findById(Integer id){
        Optional<Usuario> user = repository.findById(id);
        return user
                .map(u -> modelMapper.map(u, ResponseUserDTO.class))
                .orElseThrow(() -> new ObjectNotFoundException("Nenhuma resultado encontrado para o Id: "+ id));
    }



    public ResponseUserDTO update (Integer id, ResponseUserDTO dto) {
        Usuario u = modelMapper.map(dto, Usuario.class);
        u.setId(id);
        u = repository.save(u);
        return modelMapper.map(u, ResponseUserDTO.class);

    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
