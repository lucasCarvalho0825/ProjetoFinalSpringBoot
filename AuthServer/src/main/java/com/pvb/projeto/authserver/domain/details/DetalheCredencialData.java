package com.pvb.projeto.authserver.domain.details;

import com.pvb.projeto.authserver.domain.Credencial;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
public class DetalheCredencialData implements UserDetails {

    private  Optional<Credencial> credencial;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return credencial.orElse(new Credencial()).getPassword();
    }

    @Override
    public String getUsername() {
        return credencial.orElse(new Credencial()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
