package roomescape.domain;

import org.thymeleaf.util.StringUtils;

import java.util.Objects;

public class Member {

    private Long id;
    private String name;
    private String email;
    private String password;

    public Member(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Member toEntity(Member member, Long id) {
        return new Member(id, member.getName(), member.getName(), member.getPassword());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean checkPassword(String password) {
        return StringUtils.equals(this.password, password);
    }
}