package com.pvb.projeto.authserver.domain.details;

import com.pvb.projeto.authserver.domain.Credencial;
import com.pvb.projeto.authserver.domain.CredencialRepository;
import com.pvb.projeto.authserver.domain.details.DetalheCredencialData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheCredencialService implements UserDetailsService {

    private CredencialRepository repository;

    public DetalheCredencialService(CredencialRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Credencial> credencial = repository.findByLogin(username);
        if (credencial.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new DetalheCredencialData(credencial);
    }

}
