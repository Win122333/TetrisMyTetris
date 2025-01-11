package com.vsu.cs.course2;

import javax.swing.*;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JPanel panelForDraw;

    public FrameMain() {
        setBounds(700, 100, 500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelMain);
        setTitle("TetrisMyTetris");
        setVisible(true);
        panelForDraw.setVisible(true);


        add(new Draw());
    }
}
