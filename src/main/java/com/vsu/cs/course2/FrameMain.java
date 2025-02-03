package com.vsu.cs.course2;

import com.vsu.cs.course2.Figures.*;
import com.vsu.cs.course2.Figures.Long;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class FrameMain extends JFrame implements KeyListener {
    private JPanel panelMain;
    private JPanel panelForDraw;
    private int time = 750;
    public static boolean f = false;

    private static final int GLOBAL_TICK = 1000;

    private static final OriginFigure[] ARR_OF_ALL_FIGURES = new OriginFigure[] {new Ge_Left(), new Ge_Right(), new Square(), new Triangle(), new Zet_Left(), new Zet_Right()};
    private GamePlaceholder gamePlaceholder = new GamePlaceholder();
    private OriginFigure currFigure = new Ge_Right();
    private Timer timer = new Timer(time, e -> {
        if (GameplayService.goFigureDown(currFigure, gamePlaceholder)) {
            currFigure = getRandomFigure();
            GameplayService.deleteAllLines(gamePlaceholder);
        }
        repaint();
    });
    private Timer t = new Timer(500, e -> {
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
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        removeAll();

        gamePlaceholder.draw(g);
//        currFigure.goDown();
        currFigure.draw(g);
        revalidate();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                currFigure.rotate();
                repaint();
            }
            case KeyEvent.VK_DOWN -> {
                updateTimer();
            }
            case KeyEvent.VK_LEFT -> {
               GameplayService.goFigureLeft(currFigure, gamePlaceholder);
                repaint();
            }
            case KeyEvent.VK_RIGHT -> {
                GameplayService.goFigureRight(currFigure, gamePlaceholder);
                repaint();
            }
            case KeyEvent.VK_SPACE -> {
                while (!GameplayService.goFigureDown(currFigure, gamePlaceholder)) {

                }
                updateTimer();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN -> {
                updateTimer();
            }
        }
    }
    private void updateTimer() {
        timer.stop();
        timer.setInitialDelay(0);
        timer.start();
    }

    private OriginFigure getRandomFigure() {
        Random rnd = new Random();
        int ind = rnd.nextInt(7);
        switch (ind) {
            case 0 :
                return new Ge_Left();
            case 1:
                return new Ge_Right();
            case 2 :
                return new Square();
            case 3:
                return new Triangle();
            case 4 :
                return new Zet_Left();
            case 5:
                return new Zet_Right();
            case 6:
               return new Long();
        }
        return null;
    }
}
