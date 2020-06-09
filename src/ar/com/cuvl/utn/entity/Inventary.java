package ar.com.cuvl.utn.entity;

public class Inventary {


    private Weapen weapen;
    private Armor armor;

    public Inventary() { }

    public Weapen getWeapen() {
        return weapen;
    }

    public void setWeapen(Weapen weapen) {
        this.weapen = weapen;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
