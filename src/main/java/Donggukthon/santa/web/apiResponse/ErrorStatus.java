package Donggukthon.santa.web.apiResponse;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor
public enum ErrorStatus {

    /** /main **/
    READ_TREE_DECORATION(400, false, "트리의 데코레이션들 조회를 실패했습니다."),

    /** /user **/
    JOIN_USER(500, false, "회원가입에 실패하였습니다."),
    LOGIN_USER(401, false, "비밀번호가 일치하지 않습니다.");
    /** /certification **/

    /** /submission **/

    /** /hall **/

    private final int code;
    private final Boolean success;
    private final String message;
}
