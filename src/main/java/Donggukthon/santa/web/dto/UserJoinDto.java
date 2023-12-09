package Donggukthon.santa.web.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinDto {
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String gender;
    private String phoneNumber;
}
