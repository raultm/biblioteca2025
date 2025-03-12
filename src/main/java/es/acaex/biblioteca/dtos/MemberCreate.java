package es.acaex.biblioteca.dtos;

import es.acaex.biblioteca.models.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberCreate {

    String username;
    String email;

    public Member toMember() {
        Member member = new Member();
        member.setNombreusuario(username);
        member.setEmail(email);
        return member;
    }
}
