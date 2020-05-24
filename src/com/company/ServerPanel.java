package com.company;

import javax.swing.*;
import java.awt.*;

public class ServerPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(ServerBoard.c);


        if (ServerBoard.draw_type.equals("Square")) {
            for (int i = 1; i < ServerBoard.square.size(); i++) {
                ServerBoard.sendList("Square");
                g.drawRect(ServerBoard.square.get(i).x, ServerBoard.square.get(i).y, 150, 150);
            }
        } else if (ServerBoard.draw_type.equals("FSquare")) {
            for (int i = 1; i < ServerBoard.FSquare.size(); i++) {
                ServerBoard.sendList("FSquare");
                g.fillRect(ServerBoard.FSquare.get(i).x, ServerBoard.FSquare.get(i).y, 150, 150);
            }
        } else if (ServerBoard.draw_type.equals("Circle") && ServerBoard.type_for_circle == 1) {
            for (int i = 1; i < ServerBoard.circle.size(); i++) {
                ServerBoard.sendList("Circle");
                g.drawOval(ServerBoard.circle.get(i).x,ServerBoard.circle.get(i).y,150,150);
            }
        } else if(ServerBoard.draw_type.equals("FCircle")){
            for (int i = 0; i < ServerBoard.FCircle.size(); i++) {
                ServerBoard.sendList("FCircle");
                g.fillOval(ServerBoard.FCircle.get(i).x,ServerBoard.FCircle.get(i).y,150,150);
            }
        }
        else if (ServerBoard.draw_type.equals("MLine")) {
            for (int i = 0; i < ServerBoard.lines.size(); i++) {
                g.drawLine(ServerBoard.lines.get(i).x1, ServerBoard.lines.get(i).y1,
                        ServerBoard.lines.get(i).x2, ServerBoard.lines.get(i).y2);
            }
        } else if (ServerBoard.draw_type.equals("MSquare")) {
            for (int i = 0; i < ServerBoard.squares.size(); i++) {
                ServerBoard.sendList("MSquare");
                g.drawRect(ServerBoard.squares.get(i).x, ServerBoard.squares.get(i).y, 150, 150);
            }
        } else if (ServerBoard.draw_type.equals("MCircle")) {
            for (int i = 0; i < ServerBoard.circles.size(); i++) {
                ServerBoard.sendList("MCircle");
                g.drawOval(ServerBoard.circles.get(i).x, ServerBoard.circles.get(i).y, 150, 150);
            }
        }


    }
}
