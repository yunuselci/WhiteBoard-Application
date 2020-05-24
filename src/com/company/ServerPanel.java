package com.company;

import javax.swing.*;
import java.awt.*;

public class ServerPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(ServerBoard.c);


        if (ServerBoard.draw_type.equals("Square") && ServerBoard.type_for_square == 1) {
            for (int i = 1; i < ServerBoard.square.size(); i++) {
                ServerBoard.sendList("Square");
                g.drawRect(ServerBoard.square.get(i).x, ServerBoard.square.get(i).y, 150, 150);
            }
        } else if (ServerBoard.draw_type.equals("Square") && ServerBoard.type_for_square == 2) {
            ServerBoard.sendList("FSquare");
            g.fillRect(ServerBoard.x, ServerBoard.y, 150, 150);
        } else if (ServerBoard.draw_type.equals("Circle") && ServerBoard.type_for_circle == 1) {
            ServerBoard.sendList("Circle");
            g.drawOval(ServerBoard.x, ServerBoard.y, 150, 150);
        } else if (ServerBoard.draw_type.equals("Circle") && ServerBoard.type_for_circle == 2) {
            ServerBoard.sendList("FCircle");
            g.fillOval(ServerBoard.x, ServerBoard.y, 150, 150);
        } else if (ServerBoard.draw_type.equals("MLine")) {
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
