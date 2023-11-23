package com.jwtsecurity.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetail {

    @Id
    private Integer id;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    private User user;

    public UserDetail(String phone, Designation designation, User user) {
        this.phone = phone;
        this.designation = designation;
        this.user = user;
    }
}
