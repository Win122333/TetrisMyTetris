package com.vsu.cs.course2;

import com.vsu.cs.course2.Figures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class FrameMain extends JFrame implements KeyListener {
    private JPanel panelMain;
    private JPanel panelForDraw;

    private static final OriginFigure[] ARR_OF_ALL_FIGURES = new OriginFigure[] {new Ge_Left(), new Ge_Right(), new Square(), new Triangle(), new Zet_Left(), new Zet_Right()};
    private OriginFigure currFigure = new Zet_Left();
    private final Timer timer = new Timer(1000, e -> {
        currFigure = ARR_OF_ALL_FIGURES[new Random().nextInt(ARR_OF_ALL_FIGURES.length)];
        repaint();
    });

    public FrameMain() {
        setBounds(700, 100, 500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelMain);
        setTitle("TetrisMyTetris");
        setVisible(true);
        panelForDraw.setVisible(true);
        addKeyListener(this);


        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        removeAll();
        GamePlaceholder gp = new GamePlaceholder();
        gp.drawGamePlaceholder(g);
        currFigure.draw(g);
        revalidate();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            currFigure.rotate();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

        }
    }
}
