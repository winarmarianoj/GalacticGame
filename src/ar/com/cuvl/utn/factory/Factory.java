package ar.com.cuvl.utn.factory;

import ar.com.cuvl.utn.entity.Armor;
import ar.com.cuvl.utn.entity.Hability;
import ar.com.cuvl.utn.entity.Weapen;
import ar.com.cuvl.utn.enums.Attack;

public class Factory {

    public Armor createArmor (String name, int cantDefense, Attack ataque, int dispRestriction){
        return new Armor(name,cantDefense,ataque,dispRestriction);
    }

    public Hability createHability (String name, int levelRequired, int pointsLevels, String type){
        return new Hability(name,levelRequired,pointsLevels,type);
    }

    public Weapen createWeapen (String name, int cantDanio, Attack ataque){
        return new Weapen(name, cantDanio, ataque);
    }
}
