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

    private int code;

    private T data;
}
