package ru.gb.jdk.tictactoe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;

    private int currentSize;

    JButton btnStart;

    JPanel gameModePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        Label label = new Label("Выберите режим игры");
        JRadioButton radioButton1 = new JRadioButton("Человек против компьютера");
        JRadioButton radioButton2 = new JRadioButton("Человек против человека");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        panel.add(label);
        panel.add(radioButton1);
        panel.add(radioButton2);
        return panel;
    }

    JPanel fieldSizeSliderPanel() {

        JPanel panel = new JPanel(new GridLayout(3, 1));
        JSlider slider = new JSlider(3, 10, 3);
        Label setFieldSizeLabel = new Label("Установленный размер поля" + currentSize);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentSize = slider.getValue();
                setFieldSizeLabel.setText("Установленный размер поля" + currentSize);
            }
        });
        Label fieldSize = new Label("Выберите размер поля");


        panel.add(fieldSize);
        panel.add(setFieldSizeLabel);
        panel.add(slider);
        return panel;
    }

    JPanel winCountForVictoryPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        Label setFieldSizeLabel = new Label("Установленная длина: " + currentSize);
        JSlider slider = new JSlider(3, 10, 3);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentSize = slider.getValue();
                setFieldSizeLabel.setText("Установленная длина: " + currentSize);
            }
        });
        Label fieldSize = new Label("Выберите длину для победы");
        panel.add(fieldSize);
        panel.add(setFieldSizeLabel);
        panel.add(slider);
        return panel;
    }


    SettingWindow(GameWindow gameWindow) {
        btnStart = new JButton("Start new game");

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(gameModePanel());
        panel.add(fieldSizeSliderPanel());
        panel.add(winCountForVictoryPanel());
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(0, 3, 3, 3);
            }
        });
        add(panel);
        add(btnStart, BorderLayout.SOUTH);
    }
}
