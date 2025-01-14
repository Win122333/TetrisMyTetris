package com.vsu.cs.course2.Figures;

import java.awt.*;

public class Ge_Left extends OriginFigure {
    @Override
    public void fillMat() {
        mat = new boolean[4][4];
        mat[0][1] = true;
        mat[0][2] = true;
        mat[1][2] = true;
        mat[2][2] = true;
        mat[3][2] = true;
    }
    @Override
    public void setColor() {
        color = Color.RED;
    }
}
