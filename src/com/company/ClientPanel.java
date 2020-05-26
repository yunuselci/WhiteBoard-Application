package com.company;

import javax.swing.*;
import java.awt.*;

public class ClientPanel extends JPanel {
    public static int shapeCounter;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        switch (ClientBoard.drawType) {
            case "Square":
                g.drawRect(ClientBoard.infos.get(0).x,
                        ClientBoard.infos.get(0).y, 150, 150);
                ++shapeCounter;
                ClientBoard.writeShapeCounter(shapeCounter);
                shapeCounter = 0;
                break;
            case "FSquare":
                g.fillRect(ClientBoard.infos.get(0).x,
                        ClientBoard.infos.get(0).y, 150, 150);
                ++shapeCounter;
                ClientBoard.writeShapeCounter(shapeCounter);
                shapeCounter = 0;
                break;
            case "Circle":
                g.drawOval(ClientBoard.infos.get(0).x,
                        ClientBoard.infos.get(0).y, 150, 150);
                ++shapeCounter;
                ClientBoard.writeShapeCounter(shapeCounter);
                shapeCounter = 0;
                break;
            case "FCircle":
                g.fillOval(ClientBoard.infos.get(0).x,
                        ClientBoard.infos.get(0).y, 150, 150);
                ++shapeCounter;
                ClientBoard.writeShapeCounter(shapeCounter);
                shapeCounter = 0;
                break;
            case "MSquare":
                for (int i = 0; i < ClientBoard.infos.size(); i++) {
                    g.drawRect(ClientBoard.infos.get(i).x, ClientBoard.infos.get(i).y, 150, 150);
                    ClientBoard.writeShapeCounter(i + 1);

                }

                break;
            case "MCircle":
                for (int i = 0; i < ClientBoard.infos.size(); i++) {
                    g.drawOval(ClientBoard.infos.get(i).x, ClientBoard.infos.get(i).y, 150, 150);
                    ClientBoard.writeShapeCounter(i + 1);
                }
                break;
            case "Line":
                g.drawLine(ClientBoard.infos.get(0).x1, ClientBoard.infos.get(0).y1,
                        ClientBoard.infos.get(0).x2, ClientBoard.infos.get(0).y2);
                ++shapeCounter;
                ClientBoard.writeShapeCounter(shapeCounter);
                shapeCounter = 0;
                break;
            case "Clear":
                g.setColor(Color.WHITE);
                g.fillRect(100, 100, getSize().width, getSize().height);
                shapeCounter = 0;
                ClientBoard.writeShapeCounter(shapeCounter);
            case "Time":
                for (int i = 0; i < ClientBoard.infos.size(); i++) {
                    ClientBoard.min = ClientBoard.infos.get(i).min;
                    ClientBoard.sec = ClientBoard.infos.get(i).sec;
                }
                ClientBoard.displayTime();

        }


    }
}
