package Donggukthon.santa.service;

import Donggukthon.santa.domain.Member;
import Donggukthon.santa.repository.MemberRepository;
import Donggukthon.santa.web.apiResponse.ErrorStatus;
import Donggukthon.santa.web.dto.MemberDto;
import Donggukthon.santa.web.dto.UserJoinDto;
import Donggukthon.santa.web.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final MemberRepository memberRepository;

    public Member signUp(UserJoinDto userJoinDto){
        Member member = Member.builder()
                .email(userJoinDto.getEmail())
                .password(userJoinDto.getPassword())
                .name(userJoinDto.getName())
                .nickname(userJoinDto.getNickname())
                .gender(userJoinDto.getGender())
                .phoneNumber(userJoinDto.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .build();
        memberRepository.save(member);
        return member;
    }

    public MemberDto findUserByEmail(String email){
        Member member = memberRepository.findMemberByEmail(email).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
        MemberDto memberDto = MemberDto.toMemberDto(member);
        return memberDto;
    }

}
