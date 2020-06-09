package ar.com.cuvl.utn.helper;

import ar.com.cuvl.utn.entity.Player;
import ar.com.cuvl.utn.enums.Attack;
import ar.com.cuvl.utn.enums.TypeWarrior;

public class Playing {

    public void war (Player ataca, Player defiende) {
        int damage = 0;
//        String armaduraDefiende = String.valueOf(defiende.getArmor().getAtaque());
//        String armaAtaca = String.valueOf(ataca.getWeapon().getAtaque());

        if (ataca.getWeapon().getAtaque().equals(defiende.getArmor().getAtaque())
            || defiende.getArmor().getAtaque().equals(Attack.MAGICO)){
            int pointsDefenseSum = getCapacityDefensePoints(defiende);
            int sumDamage = getCapacityDamage(ataca);
            damage = ataca.getWeapon().getCantDanio() + sumDamage;
            damage -= defiende.getArmor().getCantDanio();
            damage -= pointsDefenseSum;
        } else {
            damage = ataca.getWeapon().getCantDanio();
        }
//        if ( damage < 0){
//            damage = -1 * damage;
//        }
        defiende.setEnergy(defiende.getEnergy() - damage);
        ataca.setEnergy(ataca.getEnergy() + defiende.getExperience() - damage);
    }

    public int getCapacityDefensePoints (Player defense){
        int cant=0;
        cant += defense.getArmor().getCantDanio();
        if (defense.getHability().getType().equals("DEFENSA")){
            cant += defense.getHability().getPointsLevels();
        }
        return cant;
    }

    public int getCapacityDamage (Player attack) {
        int cant=0;
        cant += attack.getWeapon().getCantDanio();
        if (attack.getHability().getType().equals("ATAQUE")){
            cant += attack.getHability().getPointsLevels();
        }
        return cant;
    }

}
