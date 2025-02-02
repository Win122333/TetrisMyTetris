package com.vsu.cs.course2;

public class GameplayService {
    public static boolean isCollision(OriginFigure figure, GamePlaceholder placeholder) {
        boolean[][][] mat = figure.getMat();
        for (int i = 0; i < GamePlaceholder.HEIGHT ; i++) {
            for (int j = 0; j < GamePlaceholder.WIDTH; j++) {
                if (mat[figure.position][i + 5][j] && placeholder.allFiguresOnGame[i][j] != null) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void addFigureToPlaceholder(OriginFigure figure, GamePlaceholder placeholder) {
        boolean[][][] mat = figure.getMat();
        for (int i = 0; i < GamePlaceholder.HEIGHT; i++) {
            for (int j = 0; j < GamePlaceholder.WIDTH; j++) {//МОЖНО ОПТИМИЗИРОВАТЬ ИСПОЛЬУЯ ИНДЕКСЫ ФИГУРЫ
                if (mat[figure.position][i + 5][j]) {
                    placeholder.allFiguresOnGame[i][j] = figure;
                }
            }
        }
    }
}
