package com.usermanagement.payloads;

import com.usermanagement.models.Designation;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Designation designation;

}
