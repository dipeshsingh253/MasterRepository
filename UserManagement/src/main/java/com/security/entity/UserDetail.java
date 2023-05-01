package com.security.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetail {

    @Id
    private Long id;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Designation designation;


    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    @MapsId
    private User user;

    public UserDetail(String phone, Designation designation) {
        this.phone = phone;
        this.designation = designation;
    }

    public UserDetail(String phone, Designation designation, User user) {
        this.phone = phone;
        this.designation = designation;
        this.user = user;
    }
}
