package ar.com.cuvl.utn.factory;

import ar.com.cuvl.utn.entity.Player;

public class FactoryPlayers {


    MagicFactory magicFactory = new MagicFactory();
    WarriorFactory warriorFactory = new WarriorFactory();

    public Player createPlayer (String name, String typeWarrior) {
        Player player = null;
        if (typeWarrior.equals("MAGE")) {
            player = magicFactory.createObjectPlayers(name);
        } else {
            player = warriorFactory.createObjectPlayers(name);
        }
        return player;
    }
}
