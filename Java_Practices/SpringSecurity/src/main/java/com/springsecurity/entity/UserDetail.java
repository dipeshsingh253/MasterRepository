package com.springsecurity.entity;


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
@Table(name = "user_detail")
public class UserDetail {


    @Id
    private Integer id;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    public UserDetail(String phone, Designation designation, User user) {
        this.phone = phone;
        this.designation = designation;
        this.user = user;
    }
}
