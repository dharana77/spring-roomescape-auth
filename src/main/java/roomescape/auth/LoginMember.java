package roomescape.auth;

import lombok.Getter;

@Getter
public class LoginMember {

  private String email;

  private String token;

  private String role;

  public LoginMember(String email, String token, String role) {
    this.email = email;
    this.token = token;
    this.role = role;
  }
}
