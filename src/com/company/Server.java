package com.company;

import javax.swing.*;

public class Server {

    public static void main(String[] args) {
        ServerBoard serverBoard = new ServerBoard();
        serverBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverBoard.setVisible(true);
        serverBoard.setSize(1080, 720);
        serverBoard.setResizable(false);
        serverBoard.startTheServer();
    }
}
