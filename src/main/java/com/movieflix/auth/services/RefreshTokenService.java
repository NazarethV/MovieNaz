package com.movieflix.auth.services;

import com.movieflix.auth.entities.RefreshToken;
import com.movieflix.auth.entities.User;
import com.movieflix.auth.repositories.RefreshTokenRepository;
import com.movieflix.auth.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final UserRepository userRepository;

    private final RefreshTokenRepository refreshTokenRepository;

    //Constructores de UserRepository y RefreshTokenRepository
    public RefreshTokenService(UserRepository userRepository, RefreshTokenRepository refreshTokenRepository) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    //Creación de token de actualización
    public RefreshToken createRefreshToken(String username){
        User user = userRepository.findByEmail(username) //Busca por email
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
        RefreshToken refreshToken = user.getRefreshToken();

        if (refreshToken == null) { //Si el token de actualización es nulo
            //Hay que generar nuevamente el token
            long refreshTokenValidity = 5*60*60*10000; //(5 horas)   | 30 * 1000 (30 segundos)
            refreshToken = RefreshToken.builder()
                    .refreshToken(UUID.randomUUID().toString())
                    .expirationTime(Instant.now().plusMillis(refreshTokenValidity))
                    .user(user)
                    .build();
            refreshTokenRepository.save(refreshToken);
        }
        return refreshToken;
    }


    //VerifyRefreshToken
    public RefreshToken verifyRefreshToken(String refreshToken) {
        RefreshToken refToken = refreshTokenRepository.findByRefreshToken(refreshToken)  //findByRefreshToken: Método en RefreshTokenRepository
                .orElseThrow(() -> new RuntimeException("Refresh token not found!"));

        if (refToken.getExpirationTime().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(refToken);
            throw new RuntimeException("Refresh Token expired");
        }

        return refToken;
    }





}












