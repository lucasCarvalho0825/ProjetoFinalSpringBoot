package com.pvb.projeto.authserver.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Integer> {

    public Optional<Credencial> findByLogin(String login);

}
