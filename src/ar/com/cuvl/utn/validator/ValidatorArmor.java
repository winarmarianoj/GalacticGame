package ar.com.cuvl.utn.validator;

import ar.com.cuvl.utn.entity.Armor;
import ar.com.cuvl.utn.enums.Attack;
import ar.com.cuvl.utn.exception.ArmorException;

public class ValidatorArmor {

    public boolean validArmor (Armor armor) throws ArmorException {

        boolean res = false;
        res = validName(armor.getName());
        res &= validDanio(armor.getCantDanio());
        res &= validAtaque(armor.getAtaque());
        res &= validRestriction(armor.getDispRestriction());

        if (res){
            return true;
        }else {
            throw new ArmorException();
        }

    }
    private boolean validName (String name) { return name != null;}
    private boolean validDanio (int danio) { return danio>0;}
    private boolean validAtaque (Attack ataque) { return ataque != null;}
    private boolean validRestriction (int dispRestriction) { return dispRestriction>0;}

}
