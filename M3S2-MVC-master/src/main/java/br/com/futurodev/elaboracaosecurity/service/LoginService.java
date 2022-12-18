package br.com.futurodev.elaboracaosecurity.service;

import br.com.futurodev.elaboracaosecurity.security.TokenService;
import br.com.futurodev.elaboracaosecurity.security.dto.LoginDto;
import br.com.futurodev.elaboracaosecurity.security.dto.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired private AuthenticationManager authenticationManager;

    @Autowired private TokenService tokenService;

    public TokenDto gerarToken(LoginDto login) {
        
        Authentication auth = authenticationManager.authenticate(login.converter());
        return tokenService.gerarToken(auth);
    }

}
