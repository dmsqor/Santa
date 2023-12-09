package Donggukthon.santa.web.dto;

import Donggukthon.santa.domain.Member;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto {
    private String email;
    private String password;

    public static UserLoginDto toUserLoginDto(Member member){
        UserLoginDto userLoginDto = new UserLoginDto();

        userLoginDto.setEmail(member.getEmail());
        userLoginDto.setPassword(member.getPassword());

        return userLoginDto;
    }
}
