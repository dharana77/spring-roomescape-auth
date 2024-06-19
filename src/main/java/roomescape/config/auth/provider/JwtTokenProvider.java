package roomescape.config.auth.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.stereotype.Component;
import roomescape.properties.JwtProperties;

@Component
public class JwtTokenProvider {

  private final JwtProperties jwtProperties;

  public JwtTokenProvider(JwtProperties jwtProperties) {
    this.jwtProperties = jwtProperties;
  }

  public String createToken(String payload, String role) {
    Claims claims = Jwts.claims()
                        .setSubject(payload);
    claims.put("ROLE", role);
    Date now = new Date();
    Date validity = new Date(now.getTime() + jwtProperties.getValidityInMilliseconds());

    return Jwts.builder()
               .setClaims(claims)
               .setIssuedAt(now)
               .setExpiration(validity)
               .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
               .compact();
  }

  public String getPayload(String token) {
    return Jwts.parser()
               .setSigningKey(jwtProperties.getSecretKey())
               .parseClaimsJws(token)
               .getBody()
               .getSubject();
  }

  public String getRole(String token) {
    return Jwts.parser()
               .setSigningKey(jwtProperties.getSecretKey())
               .parseClaimsJws(token)
               .getBody()
               .get("ROLE", String.class);
  }

  public boolean validateToken(String token) {
    try {
      Jws<Claims> claims = Jwts.parser()
                               .setSigningKey(jwtProperties.getSecretKey())
                               .parseClaimsJws(token);

      return !claims.getBody()
                    .getExpiration()
                    .before(new Date());
    } catch (JwtException | IllegalArgumentException e) {
      return false;
    }
  }
}
