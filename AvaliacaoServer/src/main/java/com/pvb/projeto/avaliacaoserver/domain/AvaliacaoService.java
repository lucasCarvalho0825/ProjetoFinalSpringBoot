package com.pvb.projeto.avaliacaoserver.domain;

import com.pvb.projeto.avaliacaoserver.domain.DTO.RequestAvaliacaoDTO;
import com.pvb.projeto.avaliacaoserver.domain.DTO.ResponseAvaliacaoDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    private AvaliacaoRepository repository;
    private ModelMapper modelMapper;

    public ResponseAvaliacaoDTO create(RequestAvaliacaoDTO dto) {
        Avaliacao avaliacao = modelMapper.map(dto, Avaliacao.class);
        repository.save(avaliacao);
        return modelMapper.map(avaliacao, ResponseAvaliacaoDTO.class);
    }

    public List<ResponseAvaliacaoDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(a -> modelMapper.map(a, ResponseAvaliacaoDTO.class))
                .toList();
    }

    public List<ResponseAvaliacaoDTO> findAllMeId(Integer id) {
        return repository
                .findAll()
                .stream()
                .filter(a-> a.getIdEvento() == id)
                .map(a -> modelMapper.map(a, ResponseAvaliacaoDTO.class))
                .toList();
    }
    public ResponseAvaliacaoDTO findById(Integer id) {
        Avaliacao avaliacao = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(avaliacao, ResponseAvaliacaoDTO.class);
    }

    public ResponseAvaliacaoDTO update(Integer id, RequestAvaliacaoDTO dto) {
        Avaliacao avaliacao = modelMapper.map(dto, Avaliacao.class);
        avaliacao.setId(id);
        avaliacao = repository.save(avaliacao);
        return modelMapper.map(avaliacao, ResponseAvaliacaoDTO.class);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
