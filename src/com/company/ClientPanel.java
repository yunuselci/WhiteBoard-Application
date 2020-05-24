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
        }

        /*
        if (ServerBoard.draw_type == 1){
            for (int i = 0; i < ServerBoard.lines.size(); i++) {
                g.drawLine(ServerBoard.lines.get(i).x1, ServerBoard.lines.get(i).y1,
                        ServerBoard.lines.get(i).x2, ServerBoard.lines.get(i).y2);
            }
        }

*/

    }
}
