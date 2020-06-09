package ar.com.cuvl.utn.validator;

import ar.com.cuvl.utn.entity.Weapen;
import ar.com.cuvl.utn.enums.Attack;
import ar.com.cuvl.utn.exception.WeapenException;

public class ValidatorWeapen {


    public boolean validatorWeapen (Weapen weapen) throws WeapenException {
        boolean res = true;
        res = validName(weapen.getName());
        res &= validDanio(weapen.getCantDanio());
        res &= validAtaque(weapen.getAtaque());

        if (res){ return res;}else { throw new WeapenException();}
    }
    private boolean validName (String name) { return name != null;}
    private boolean validDanio (int danio) { return danio>0;}
    private boolean validAtaque (Attack ataque) { return ataque != null;}

}
