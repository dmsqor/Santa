package Donggukthon.santa.web.apiResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"code", "success", "message", "data"})
public class ApiResponse<T> {

    @JsonProperty("success")
    private final Boolean success;
    private final int code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    // 성공한 경우
    public ApiResponse(SuccessStatus status, T result) {
        this.code = status.getCode();
        this.success = status.getSuccess();
        this.message = status.getMessage();
        this.data = result;
    }

    public ApiResponse(SuccessStatus status) {
        this.code = status.getCode();
        this.success = status.getSuccess();
        this.message = status.getMessage();
    }

    // 실패한 경우
    public ApiResponse(ErrorStatus status) {
        this.code = status.getCode();
        this.success = status.getSuccess();
        this.message = status.getMessage();
    }

}
