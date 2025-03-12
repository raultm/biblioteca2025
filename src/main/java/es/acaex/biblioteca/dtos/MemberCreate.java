package es.acaex.biblioteca.dtos;

import es.acaex.biblioteca.models.Member;
import lombok.Data;

@Data
public class MemberCreate {
    
    String username;
    String email;

    public Member toMember(){
        Member member = new Member();
        member.setNombreusuario(username);
        member.setEmail(email);
        return member;
    }
}
