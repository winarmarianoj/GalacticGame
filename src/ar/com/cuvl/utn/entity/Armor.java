package ar.com.cuvl.utn.entity;

import ar.com.cuvl.utn.enums.Attack;

public class Armor extends Elements {

    private int dispRestriction;

    public Armor(String name, int cantDanio, Attack ataque, int dispRestriction) {
        super(name, cantDanio, ataque);
        this.dispRestriction = dispRestriction;
    }

    public int getDispRestriction() {
        return dispRestriction;
    }

    public void setDispRestriction(int dispRestriction) {
        this.dispRestriction = dispRestriction;
    }
}
