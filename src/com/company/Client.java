package com.company;

import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        ClientBoard clientBoard = new ClientBoard("127.0.0.1");
        clientBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientBoard.setVisible(true);
        clientBoard.setSize(1080, 720);
        clientBoard.setResizable(false);
        clientBoard.startTheClient();
    }
}
