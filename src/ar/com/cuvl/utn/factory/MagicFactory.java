package ar.com.cuvl.utn.factory;

import ar.com.cuvl.utn.entity.Player;

public class MagicFactory extends CentralPlayerFactory {


    private static final int INIT_EXPERENCE = 0;
    private static final int INIT_ENERGY = 20;

    public MagicFactory () {}

    @Override
    public Player createObjectPlayers(String name) {
        Player player = new Player();
        player.setName(name);
        player.setTypeWarrior("MAGE");
        player.setEnergy(INIT_ENERGY);
        player.setExperience(INIT_EXPERENCE);
        return player;
    }
}
