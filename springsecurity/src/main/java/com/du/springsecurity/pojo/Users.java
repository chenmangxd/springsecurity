package com.du.springsecurity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Users {
    private Integer id;
    private String username;
    private String password;
}
