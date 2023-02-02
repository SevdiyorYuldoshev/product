package com.example.sping11.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDto<T> {

    private boolean success;

    private String message;

    private int code; // 0 -> OK, -1 -> Not Found, 1 -> Validation error 2 -> Database error

    private T data;
}
