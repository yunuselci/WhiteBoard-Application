package com.company;

import javax.swing.*;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) {
        ClientBoard clientBoard = new ClientBoard("127.0.0.1");
        clientBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientBoard.setVisible(true);
        clientBoard.setSize(800, 600);
        clientBoard.runClient();
    }
}
