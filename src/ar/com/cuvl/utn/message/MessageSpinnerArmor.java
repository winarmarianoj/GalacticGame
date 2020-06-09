package ar.com.cuvl.utn.message;

import ar.com.cuvl.utn.entity.Armor;
import ar.com.cuvl.utn.manager.ManagerArmor;

import javax.swing.*;

public class MessageSpinnerArmor {

    ManagerArmor managerArmor = new ManagerArmor();
    String[] vector = { "MEDIAGRUESA", "GRUESA", "MUYGRUESA", "SUPERGRUESA"};


    public String[] llenado (){

        int i=0;

        for (Armor element : managerArmor.getArmorList()){
            String name = element.getName();
            //System.out.println("Elemento de la Lista:" + element.getName());
            this.vector[i] = name;
            //System.out.println("VECTOR :" + vector[i] + i);
            i++;
        }
        return this.vector;
    }

    //JOptionPane.INFORMATION_MESSAGE
    //JOptionPane.QUESTION_MESSAGE

    public MessageSpinnerArmor () {
        Object seleccion = JOptionPane.showInputDialog(
                null,
                "Seleccione una opción",
                "Lista de Guerreros",JOptionPane.INFORMATION_MESSAGE,null,vector,null);
    }


}


