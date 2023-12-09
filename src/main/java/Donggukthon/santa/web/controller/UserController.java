package Donggukthon.santa.web.controller;

import Donggukthon.santa.config.TokenProvider;
import Donggukthon.santa.domain.Member;
import Donggukthon.santa.domain.Temp;
import Donggukthon.santa.service.UserService;
import Donggukthon.santa.web.apiResponse.ApiResponse;
import Donggukthon.santa.web.apiResponse.ErrorStatus;
import Donggukthon.santa.web.apiResponse.SuccessStatus;
import Donggukthon.santa.web.dto.MemberDto;
import Donggukthon.santa.web.dto.UserJoinDto;
import Donggukthon.santa.web.dto.UserLoginDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final TokenProvider tokenProvider;

    @PostMapping ("/join")
    public ResponseEntity<ApiResponse> joinUser(@RequestBody UserJoinDto userJoinDto){
        Member member = userService.signUp(userJoinDto);

        if(member != null){
            ApiResponse response = new ApiResponse<>(SuccessStatus.JOIN_USER, member);
            return ResponseEntity.ok(response);
        }else{
            ApiResponse response = new ApiResponse(SuccessStatus.JOIN_USER);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> loginUser(@RequestBody UserLoginDto userLoginDto){

        MemberDto memberDto = userService.findUserByEmail(userLoginDto.getEmail());

        if(memberDto.getPassword().equals(userLoginDto.getPassword())){
            String generatedToken = tokenProvider.generateToken(userLoginDto.getEmail());

            ApiResponse<String> response = new ApiResponse<>(SuccessStatus.LOGIN_USER, generatedToken);
            return ResponseEntity.ok(response);
        }else{
            ApiResponse<String> response = new ApiResponse<>(ErrorStatus.LOGIN_USER);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }


    }

    @GetMapping("/info")
    public String Userinfo(@RequestHeader("Authorization") String token){

        //if (token == null || !token.startsWith("Bearer ")) {
            //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            //return null;
        //}

        String accessToken = token.substring(7);

        try {
            Claims claims = Jwts.parser().parseClaimsJws(accessToken).getBody();
                    //setSigningKey(SECRET_KEY).parseClaimsJws(accessToken).getBody();
            String subject = claims.getSubject();

            MemberDto memberDto= userService.findUserByEmail(subject);
            //ApiResponse<String> response = new ApiResponse<>(SuccessStatus.LOGIN_USER, memberDto);
            return subject;
        } catch (Exception e) {
            return null;
        }
    }
}
