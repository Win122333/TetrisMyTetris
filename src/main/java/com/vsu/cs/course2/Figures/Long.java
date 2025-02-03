package com.vsu.cs.course2.Figures;

import com.vsu.cs.course2.OriginFigure;

import java.awt.*;

public class Long extends OriginFigure {

    @Override
    public void fillMat() {
        mat = new boolean[4][25][10];
        mat[0][2][1] = true;  mat[1][1][2] = true;  mat[2][2][1] = true;  mat[3][1][2] = true;
        mat[0][2][2] = true;  mat[1][2][2] = true;  mat[2][2][2] = true;  mat[3][2][2] = true;
        mat[0][2][3] = true;  mat[1][3][2] = true;  mat[2][2][3] = true;  mat[3][3][2] = true;
        mat[0][2][4] = true;  mat[1][4][2] = true;  mat[2][2][4] = true;  mat[3][4][2] = true;

    }

    @Override
    public void setColor() {
        color = Color.CYAN;
    }
}
