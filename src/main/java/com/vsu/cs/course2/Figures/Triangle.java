package com.vsu.cs.course2.Figures;

import java.awt.*;

public class Triangle extends OriginFigure {
    @Override
    public void fillMat() {
        mat = new boolean[25][10][4];
        mat[0][0][2] = true;  mat[1][0][2] = true;  mat[2][1][1] = true;  mat[3][0][2] = true;
        mat[0][1][1] = true;  mat[1][1][2] = true;  mat[2][1][2] = true;  mat[3][1][1] = true;
        mat[0][1][2] = true;  mat[1][1][3] = true;  mat[2][1][3] = true;  mat[3][1][2] = true;
        mat[0][1][3] = true;  mat[1][2][2] = true;  mat[2][2][2] = true;  mat[3][2][2] = true;
    }
    @Override
    public void setColor() {
        color = Color.magenta;
    }
}
