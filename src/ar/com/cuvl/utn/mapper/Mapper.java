package ar.com.cuvl.utn.mapper;

import ar.com.cuvl.utn.entity.Armor;
import ar.com.cuvl.utn.entity.Player;
import ar.com.cuvl.utn.message.MessageError;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private List<String> exceptionList;
    private List<Player> playerList;

    public Mapper () {}

    // GETTERS AND SETTERS LISTS


    public List<String> getExceptionList () {
        if (exceptionList==null){
            exceptionList = new ArrayList<>();
        }
        return exceptionList;
    }
    public void addException (String message) {
        if (exceptionList == null){
            exceptionList = new ArrayList<>();
        }
        exceptionList.add(message);
    }

    public int getPlayerSize () {
        if (playerList == null){
            playerList = new ArrayList<>();
        }
        return playerList.size();
    }
    public Player getPlayer (int index) {
        if (index < 0 || index >= playerList.size()){
            return null;
        }
        return playerList.get(index);
    }

    public List<Player> getPlayerList () {
        if (playerList == null){
            playerList = new ArrayList<>();
        }
        return playerList;
    }

    public void addPlayerList(Player player) {
        if (playerList == null){
            playerList = new ArrayList<>();
        }
        playerList.add(player);
    }

    public boolean removePlayer (int index) {
        if (index <0 || index >= playerList.size()){
            return false;
        }
        playerList.remove(index);
        return true;
    }


    ////////////////////////////////////////////////////////////////

    // METODOS Y FUNCIONES


    public Player getLastPlayer () {
        return getPlayer(getPlayerSize() - 1);
    }

    public String playerToString() {
        String texto = "";
        if (playerList!=null){
            Player player = getLastPlayer();
            texto = player.getName() + "//" + player.getTypeWarrior() + "/";
        }
        return texto;
    }

    public void createStringPlayerJList(JList<String> playerJList, DefaultListModel<String> model) {
        for (Player element : getPlayerList()){
            model.addElement(element.getName());
            playerJList.setModel(model);
        }
    }

    public void save (){

    }
    public void printException () {
        for (String a : getExceptionList()){
            System.out.println(a);
        }
    }

    public Player searchPlayer(String namePlayer) {
        boolean found = false;
        Player player = null;

        for (int i=0; i<getPlayerSize() && !found; i++){
            player = getPlayer(i);
            found = player.getName().equals(namePlayer);
        }
        if (!found){
            MessageError messageError = new MessageError("FAILED SEARCHING PLAYER", "THE PLAYER IS NOT IN THIS LIST");
        }
        return player;
    }



}
