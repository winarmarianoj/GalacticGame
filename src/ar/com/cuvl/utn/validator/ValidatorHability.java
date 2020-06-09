package ar.com.cuvl.utn.validator;

import ar.com.cuvl.utn.entity.Hability;
import ar.com.cuvl.utn.exception.HabilityException;

public class ValidatorHability {


    public boolean validHability (Hability hability) throws HabilityException {
        boolean res = true;
        res = validName(hability.getName());
        res &= validLevel(hability.getLevelRequired());
        res &= validPoints(hability.getPointsLevels());
        res &= validType(hability.getType());

        if (res){ return res; }else { throw new HabilityException(); }
    }
    private boolean validName (String name) { return name != null ;}
    private boolean validLevel (int levelRequired) { return levelRequired>0;}
    private boolean validPoints (int pointsLevels) { return pointsLevels>0;}
    private boolean validType (String type) { return !type.isEmpty();}

}
