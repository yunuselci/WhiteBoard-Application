package com.company;

import javax.swing.*;
import java.awt.*;

public class ClientPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        switch (ClientBoard.drawType) {
            case "Square":
                g.drawRect(ClientBoard.cordinates.get(0).x,
                        ClientBoard.cordinates.get(0).y, 150, 150);

                break;
            case "FSquare":
                g.fillRect(ClientBoard.cordinates.get(0).x,
                        ClientBoard.cordinates.get(0).y, 150, 150);
                break;
            case "Circle":
                g.drawOval(ClientBoard.cordinates.get(0).x,
                        ClientBoard.cordinates.get(0).y, 150, 150);
                break;
            case "FCircle":
                g.fillOval(ClientBoard.cordinates.get(0).x,
                        ClientBoard.cordinates.get(0).y, 150, 150);
                break;
            case "MSquare":
                for (int i = 0; i < ClientBoard.cordinates.size(); i++) {
                    g.drawRect(ClientBoard.cordinates.get(i).x, ClientBoard.cordinates.get(i).y, 150, 150);
                }
                break;
            case "MCircle":
                for (int i = 0; i < ClientBoard.cordinates.size(); i++) {
                    g.drawOval(ClientBoard.cordinates.get(i).x, ClientBoard.cordinates.get(i).y, 150, 150);
                }
                break;
            case "Line":
                    g.drawLine(ClientBoard.cordinates.get(0).x1, ClientBoard.cordinates.get(0).y1,
                            ClientBoard.cordinates.get(0).x2, ClientBoard.cordinates.get(0).y2);
                break;
            case "Clear":
                g.setColor(Color.WHITE);
                g.fillRect(100,100,getSize().width,getSize().height);
            case "Time":
                for (int i = 0; i < ClientBoard.cordinates.size(); i++) {
                    ClientBoard.min = ClientBoard.cordinates.get(i).min;
                    ClientBoard.sec = ClientBoard.cordinates.get(i).sec;
                }
                ClientBoard.displayTime();

        }



    }
}
