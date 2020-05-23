package com.company;

import javax.swing.*;
import java.awt.*;

public class ServerPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(ServerBoard.c);

        if(!ServerBoard.flag) {
            if(ServerBoard.type_for_square == 1) {
                ServerBoard.send(ServerBoard.x,ServerBoard.y,"Rect");
                g.drawRect(ServerBoard.x, ServerBoard.y, 150, 150);

            }
            else if(ServerBoard.type_for_square == 2) {
                g.fillRect(ServerBoard.x, ServerBoard.y, 150, 150);
            }
            else if(ServerBoard.type_for_circle == 1) {
                g.drawOval(ServerBoard.x, ServerBoard.y, 150, 150);
            }
            else if(ServerBoard.type_for_circle == 2) {
                g.fillOval(ServerBoard.x, ServerBoard.y, 150, 150);
            }
        }
        else {
            if (ServerBoard.draw_type == 1){
                for (int i = 0; i < ServerBoard.lines.size(); i++) {
                    g.drawLine(ServerBoard.lines.get(i).x1, ServerBoard.lines.get(i).y1,
                            ServerBoard.lines.get(i).x2, ServerBoard.lines.get(i).y2);
                }
            }
            else if(ServerBoard.draw_type == 2){
                for (int i = 0; i < ServerBoard.squares.size(); i++) {
                    g.drawRect(ServerBoard.squares.get(i).x, ServerBoard.squares.get(i).y, 150, 150);
                }
            }else if(ServerBoard.draw_type == 3){
                for (int i = 0; i < ServerBoard.squares.size(); i++) {
                    g.drawOval(ServerBoard.circles.get(i).x, ServerBoard.circles.get(i).y, 150, 150);
                }
            }

        }
    }
}
