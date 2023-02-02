package com.example.sping11.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String name;

    private String surname;

    private Double cash;

}
