package com.shpp.p2p.cs.asadov.assignment13ext;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PaintPanel extends JPanel {

    private BufferedImage img;

    public Dimension getPreferredSize() {
        if (img == null)
            return new Dimension(550,400);
        else
            return new Dimension(img.getWidth(), img.getHeight());
    }

    public void setImage(BufferedImage img) {
        this.img = img;
    }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(img == null)
                g.drawString("Here will be picture",10,20);
            else
                g.drawImage(img, 0, 0, this);
        }
}
