package ar.com.cuvl.utn.message;

import javax.swing.*;

public class MessageSpinnerWeapen {

    String[] vector = {"UNO", "DOS", "TRES", "CUATRO"};

    public MessageSpinnerWeapen () {

        Object seleccion = JOptionPane.showInputDialog(
                null,
                "Seleccione una opción",
                "Lista de Guerreros",JOptionPane.INFORMATION_MESSAGE,null,
                vector,
                null);
    }
}

