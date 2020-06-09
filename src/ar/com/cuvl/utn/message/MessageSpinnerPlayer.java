package ar.com.cuvl.utn.message;

import javax.swing.*;

public class MessageSpinnerPlayer {

    public MessageSpinnerPlayer() {
        Object seleccion = JOptionPane.showInputDialog(
                null,
                "Seleccione una opción",
                "Lista de Guerreros",JOptionPane.INFORMATION_MESSAGE,null,
                new Object[] { "WARRIOR", "MAGE" },
                "opcion 1");
    }
}
