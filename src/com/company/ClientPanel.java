package com.company;

import javax.swing.*;
import java.awt.*;

public class ClientPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(ClientBoard.infos[2].equals("Rect")){
            g.drawRect(Integer.parseInt(ClientBoard.infos[0]),
                    Integer.parseInt(ClientBoard.infos[1]), 150, 150);
        }


    }
}
