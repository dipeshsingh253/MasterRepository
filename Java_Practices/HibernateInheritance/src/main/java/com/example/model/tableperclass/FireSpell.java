package com.example.model.tableperclass;


import javax.persistence.Entity;

@Entity
public class FireSpell extends Spell{
    private Integer damageOverTime;
    private Integer damageOverTimeDuration;

    public FireSpell() {
    }

    public FireSpell( String name, Integer energyCost, Integer damage, Integer damageOverTime, Integer damageOverTimeDuration) {
        super( name, energyCost, damage);
        this.damageOverTime = damageOverTime;
        this.damageOverTimeDuration = damageOverTimeDuration;
    }
}
