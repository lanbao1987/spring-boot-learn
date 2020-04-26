package com.guosen.spring.basic.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ReturnResult<T> {

    private String code;

    private String message;

    private T data;

    public ReturnResult(T data) {
        this.code = "success";
        this.message = "success.";
        this.data = data;
    }

    public ReturnResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
