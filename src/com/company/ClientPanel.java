package com.company;

import javax.swing.*;
import java.awt.*;

public class ClientPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (ClientBoard.drawType.equals("Square")) {
            g.drawRect(ClientBoard.cordinates.get(0).x,
                    ClientBoard.cordinates.get(0).y, 150, 150);
        } else if (ClientBoard.drawType.equals("FSquare")) {
            g.fillRect(ClientBoard.cordinates.get(0).x,
                    ClientBoard.cordinates.get(0).y, 150, 150);
        } else if (ClientBoard.drawType.equals("Circle")) {
            g.drawOval(ClientBoard.cordinates.get(0).x,
                    ClientBoard.cordinates.get(0).y, 150, 150);
        } else if (ClientBoard.drawType.equals("FCircle")) {
            g.fillOval(ClientBoard.cordinates.get(0).x,
                    ClientBoard.cordinates.get(0).y, 150, 150);
        }else if (ClientBoard.drawType.equals("MSquare")){
            for (int i = 0; i < ClientBoard.cordinates.size(); i++) {
                g.drawRect(ClientBoard.cordinates.get(i).x, ClientBoard.cordinates.get(i).y, 150, 150);
            }
        }else if(ClientBoard.drawType.equals("MCircle")){
            for (int i = 0; i < ClientBoard.cordinates.size(); i++) {
                g.drawOval(ClientBoard.cordinates.get(i).x, ClientBoard.cordinates.get(i).y, 150, 150);
            }
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
