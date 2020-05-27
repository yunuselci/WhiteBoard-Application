package com.company;

import javax.swing.*;
import java.awt.*;

public class ServerPanel extends JPanel {
    public static int shapeCounter = 0;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //Draw Square
        if (ServerBoard.drawType.equals("Square")) {
            ++shapeCounter;
            for (int i = 0; i < ServerBoard.square.size(); i++) {
                ServerBoard.sendTheInformationList("Square"); //Send information of drawed shapes
                g.drawRect(ServerBoard.square.get(i).x, ServerBoard.square.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(shapeCounter); // write the counter
            }
            shapeCounter = 0;
        } else if (ServerBoard.drawType.equals("FSquare")) {

            ++shapeCounter;
            for (int i = 0; i < ServerBoard.FSquare.size(); i++) {
                ServerBoard.sendTheInformationList("FSquare");
                g.fillRect(ServerBoard.FSquare.get(i).x, ServerBoard.FSquare.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(shapeCounter);
            }
            shapeCounter = 0;
        } else if (ServerBoard.drawType.equals("Circle") && ServerBoard.typeForCircle == 1) {
            ++shapeCounter;
            for (int i = 0; i < ServerBoard.circle.size(); i++) {
                ServerBoard.sendTheInformationList("Circle");
                g.drawOval(ServerBoard.circle.get(i).x, ServerBoard.circle.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(shapeCounter);
            }
            shapeCounter = 0;
        } else if (ServerBoard.drawType.equals("FCircle")) {
            ++shapeCounter;
            for (int i = 0; i < ServerBoard.FCircle.size(); i++) {
                ServerBoard.sendTheInformationList("FCircle");
                g.fillOval(ServerBoard.FCircle.get(i).x, ServerBoard.FCircle.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(shapeCounter);
            }
            shapeCounter = 0;
        } else if (ServerBoard.drawType.equals("MSquare")) {

            for (int i = 0; i < ServerBoard.squares.size(); i++) {
                ServerBoard.sendTheInformationList("MSquare");
                g.drawRect(ServerBoard.squares.get(i).x, ServerBoard.squares.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(i + 1);
            }
        } else if (ServerBoard.drawType.equals("MCircle")) {

            for (int i = 0; i < ServerBoard.circles.size(); i++) {
                ServerBoard.sendTheInformationList("MCircle");
                g.drawOval(ServerBoard.circles.get(i).x, ServerBoard.circles.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(i + 1);

            }
        } else if (ServerBoard.drawType.equals("Line")) {
            ++shapeCounter;
            for (int i = 0; i < ServerBoard.line.size(); i++) {
                ServerBoard.sendTheInformationList("Line");
                g.drawLine(ServerBoard.line.get(i).x1, ServerBoard.line.get(i).y1,
                        ServerBoard.line.get(i).x2, ServerBoard.line.get(i).y2);
                ServerBoard.writeShapeCounter(shapeCounter);
            }
            shapeCounter = 0;
        } else if (ServerBoard.drawType.equals("Clear")) {

            ServerBoard.sendTheInformationList("Clear");
            g.setColor(Color.WHITE);
            g.fillRect(100, 100, getSize().width, getSize().height);
            shapeCounter = 0;
            ServerBoard.writeShapeCounter(shapeCounter);

        }


    }
}
