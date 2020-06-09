package ar.com.cuvl.utn.factory;

import ar.com.cuvl.utn.entity.Player;

public abstract class CentralPlayerFactory {
    public abstract Player createObjectPlayers(String name);
}
