package Donggukthon.santa.web.dto;

import Donggukthon.santa.domain.DesignatedPerson;
import Donggukthon.santa.domain.Member;
import Donggukthon.santa.domain.Submission;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String gender;
    private String phoneNumber;
    private LocalDateTime createdAt;

    private List<Submission> submissions = new ArrayList<>();
    private List<DesignatedPerson> designatedpersons = new ArrayList<>();

    public static MemberDto toMemberDto(Member member){
        MemberDto memberDto = new MemberDto();

        memberDto.setId(member.getId());
        memberDto.setEmail(member.getEmail());
        memberDto.setPassword(member.getPassword());
        memberDto.setName(member.getName());
        memberDto.setGender(member.getGender());
        memberDto.setPhoneNumber(member.getPhoneNumber());

        return memberDto;
    }
}
