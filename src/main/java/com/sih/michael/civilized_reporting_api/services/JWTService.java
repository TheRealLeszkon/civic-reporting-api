package com.sih.michael.civilized_reporting_api.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface JWTService {
    String generateToken(String username);

    String extractUsername(String token);

    boolean validateToken(String token, UserDetails userDetails);
    Date extractExpiration(String token);
}
