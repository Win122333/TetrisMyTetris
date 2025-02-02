package com.vsu.cs.course2.Figures;

import com.vsu.cs.course2.OriginFigure;

import java.awt.*;

public class Ge_Left extends OriginFigure {
    @Override
    public void fillMat() {
        mat = new boolean[4][25][10];
        mat[0][0][1] = true;  mat[1][2][0] = true;  mat[2][0][2] = true;  mat[3][2][0] = true;
        mat[0][0][2] = true;  mat[1][2][1] = true;  mat[2][1][2] = true;  mat[3][2][1] = true;
        mat[0][1][2] = true;  mat[1][2][2] = true;  mat[2][2][2] = true;  mat[3][2][2] = true;
        mat[0][2][2] = true;  mat[1][2][3] = true;  mat[2][3][2] = true;  mat[3][2][3] = true;
        mat[0][3][2] = true;  mat[1][1][3] = true;  mat[2][3][3] = true;  mat[3][3][0] = true;
    }
    @Override
    public void setColor() {
        color = Color.RED;
    }
}
