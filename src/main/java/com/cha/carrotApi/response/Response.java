package com.cha.carrotApi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response {
    private boolean success;
    private int code;
    private Result result;

    public static Response success() {
        return new Response(true, 0, null);
    }

    public static <T> Response success(T data) {
        return new Response(true, 0, new Success<>(data));
    }

    public static Response failure(int code, String msg) {
        return new Response(false, code, new Failure(msg));
    }
}
