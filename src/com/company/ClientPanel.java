package com.company;

import javax.swing.*;
import java.awt.*;

public class ClientPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (ClientBoard.msg[2].equals("Rect")) {
            g.drawRect(Integer.parseInt(ClientBoard.msg[0]),
                    Integer.parseInt(ClientBoard.msg[1]), 150, 150);
        } else if (ClientBoard.msg[2].equals("FRect")) {
            g.fillRect(Integer.parseInt(ClientBoard.msg[0]),
                    Integer.parseInt(ClientBoard.msg[1]), 150, 150);
        } else if (ClientBoard.msg[2].equals("Oval")) {
            g.drawOval(Integer.parseInt(ClientBoard.msg[0]),
                    Integer.parseInt(ClientBoard.msg[1]), 150, 150);
        } else if (ClientBoard.msg[2].equals("FOval")) {
            g.fillOval(Integer.parseInt(ClientBoard.msg[0]),
                    Integer.parseInt(ClientBoard.msg[1]), 150, 150);
        }
        /*
        if (ServerBoard.draw_type == 1){
            for (int i = 0; i < ServerBoard.lines.size(); i++) {
                g.drawLine(ServerBoard.lines.get(i).x1, ServerBoard.lines.get(i).y1,
                        ServerBoard.lines.get(i).x2, ServerBoard.lines.get(i).y2);
            }
        }
        else if(ServerBoard.draw_type == 2){
            for (int i = 0; i < ServerBoard.squares.size(); i++) {
                ServerBoard.send(ServerBoard.squares.get(i).x,ServerBoard.squares.get(i).y,"MRect");

                g.drawRect(ServerBoard.squares.get(i).x, ServerBoard.squares.get(i).y, 150, 150);
            }
        }else if(ServerBoard.draw_type == 3){
            for (int i = 0; i < ServerBoard.squares.size(); i++) {
                ServerBoard.send(ServerBoard.circles.get(i).x,ServerBoard.circles.get(i).y,"MCircle");

                g.drawOval(ServerBoard.circles.get(i).x, ServerBoard.circles.get(i).y, 150, 150);
            }
        }
*/

    }
}
