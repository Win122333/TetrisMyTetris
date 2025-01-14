package com.vsu.cs.course2;

import com.vsu.cs.course2.Figures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FrameMain extends JFrame implements KeyListener {
    private JPanel panelMain;
    private JPanel panelForDraw;
    private OriginFigure currFigure;
    public static boolean fl = false;

    public FrameMain() {
        setBounds(700, 100, 500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelMain);
        setTitle("TetrisMyTetris");
        setVisible(true);
        panelForDraw.setVisible(true);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        GamePlaceholder gp = new GamePlaceholder();
        gp.drawGamePlaceholder(g);
        Zet_Right t = new Zet_Right();
        t.draw(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println(1);
        }
    }
}
