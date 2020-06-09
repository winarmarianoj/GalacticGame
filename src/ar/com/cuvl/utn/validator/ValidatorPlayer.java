package ar.com.cuvl.utn.validator;

import ar.com.cuvl.utn.entity.Player;
import ar.com.cuvl.utn.exception.PlayerException;

public class ValidatorPlayer {


    private static final int INIT_EXPERENCE = 0;
    private static final int INIT_ENERGY = 20;

    public boolean validPlayer (Player player) throws PlayerException {
        boolean res = true;
        res = validType(player.getTypeWarrior());
        res &= validName(player.getName());
        res &= validExperence(player.getExperience());
        res &= validEnergy(player.getEnergy());

        if (res){ return res;} else { throw new PlayerException();}
    }

    private boolean validType (String type) { return type != null;}
    private boolean validName (String name) { return name != null;}
    private boolean validExperence (int experience) { return experience==INIT_EXPERENCE;}
    private boolean validEnergy (int energy) { return energy==INIT_ENERGY;}

}
