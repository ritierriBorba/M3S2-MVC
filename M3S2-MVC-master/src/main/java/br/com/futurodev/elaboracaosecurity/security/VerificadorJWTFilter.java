package br.com.futurodev.elaboracaosecurity.security;

import br.com.futurodev.elaboracaosecurity.model.Usuario;
import br.com.futurodev.elaboracaosecurity.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class VerificadorJWTFilter extends OncePerRequestFilter {

    
    private TokenService tokenService;
    private UsuarioRepository usuarioRepository;

    
    public VerificadorJWTFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request); 
        if (tokenService.isTokenValido(token)) { 
            autenticarCliente(token);
        }
        
        filterChain.doFilter(request, response);
    }

    
    private void autenticarCliente(String token) {
        Integer usuarioId = tokenService.getUsuarioId(token);
        Usuario usuario = usuarioRepository.buscarPorId(usuarioId);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    
    private String recuperarToken(HttpServletRequest request) {
        String tipo = "Bearer";
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith(tipo)) {
            return null;
        }
        
        return token.replaceFirst(tipo, "").trim();
    }

}
