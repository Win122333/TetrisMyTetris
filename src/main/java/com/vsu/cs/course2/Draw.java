package com.vsu.cs.course2;

import javax.swing.*;
import java.awt.*;

public class Draw extends JComponent {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 1000, 1000);
    }
}
