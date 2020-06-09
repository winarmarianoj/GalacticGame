package ar.com.cuvl.utn;

import ar.com.cuvl.utn.factory.FactoryControl;
import ar.com.cuvl.utn.manager.Manager;

public class Main {

    public static void main(String[] args) {

        Manager manager = FactoryControl.createManager();
        manager.createAllElements();
        manager.createPlayer();
        manager.game();

    }
}
