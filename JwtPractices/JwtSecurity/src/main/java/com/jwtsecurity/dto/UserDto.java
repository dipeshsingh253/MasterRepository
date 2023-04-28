package com.jwtsecurity.dto;

import com.jwtsecurity.entity.Designation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Designation designation;

}
