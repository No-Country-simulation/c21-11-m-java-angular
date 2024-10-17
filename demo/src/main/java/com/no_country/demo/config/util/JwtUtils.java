package com.no_country.demo.config.util;


import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtils {

    @Value("${security.jwt.key.private}")
    private String privateKey;

    @Value("${security.jwt.user.generator}")
    private String userGenerator;


    public String createToken (Authentication authentication){ // Objeto Authentication : recibimos el usuario y las autorizacioens

        Algorithm algorithm = Algorithm.HMAC256(this.privateKey); //
        String email = authentication.getPrincipal().toString(); //Extraemos el usuario que se va a autenticar

        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority) // /grantedAuthoritie -> grantedAuthoritie.getAuthority())
                .collect(Collectors.joining(",")); //Extraemos los permisos como una cadena de String y lo separamos por "," Pej: READ;DELETE,etc

        String jwtToken = JWT.create()
                .withIssuer(this.userGenerator) //Usuario que genera el Token (Backend)
                .withSubject(email) //Sujeto a quien se le generar el token (quien se autentica)
                .withClaim("authorities", authorities)
                .withIssuedAt(new Date()) //Fecha que se genera el token
                .withExpiresAt(new Date(System.currentTimeMillis()+ 1800000)) //Momento que se expira el token (en milisegundo)
                .withJWTId(UUID.randomUUID().toString()) //Id del token
                .withNotBefore(new Date(System.currentTimeMillis())) //Definir desde que momento es valido el token
                .sign(algorithm); //Se establece la firma (el algoritmo de encriptacion + la firma)

        System.out.println("estoy en jwtutils" + jwtToken);

        return jwtToken;
    }

    /*Metodo de verificacion para el token*/
    public DecodedJWT validateToken(String token) { //Devuelve un DecodedJWT que es un p¿objeto que contiene el jwt decodificado

        try {
            Algorithm algorithm = Algorithm.HMAC256(this.privateKey); //Algoritmo con la clave privada

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(this.userGenerator)
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token); //Verificamos si el token es correcto y lo retornamos, si no se lanza la excepcion
            return decodedJWT;

        } catch (Exception e) {
            throw new JWTVerificationException("Token invalido, no esta autorizado");
        }
    }

    public String extractEmail (DecodedJWT decodedJWT){
        return decodedJWT.getSubject();
    }

    public Claim getSpecificClaim(DecodedJWT decodedJWT, String claimName){
        return decodedJWT.getClaim(claimName);
    }

    public Map<String, Claim> returnAllClaims(DecodedJWT decodedJWT){
        return decodedJWT.getClaims();
    }
}
