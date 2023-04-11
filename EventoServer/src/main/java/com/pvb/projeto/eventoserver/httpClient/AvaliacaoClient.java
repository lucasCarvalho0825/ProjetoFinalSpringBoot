package com.pvb.projeto.eventoserver.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient("avaliacao-ms")
public interface AvaliacaoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/find/me/{id}")
    Optional findByMeId(@PathVariable Integer id);
}
