package ar.com.cuvl.utn.factory;

import ar.com.cuvl.utn.manager.Manager;
import ar.com.cuvl.utn.manager.ManagerArmor;
import ar.com.cuvl.utn.manager.ManagerHability;
import ar.com.cuvl.utn.manager.ManagerWeapen;
import ar.com.cuvl.utn.mapper.Mapper;

public final class FactoryControl {

    public static Manager createManager () { return new Manager();}
    public static Mapper createMapper () { return new Mapper();}
    public static Factory createFactory () { return new Factory();}
    public static FactoryPlayers createPlayer () { return new FactoryPlayers();}
    public static ManagerArmor createArmor () { return new ManagerArmor();}
    public static ManagerWeapen createWeapen () { return new ManagerWeapen();}
    public static ManagerHability createHability () { return new ManagerHability();}

}
