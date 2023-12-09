package Donggukthon.santa.config;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

@Service
public class TokenProvider {
    public String generateToken(String username){
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jwtToken = Jwts.builder()
                .setSubject(username)
                .claim("email", username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key)
                .compact();
        return jwtToken;
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().build().parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

//https://bonjourpark.tistory.com/8 참고글