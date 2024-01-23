package org.example.Presentation.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CustomedJFrame extends JFrame {
    JFrame parentFrame;
    public CustomedJFrame(String title, JFrame parentFrame) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(parentFrame.getSize());
        this.setLocation(parentFrame.getLocation());
        this.setLocationRelativeTo(null);
        this.parentFrame = parentFrame;
    }
    public void closeWindow(ActionEvent e) {
        dispose();
        parentFrame.setVisible(true);
    }
}
