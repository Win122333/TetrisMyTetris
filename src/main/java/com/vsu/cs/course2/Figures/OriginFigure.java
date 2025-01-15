package com.vsu.cs.course2.Figures;

import java.awt.*;

public abstract class OriginFigure {
    protected boolean[][][] mat;
    protected int sizeOfSquare = 30;
    public int x;
    public int y;
    protected Color color;
    protected int position;
    protected int speed;

    public abstract void fillMat();
    public OriginFigure() {
        fillMat();
        setColor();
    }
    public abstract void setColor();

    public int getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public boolean[][][] getMat() {
        return mat;
    }

    public void rotate() {
        position = (position + 1) % 4;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        g2d.setColor(color);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (mat[position][j][i]) {
                    g2d.fillRect(sizeOfSquare + (i + 1) * sizeOfSquare + x, sizeOfSquare + (j + 1) * sizeOfSquare + y, sizeOfSquare, sizeOfSquare);
                }
            }
        }
    }
}
