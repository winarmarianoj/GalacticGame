package ar.com.cuvl.utn.factory;

import ar.com.cuvl.utn.entity.Player;

public class WarriorFactory extends CentralPlayerFactory {


    private static final int INIT_EXPERENCE = 0;
    private static final int INIT_ENERGY = 20;

    public WarriorFactory () {}

    @Override
    public Player createObjectPlayers(String name) {
        Player player = new Player();
        player.setName(name);
        player.setTypeWarrior("WARRIOR");
        player.setExperience(INIT_EXPERENCE);
        player.setEnergy(INIT_ENERGY);
        return player;
    }
}
