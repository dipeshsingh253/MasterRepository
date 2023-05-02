package com.springsecurity.dto;

import com.springsecurity.entity.Designation;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Designation designation;

}
