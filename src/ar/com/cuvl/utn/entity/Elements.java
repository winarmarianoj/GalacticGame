package ar.com.cuvl.utn.entity;

import ar.com.cuvl.utn.enums.Attack;

public abstract class Elements {

    private String name;
    private int cantDanio;
    private Attack ataque;

    public Elements(String name, int cantDanio, Attack ataque) {
        this.name = name;
        this.cantDanio = cantDanio;
        this.ataque = ataque;
    }

    public Elements () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantDanio() {
        return cantDanio;
    }

    public void setCantDanio(int cantDanio) {
        this.cantDanio = cantDanio;
    }

    public Attack getAtaque() {
        return ataque;
    }

    public void setAtaque(Attack ataque) {
        this.ataque = ataque;
    }
}
