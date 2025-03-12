package es.acaex.biblioteca.dtos;

import java.util.List;

import es.acaex.biblioteca.models.Member;
import lombok.Data;

@Data
public class MemberDetail {
    
    Long id;
    String username;
    String email;

    public static MemberDetail fromMember(Member member){
        MemberDetail memberDetail = new MemberDetail();
        memberDetail.setId(member.getId());
        memberDetail.setUsername(member.getNombreusuario());
        memberDetail.setEmail(member.getEmail());
        return memberDetail;
    }

    public static List<MemberDetail> fromMembersList(List<Member> membersList){
        return membersList.stream().map(MemberDetail::fromMember).toList();
    }
}
