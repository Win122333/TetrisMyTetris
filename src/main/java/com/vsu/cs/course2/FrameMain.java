package com.vsu.cs.course2;

import com.vsu.cs.course2.Figures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrameMain extends JFrame implements KeyListener {
    private JPanel panelMain;
    private JPanel panelForDraw;
    private int time = 1000;

    private static final int GLOBAL_TICK = 1000;

    private static final OriginFigure[] ARR_OF_ALL_FIGURES = new OriginFigure[] {new Ge_Left(), new Ge_Right(), new Square(), new Triangle(), new Zet_Left(), new Zet_Right()};
    private GamePlaceholder gamePlaceholder = new GamePlaceholder();
    private OriginFigure currFigure = new Zet_Left();

    private Timer timer = new Timer(time, e -> {
//        currFigure = ARR_OF_ALL_FIGURES[new Random().nextInt(ARR_OF_ALL_FIGURES.length)];
        currFigure.y = currFigure.y + 30;
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
        System.out.println(GameplayService.isCollision(currFigure, gamePlaceholder));
        if (GameplayService.isCollision(currFigure, gamePlaceholder)) {
            GameplayService.addFigureToPlaceholder(currFigure, gamePlaceholder);
            currFigure = new Triangle();
        }
        gamePlaceholder.allFiguresOnGame[17][4] = currFigure;
        gamePlaceholder.allFiguresOnGame[18][4] = currFigure;
        gamePlaceholder.allFiguresOnGame[17][5] = currFigure;

        gamePlaceholder.allFiguresOnGame[6][3] = new Ge_Right();
        gamePlaceholder.draw(g);
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
//                updateTimer();
                currFigure.goDown();
                System.out.println(currFigure.getPosition());
            }
            case KeyEvent.VK_LEFT -> {
//                currFigure.x = currFigure.x - 30;
                currFigure.goLeft();
                repaint();
            }
            case KeyEvent.VK_RIGHT -> {
//                currFigure.x = currFigure.x +30;
                currFigure.goRight();
                repaint();
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
}
