package com.example.model.joined;


import javax.persistence.Entity;

@Entity
public class Knight extends Infantry{

    private Boolean shield;

    public Knight() {
    }

    public Knight(InfantryType type, Integer moveSpeed, Integer durability, Integer attack, Boolean shield) {
        super(type, moveSpeed, durability, attack);
        this.shield = shield;
    }
}
