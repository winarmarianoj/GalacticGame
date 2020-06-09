package ar.com.cuvl.utn.manager;

import ar.com.cuvl.utn.entity.*;
import ar.com.cuvl.utn.enums.Capacity;
import ar.com.cuvl.utn.factory.Factory;
import ar.com.cuvl.utn.factory.FactoryControl;
import ar.com.cuvl.utn.factory.FactoryPlayers;
import ar.com.cuvl.utn.helper.Playing;
import ar.com.cuvl.utn.mapper.Mapper;
import ar.com.cuvl.utn.message.MessageInformation;
import ar.com.cuvl.utn.message.MessageSpinnerArmor;
import ar.com.cuvl.utn.message.MessageSpinnerHability;
import ar.com.cuvl.utn.message.MessageSpinnerWeapen;

import javax.swing.*;

public class Manager {

    Mapper mapper = FactoryControl.createMapper();
    Factory factory = FactoryControl.createFactory();
    FactoryPlayers factoryPlayers = FactoryControl.createPlayer();
    ManagerArmor managerArmor = FactoryControl.createArmor();
    ManagerWeapen managerWeapen = FactoryControl.createWeapen();
    ManagerHability managerHability = FactoryControl.createHability();

    public int cantPlayerGames;
    private Playing playing = new Playing();
    private final static int MIN_ENERGY = 0;


    // FUNCIONES Y METODOS

    public void createAllElements () {
        managerArmor.createArmor();
        managerHability.createHability();
        managerWeapen.createWeapen();
    }

    public void createPlayer() {
        MessageInformation messageInformation = new MessageInformation("INFORMATION","CAN SPAWN UP TO FOUR PLAYERS");
        String amountPlayers = JOptionPane.showInputDialog(null,"ENTER AMOUNT PLAYER : ","AMOUNT PLAYER GAMES",JOptionPane.QUESTION_MESSAGE);
        int amountPlayer = Integer.parseInt(amountPlayers);

        for (int i=1; i<=amountPlayer; i++ ){
            String name = JOptionPane.showInputDialog(null,"ENTER NAME PLAYER : ","DATA PLAYER",JOptionPane.QUESTION_MESSAGE);
            String type = JOptionPane.showInputDialog(null,"ENTER TYPE WARRIOR PLAYER : ","DATA PLAYER",JOptionPane.QUESTION_MESSAGE);
            Player player = factoryPlayers.createPlayer(name,type);
            player.setID(i);

            MessageInformation messageInformation1 = new MessageInformation("INFORMATION","Take note of the position of the element you choose and then enter it");
            MessageSpinnerArmor messageSpinnerArmor = new MessageSpinnerArmor();
            String posArmor = JOptionPane.showInputDialog(null,"ENTER THE POSITION OF THE ARMOR IN THE LIST : ","ARMOR PLAYER GAMES",JOptionPane.QUESTION_MESSAGE);
            //posArmor.trim();
            int posArmorSpinner = Integer.parseInt(posArmor);
            Armor armor = managerArmor.getArmor(posArmorSpinner-1);
            player.setArmor(armor);

            MessageSpinnerWeapen messageSpinnerWeapen = new MessageSpinnerWeapen();
            String posWeapen = JOptionPane.showInputDialog(null,"ENTER THE POSITION OF THE WEAPEN IN THE LIST : ","WEAPEN PLAYER GAMES",JOptionPane.QUESTION_MESSAGE);
            //posWeapen.trim();
            int posWeapenSpinner = Integer.parseInt(posWeapen);
            Weapen weapen = managerWeapen.getWeapen(posWeapenSpinner-1);
            player.setWeapon(weapen);

            MessageSpinnerHability messageSpinnerHability = new MessageSpinnerHability();
            String posHability = JOptionPane.showInputDialog(null,"ENTER THE POSITION OF THE HABILITY IN THE LIST : ","HABILITY PLAYER GAMES",JOptionPane.QUESTION_MESSAGE);
            //posHability.trim();
            int posHabilitySpinner = Integer.parseInt(posHability);
            Hability hability = managerHability.getHability(posHabilitySpinner-1);
            player.setHability(hability);

            String capacityInitial = JOptionPane.showInputDialog(null,"ENTER YOUR INITIAL CAPACITY: ATTACK / MOVE / DEFENSE : ","CAPACITY INITIAL PLAYER GAMES",JOptionPane.QUESTION_MESSAGE);
            addcapacityPlayer(player,capacityInitial);

            String levelPlayer = JOptionPane.showInputDialog(null,"ENTER YOUR INITIAL LEVEL PLAYER : ","LEVEL PLAYER GAMES",JOptionPane.QUESTION_MESSAGE);
            int levelPlayers = Integer.parseInt(levelPlayer);
            player.setLevel(levelPlayers);

            String movePlayer = JOptionPane.showInputDialog(null,"ENTER YOUR INITIAL DISPLACEMENT PLAYER : ","DISPLACEMENT PLAYER GAMES",JOptionPane.QUESTION_MESSAGE);
            int displacement = Integer.parseInt(movePlayer);
            player.setDisplacement(displacement);
            this.cantPlayerGames=i;
            mapper.addPlayerList(player);
        }

    }
    private void addcapacityPlayer (Player player, String capacity) {
        if (capacity.equals("ATTACK")){
            player.setCapacity(Capacity.ATTACK);
        }else if (capacity.equals("DEFENSE")){
            player.setCapacity(Capacity.DEFENSE);
        }else {
            player.setCapacity(Capacity.MOVE);
        }
    }

