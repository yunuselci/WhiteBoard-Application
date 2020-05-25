package com.company;

import javax.swing.*;
import java.awt.*;

public class ServerPanel extends JPanel {
    public static int shapeCounter=0;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(ServerBoard.c);

        if (ServerBoard.draw_type.equals("Square")) {
            ++shapeCounter;
            for (int i = 0; i < ServerBoard.square.size(); i++) {
                ServerBoard.sendList("Square");
                g.drawRect(ServerBoard.square.get(i).x, ServerBoard.square.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(shapeCounter);
            }
            shapeCounter = 0;
        } else if (ServerBoard.draw_type.equals("FSquare")) {

            ++shapeCounter;
            for (int i = 0; i < ServerBoard.FSquare.size(); i++) {
                ServerBoard.sendList("FSquare");
                g.fillRect(ServerBoard.FSquare.get(i).x, ServerBoard.FSquare.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(shapeCounter);
            }
            shapeCounter = 0;
        } else if (ServerBoard.draw_type.equals("Circle") && ServerBoard.type_for_circle == 1) {
            ++shapeCounter;
            for (int i = 0; i < ServerBoard.circle.size(); i++) {
                ServerBoard.sendList("Circle");
                g.drawOval(ServerBoard.circle.get(i).x,ServerBoard.circle.get(i).y,150,150);
                ServerBoard.writeShapeCounter(shapeCounter);
            }
            shapeCounter = 0;
        } else if(ServerBoard.draw_type.equals("FCircle")){
            ++shapeCounter;
            for (int i = 0; i < ServerBoard.FCircle.size(); i++) {
                ServerBoard.sendList("FCircle");
                g.fillOval(ServerBoard.FCircle.get(i).x,ServerBoard.FCircle.get(i).y,150,150);
                ServerBoard.writeShapeCounter(shapeCounter);
            }
            shapeCounter = 0;
        }
         else if (ServerBoard.draw_type.equals("MSquare")) {

            for (int i = 0; i < ServerBoard.squares.size(); i++) {
                ServerBoard.sendList("MSquare");
                g.drawRect(ServerBoard.squares.get(i).x, ServerBoard.squares.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(i+1);
            }
        } else if (ServerBoard.draw_type.equals("MCircle")) {

            for (int i = 0; i < ServerBoard.circles.size(); i++) {
                ServerBoard.sendList("MCircle");
                g.drawOval(ServerBoard.circles.get(i).x, ServerBoard.circles.get(i).y, 150, 150);
                ServerBoard.writeShapeCounter(i+1);

            }
        }else if(ServerBoard.draw_type.equals("Line")){
            ++shapeCounter;
            for (int i = 0; i <ServerBoard.line.size(); i++) {
                ServerBoard.sendList("Line");
                g.drawLine(ServerBoard.line.get(i).x1,ServerBoard.line.get(i).y1,
                        ServerBoard.line.get(i).x2,ServerBoard.line.get(i).y2);
                ServerBoard.writeShapeCounter(shapeCounter);
            }
            shapeCounter = 0;
        }
        else if(ServerBoard.draw_type.equals("Clear")){

                ServerBoard.sendList("Clear");
                g.setColor(Color.WHITE);
                g.fillRect(100,100,getSize().width,getSize().height);
                shapeCounter=0;
                ServerBoard.writeShapeCounter(shapeCounter);

        }


    }
}
