package com.pvb.projeto.usuarioserver.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient("eventos-ms")
public interface EventoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/find/me/{id}")
    Optional findMeById(@PathVariable Integer id);
}
