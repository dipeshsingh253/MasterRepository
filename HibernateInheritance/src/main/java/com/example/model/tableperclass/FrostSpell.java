package com.example.model.tableperclass;


import javax.persistence.Entity;

@Entity
public class FrostSpell extends Spell{

    private Boolean isFreezing;
    private Integer freezeDuration;

    public FrostSpell() {
    }

    public FrostSpell(String name, Integer energyCost, Integer damage, Boolean isFreezing, Integer freezeDuration) {
        super(name, energyCost, damage);
        this.isFreezing = isFreezing;
        this.freezeDuration = freezeDuration;
    }
}
