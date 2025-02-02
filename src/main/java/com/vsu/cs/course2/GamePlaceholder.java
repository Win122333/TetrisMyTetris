package com.vsu.cs.course2;

import java.awt.*;

public class GamePlaceholder {
    public static final int HEIGHT = 20;
    public static final int WIDTH = 10;
    private static final int START_X = -30;
    private static final int START_Y = 120;

    private static final int SIZE_OF_SQUARE = 30;

    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color LINE_COLOR = Color.ORANGE;

    public OriginFigure[][] allFiguresOnGame = new OriginFigure[HEIGHT][WIDTH];

    public void draw (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, 0, 1000, 1000);
        g2d.fillRect(0, 0, 1000, 1000);
        g2d.setColor(BACKGROUND_COLOR);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (allFiguresOnGame[i][j] == null) {
                    g2d.setColor(BACKGROUND_COLOR);
                }
                else {
                    g2d.setColor(allFiguresOnGame[i][j].getColor());
                }
                g2d.fillRect(START_X + (j + 1) * SIZE_OF_SQUARE, START_Y + (i + 1) * SIZE_OF_SQUARE, SIZE_OF_SQUARE, SIZE_OF_SQUARE);
            }
        }


        for (int i = 0; i <= HEIGHT; i++) {
            for (int j = 0; j <= WIDTH; j++) {
                g2d.setColor(LINE_COLOR);
                g2d.drawLine(START_X + SIZE_OF_SQUARE + j * SIZE_OF_SQUARE , START_Y + SIZE_OF_SQUARE,
                        START_X + SIZE_OF_SQUARE + j * SIZE_OF_SQUARE, START_Y + SIZE_OF_SQUARE + SIZE_OF_SQUARE * HEIGHT);
            }
            g2d.setColor(LINE_COLOR);
            g2d.drawLine(START_X + SIZE_OF_SQUARE, START_Y + (i + 1) * SIZE_OF_SQUARE,
                    START_X + SIZE_OF_SQUARE + WIDTH * SIZE_OF_SQUARE, START_Y + (i + 1) * SIZE_OF_SQUARE);
        }
    }
}
