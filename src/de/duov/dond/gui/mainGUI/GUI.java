package de.duov.dond.gui.mainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    Controller ctrl;
    private JFrame frame;
    private JPanel panel;

    private GUI() {
        ctrl = new Controller();

    }

    public void createGUI() {
        frame = new JFrame();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Deal or no Deal - Main Menu");
        setSize(1080, 1920);
        setLayout(new BorderLayout());
        panel = new JPanel();
        add(panel);
        setResizable(true);
        panel.setPreferredSize(new Dimension(1920, 1080));
        //panel.add(addButton("REGISTER", insert));

    }

    private JButton addButton(final String name, final ActionListener listener) {

        final JButton button = new JButton(name);
        button.addActionListener(listener);
        return button;

    }

}
