package com.vsu.cs.course2.Figures;

import java.awt.*;

public class Ge_Right extends OriginFigure {
    @Override
    public void fillMat() {
        mat = new boolean[4][4];
        mat[0][1] = true;
        mat[0][2] = true;
        mat[1][1] = true;
        mat[2][1] = true;
        mat[3][1] = true;
    }
    @Override
    public void setColor() {
            color = Color.BLUE;
    }
}
