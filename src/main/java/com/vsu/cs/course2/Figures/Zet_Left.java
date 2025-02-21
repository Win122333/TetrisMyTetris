package com.vsu.cs.course2.Figures;

import com.vsu.cs.course2.OriginFigure;

import java.awt.*;

public class Zet_Left extends OriginFigure {
    @Override
    public void fillMat() {
        mat = new boolean[4][25][10];
        mat[0][0][0] = true;  mat[1][0][1] = true;   mat[2][0][0] = true;  mat[3][0][1] = true;
        mat[0][0][1] = true;  mat[1][1][0] = true;   mat[2][0][1] = true;  mat[3][1][0] = true;
        mat[0][1][1] = true;  mat[1][1][1] = true;   mat[2][1][1] = true;  mat[3][1][1] = true;
        mat[0][1][2] = true;  mat[1][2][0] = true;   mat[2][1][2] = true;  mat[3][2][0] = true;
    }
    @Override
    public void setColor() {
        color = Color.ORANGE;
    }
}
