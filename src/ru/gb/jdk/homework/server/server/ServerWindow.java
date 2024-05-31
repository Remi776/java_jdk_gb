package ru.gb.jdk.homework.server.server;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ServerWindow extends JFrame implements ServerView{
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private ServerController serverController;


    public ServerWindow() {

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.start();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.stop();
            }
        });

        log.setEditable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        add(new JScrollPane(log));
        JPanel controlButtons = new JPanel(new GridLayout(1, 2));
        controlButtons.add(btnStart);
        controlButtons.add(btnStop);
        add(controlButtons, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void showMessage(String message) {
        log.append(message);
    }

    @Override
    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
    }
}
