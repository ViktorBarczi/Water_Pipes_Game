package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.controls.Logic;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game(){

        JFrame frame = new JFrame("Water Pipes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        JButton buttonRestart = new JButton("RESTART");
        JButton buttonCheck = new JButton("CHECK");
        Logic logic = new Logic(frame,buttonRestart);
        frame.addKeyListener(logic);

        JPanel sideMenu = new JPanel();
        sideMenu.setBackground(Color.cyan);
        buttonRestart.addActionListener(logic);
        buttonRestart.setFocusable(false);
        buttonCheck.addActionListener(logic);
        buttonCheck.setFocusable(false);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 8, 14, 8);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(2);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(logic);

        sideMenu.setLayout(new GridLayout(1, 5));
        sideMenu.add(logic.getLevelLabel());
        sideMenu.add(buttonRestart);
        sideMenu.add(slider);
        sideMenu.add(buttonCheck);
        sideMenu.add(logic.getBoardSizeLabel());
        frame.add(sideMenu, BorderLayout.PAGE_START);

        frame.setVisible(true);
    }
}
