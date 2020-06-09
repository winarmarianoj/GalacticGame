package ar.com.cuvl.utn.message;

import javax.swing.*;

public class MessageSpinnerHability {
    String[] vector = {"BARBIERI", "YAGO", "MONTI", "CANABARRO",
            "AMADO", "MARIAN", "PIGNATTA", "RAMASCO",
            "ARAUJO", "FANELLI", "FORCINITO"};

    public MessageSpinnerHability () {
        Object seleccion = JOptionPane.showInputDialog(
                null,
                "Seleccione una opción",
                "Lista de Guerreros",JOptionPane.INFORMATION_MESSAGE,null,
                vector,
                null);
    }
}