    private void playerdisplacement (Player moving) {
        int cantDesp = moving.getDisplacement();
        int cantPen = moving.getArmor().getDispRestriction();
        moving.setDisplacement(+cantDesp-cantPen);
    }

    private boolean checkCantPlayer (){
        return mapper.getPlayerSize()>1;
    }

    private void stateDefense (Player defense, Player attack){
        Inventary inventary = new Inventary();

        inventary.setArmor(defense.getArmor());
        inventary.setWeapen(defense.getWeapon());
        attack.addInventaryList(inventary);
        attack.setExperience(attack.getExperience() + defense.getExperience());
    }

    public void game () {
        MessageInformation messageInformation1 = new MessageInformation("START GAME", "WELCOME TO THE GALACTIC GAME LABO III");
        String selectAccion = JOptionPane.showInputDialog(null,"SELECT OPTION: 1=ATTACK / 2=MOVE / 3=EXIT","SELECT ACCION",JOptionPane.QUESTION_MESSAGE);
        int option = Integer.parseInt(selectAccion);
        boolean go = true;

        while (go){

            switch (option){
                case 1:
                    printPlayerTest();
                    String playerAttack = JOptionPane.showInputDialog(null,"SELECT THE ID NUMBER OF THE ATTACKING PLAYER : ","SELECT PLAYER ATTACK",JOptionPane.QUESTION_MESSAGE);
                    int pAttack = Integer.parseInt(playerAttack);
                    Player attack = mapper.getPlayer(pAttack);
                    String playerDefense = JOptionPane.showInputDialog(null,"SELECT THE ID NUMBER OF THE DEFENDING PLAYER: ","SELECT PLAYER DEFENSE",JOptionPane.QUESTION_MESSAGE);
                    int pDefense = Integer.parseInt(playerDefense);
                    Player defense = mapper.getPlayer(pDefense);

                    playing.war(attack,defense);

                    if (defense.getEnergy() <= MIN_ENERGY){
                        stateDefense(defense,attack);
                    }

                    if (checkCantPlayer()){
                        String newSelectAccion = JOptionPane.showInputDialog(null,"SELECT OPTION: 1=ATTACK / 2=MOVE / 3=EXIT","SELECT ACCION",JOptionPane.QUESTION_MESSAGE);
                        option = Integer.parseInt(newSelectAccion);
                    } else {
                        MessageInformation ganador = new MessageInformation("WINNER GAME", "CONGRATULATION!!! THE PLAYER " + attack.getName() + " " + " IS THE WINNER");
                    }
                    break;
                case 2:
                    printPlayerTest();
                    String playerMove = JOptionPane.showInputDialog(null,"SELECT THE ID NUMBER OF THE MOVING PLAYER: ","SELECT PLAYER MOVE",JOptionPane.QUESTION_MESSAGE);
                    int pMove = Integer.parseInt(playerMove);

                    Player pMoving = mapper.getPlayer(pMove);
                    playerdisplacement(pMoving);

                    String newSelectAccion1 = JOptionPane.showInputDialog(null,"SELECT OPTION: 1=ATTACK / 2=MOVE / 3=EXIT","SELECT ACCION",JOptionPane.QUESTION_MESSAGE);
                    option = Integer.parseInt(newSelectAccion1);

                    break;
                case 3:
                    printPlayerTest();
                    go=false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }

        }
    }


    ///////////////////////////////////////////////////////////////
    // PRUEBAS
    public void printPlayerTest () {
        for (Player elemen : mapper.getPlayerList()){
            System.out.println(elemen.getID());
            System.out.println(elemen.getName());
            System.out.println(elemen.getArmor().getName());
            System.out.println(elemen.getArmor().getAtaque());
            System.out.println(elemen.getWeapon().getName());
            System.out.println(elemen.getWeapon().getAtaque());
            System.out.println(elemen.getHability().getName());
            System.out.println("-------------------------------------------------------");
        }
    }

}
