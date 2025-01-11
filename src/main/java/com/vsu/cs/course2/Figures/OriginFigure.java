package com.vsu.cs.course2.Figures;

import java.awt.*;

public abstract class OriginFigure {
    protected Color color;
    protected int position;
    protected int speed;

    public int getPosition() {
        return position;
    }

    public void rotate() {
        position = (position + 1) % 4;
    }
}
