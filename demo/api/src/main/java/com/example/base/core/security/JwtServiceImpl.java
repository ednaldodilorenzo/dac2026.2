package com.example.base.core.security;

import com.example.base.dto.UsuarioLogadoDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Service
public class JwtServiceImpl implements JwtService {
    private final SecretKey secretKey = Keys.
            hmacShaKeyFor("minha-chave-ultra-secreta-de-pelo-menos-256-bits!!!".
                    getBytes());

    private final String AUTHORITIES_KEY = "authorities";

    @Override
    public String generateToken(Authentication authentication) {
        return Jwts.builder().subject(authentication.getName()).
                claim(AUTHORITIES_KEY, authentication.
                        getAuthorities().
                        stream().
                        map(GrantedAuthority::getAuthority).toList()).
                signWith(secretKey).
                expiration(new Date(System.currentTimeMillis() + 3600 * 1000)).
                compact();
    }

    @Override
    public Authentication getAuthentication(String token) {
        var claims = Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        var userId = claims.getSubject();
        List<String> authorities = claims.get(AUTHORITIES_KEY, List.class);

        var grantedAuthorities = authorities
                .stream()
                .map(role -> role.startsWith("ROLE_") ? role : "ROLE_" + role)
                .map(SimpleGrantedAuthority::new).toList();
        var usuarioLogado = new UsuarioLogadoDto(Long.parseLong(userId));
        return new UsernamePasswordAuthenticationToken(usuarioLogado, token, grantedAuthorities);
    }
}
