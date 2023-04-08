package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.controls.Logic;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game(){

        JFrame frame = new JFrame("Reversi!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,890);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        Logic logic = new Logic(/*frame*/);
        frame.addKeyListener(logic);

        JPanel sideMenu = new JPanel();
        sideMenu.setBackground(Color.LIGHT_GRAY);
        JButton buttonRestart = new JButton("RESTART");
        buttonRestart.addActionListener(logic);
        buttonRestart.setFocusable(false);
        JButton buttonCheck = new JButton("CHECK");
        buttonCheck.addActionListener(logic);
        buttonCheck.setFocusable(false);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 8, 14, 8);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(2);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(logic);

        sideMenu.setLayout(new GridLayout(3, 2));
        sideMenu.add(buttonRestart);
        sideMenu.add(slider);
        sideMenu.add(buttonCheck);
        frame.add(sideMenu, BorderLayout.PAGE_START);

        frame.setVisible(true);

    }
}
