package com.pvb.projeto.eventoserver.domain;


import com.pvb.projeto.eventoserver.domain.DTO.RequestEventoDto;
import com.pvb.projeto.eventoserver.domain.DTO.ResponseEventoDto;
import com.pvb.projeto.eventoserver.domain.enumerated.Pagamento;
import com.pvb.projeto.eventoserver.domain.enumerated.Status;
import com.pvb.projeto.eventoserver.httpClient.AvaliacaoClient;
import com.pvb.projeto.eventoserver.infra.excepition.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventoService {

    private EventoRepository repository;

    private ModelMapper modelMapper;
    private AvaliacaoClient avaliacaoClient;

    public ResponseEventoDto create (RequestEventoDto request){

        Evento evento = modelMapper.map(request, Evento.class);

        if (request.getStatus() == Status.GRATUITO) {
            evento.setPagamento(Pagamento.REALIZADO);
        } else {
            evento.setPagamento(Pagamento.AGUARDANDO);
        }

        evento = repository.save(evento);

        return modelMapper.map(evento, ResponseEventoDto.class);
    }

    public List<ResponseEventoDto> findAll (){
        return  repository.findAll()
                .stream()
                .filter(evento -> evento.getDataFinal().isAfter(LocalDateTime.now()))
                .map(evento -> modelMapper.map(evento, ResponseEventoDto.class))
                .toList();
    }

    /**
     * metodo que alimenta a api de usuarios
     * */
    public List<ResponseEventoDto> findAllById(Integer id){
        return  repository.findAll()
                .stream()
                .filter(evento -> evento.getIdUser() == id)
                .map(evento -> modelMapper.map(evento, ResponseEventoDto.class))
                .toList();
    }


    public Optional findMeAvaliacoes(Integer id){
        return avaliacaoClient.findByMeId(id);
    }

    public ResponseEventoDto findById(Integer id){
        Evento evento = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Nenhuma resultado encontrado para o Id: "+ id));
        return modelMapper.map(evento, ResponseEventoDto.class);
    }

    public ResponseEventoDto update (Integer id,  RequestEventoDto request) {
        Evento evento = modelMapper.map(request, Evento.class);
        evento.setId(id);
        evento = repository.save(evento);
        return modelMapper.map(evento, ResponseEventoDto.class);

    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


    /*
    *  Método para comunicação com a api de pagamentos
    *   back-end para back-end
    * */

    public ResponseEventoDto pagamento(Integer id) {

        Evento evento = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Nenhuma resultado encontrado para o Id: "+ id));

        evento.setPagamento(Pagamento.REALIZADO);
        repository.save(evento);

        return modelMapper.map(evento, ResponseEventoDto.class);
    }



}

