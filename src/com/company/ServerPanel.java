package com.company;

import javax.swing.*;
import java.awt.*;

public class ServerPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(ServerBoard.c);

        if(!ServerBoard.isMultiple) {
            if(ServerBoard.draw_type.equals("Rect") && ServerBoard.type_for_square == 1) {
                ServerBoard.sendArray(ServerBoard.x,ServerBoard.y,"Rect");
                g.drawRect(ServerBoard.x, ServerBoard.y, 150, 150);

            }
            else if(ServerBoard.draw_type.equals("Rect") && ServerBoard.type_for_square == 2) {
                ServerBoard.sendArray(ServerBoard.x,ServerBoard.y,"FRect");
                g.fillRect(ServerBoard.x, ServerBoard.y, 150, 150);
            }
            else if(ServerBoard.draw_type.equals("Oval") && ServerBoard.type_for_circle == 1) {
                ServerBoard.sendArray(ServerBoard.x,ServerBoard.y,"Oval");

                g.drawOval(ServerBoard.x, ServerBoard.y, 150, 150);
            }
            else if(ServerBoard.draw_type.equals("Oval") && ServerBoard.type_for_circle == 2) {
                ServerBoard.sendArray(ServerBoard.x,ServerBoard.y,"FOval");

                g.fillOval(ServerBoard.x, ServerBoard.y, 150, 150);
            }
        }
        else {
            if (ServerBoard.draw_type.equals("MLine")){

                for (int i = 0; i < ServerBoard.lines.size(); i++) {
                    g.drawLine(ServerBoard.lines.get(i).x1, ServerBoard.lines.get(i).y1,
                            ServerBoard.lines.get(i).x2, ServerBoard.lines.get(i).y2);
                }
            }
            else if(ServerBoard.draw_type.equals("MRect")){
                for (int i = 0; i < ServerBoard.squares.size(); i++) {
                    //ServerBoard.sendArray(ServerBoard.squares.get(i).x,ServerBoard.squares.get(i).y,"MRect");
                    g.drawRect(ServerBoard.squares.get(i).x, ServerBoard.squares.get(i).y, 150, 150);
                    ServerBoard.sendList("MRect");

                }
            }else if(ServerBoard.draw_type.equals("MOval")){
                for (int i = 0; i < ServerBoard.circles.size(); i++) {
                    //ServerBoard.sendArray(ServerBoard.circles.get(i).x,ServerBoard.circles.get(i).y,"MCircle");
                    g.drawOval(ServerBoard.circles.get(i).x, ServerBoard.circles.get(i).y, 150, 150);
                    ServerBoard.sendList("MOval");
                }
            }

        }
    }
}
