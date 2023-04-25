package com.usermanagement.dto;

import com.usermanagement.entity.Designation;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private Integer id;

    @Size(min = 3,max = 25,message = "name should contain minimum of 3 characters and maximum of 25 characters")
    private String name;

    @Email(message = "enter a valid email")
    private String email;

    @Size(min = 10,max = 10,message = "enter a valid phone number")
    private String phone;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$",message = "enter a password containing at least one lowercase,one uppercase, one number and special character")
    private String password;

    private Designation designation;

}
