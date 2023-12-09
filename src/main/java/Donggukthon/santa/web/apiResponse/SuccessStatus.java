package Donggukthon.santa.web.apiResponse;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public enum SuccessStatus {

    /** /main **/
    READ_TREE_DECORATION(200, true, "트리의 데코레이션들이 조회되었습니다."),

    /** /user **/
    JOIN_USER(201, true, "회원가입이 완료되었습니다."),
    LOGIN_USER(200, true, "로그인이 완료되었습니다.");

    /** /certification **/

    /** /submission **/

    /** /hall **/

    private final int code;
    private final Boolean success;
    private final String message;
}
