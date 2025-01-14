package com.vsu.cs.course2.Figures;

import java.awt.*;

public class Triangle extends OriginFigure {
    @Override
    public void fillMat() {
        mat = new boolean[4][4];
        mat[0][2] = true;
        mat[1][1] = true;
        mat[1][2] = true;
        mat[1][3] = true;
    }
    @Override
    public void setColor() {
        color = Color.magenta;
    }
}
