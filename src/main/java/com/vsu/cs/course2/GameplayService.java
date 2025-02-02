package com.vsu.cs.course2;

public class GameplayService {
    private static boolean isCollision(boolean[][] mat, GamePlaceholder placeholder) {
        for (int i = 0; i < GamePlaceholder.HEIGHT; i++) {
            for (int j = 0; j < GamePlaceholder.WIDTH; j++) {
                if (mat[i + 5][j] && placeholder.allFiguresOnGame[i][j] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void addFigureToPlaceholder(OriginFigure figure, GamePlaceholder placeholder) {
        boolean[][][] mat = figure.getMat();
        for (int i = 0; i < GamePlaceholder.HEIGHT; i++) {
            for (int j = 0; j < GamePlaceholder.WIDTH; j++) {//МОЖНО ОПТИМИЗИРОВАТЬ ИСПОЛЬУЯ ИНДЕКСЫ ФИГУРЫ
                if (mat[figure.position][i + 5][j]) {
                    placeholder.allFiguresOnGame[i][j] = figure;
                }
            }
        }
    }

    private static boolean canGoDown(boolean[][] mat) {
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[mat.length - 1][j]) {
                return false;
            }
        }
        return true;
    }
    private static boolean canGoLeft(boolean[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0]) {
                return false;
            }
        }
        return true;
    }

    public static void goFigureLeft(OriginFigure figure, GamePlaceholder placeholder) {
        boolean[][][] mat = figure.getMat();

        for (int position = 0; position < mat.length; position++) {
            if (canGoLeft(mat[position])) {
                boolean[][] copyMat = mat[position].clone();
                for (int j = 0; j < copyMat[0].length - 1; j++) {
                    for (int i = 0; i < copyMat.length; i++) {
                        copyMat[i][j] = copyMat[i][j + 1];
                    }
                }
                for (int i = 0; i < copyMat.length; i++) {
                    copyMat[i][copyMat[i].length - 1] = false;
                }

                if (!isCollision(copyMat, placeholder)) {
                    mat[position] = copyMat;
                }
            }
        }
    }
    private static boolean canGoRight(boolean[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][mat[i].length - 1]) {
                return false;
            }
        }
        return true;
    }
    public static void goFigureRight(OriginFigure figure, GamePlaceholder placeholder) {
        boolean[][][] mat = figure.getMat();

        for (int position = 0; position < mat.length; position++) {
            if (canGoRight(mat[position])) {
                boolean[][] copyMat = mat[position].clone();
                for (int j = copyMat[0].length - 1; j > 0; j--) {
                    for (int i = 0; i < copyMat.length; i++) {
                        copyMat[i][j] = copyMat[i][j - 1];
                    }
                }
                for (int i = 0; i < copyMat.length; i++) {
                    copyMat[i][0] = false;
                }
                if (!isCollision(copyMat, placeholder)) {
                    mat[position] = copyMat;
                }
            }
        }
    }
    public static boolean goFigureDown(OriginFigure figure, GamePlaceholder placeholder) {
        boolean[][][] mat = figure.getMat();

        for (int position = 0; position < mat.length; position++) {
            if (canGoDown(mat[position])) {
                boolean[][] copyMat = mat[position].clone();
                for (int i = copyMat.length - 1; i > 0; i--) {
                    copyMat[i] = copyMat[i - 1];
                }
                copyMat[0] = new boolean[10];

                if (!isCollision(copyMat, placeholder)) {
                    mat[position] = copyMat;
                }
                else {
                    addFigureToPlaceholder(figure, placeholder);
                    return true;
                }
            }
            else {
                addFigureToPlaceholder(figure, placeholder);
                return true;
            }
        }
        return false;
    }
}
