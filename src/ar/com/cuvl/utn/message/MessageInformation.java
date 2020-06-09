package ar.com.cuvl.utn.message;

import javax.swing.*;

public class MessageInformation {

    public MessageInformation(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
