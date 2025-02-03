package com.vsu.cs.course2;

import java.util.ArrayList;
import java.util.List;

public class GameplayService {
    private static List<Integer> getFullLines(GamePlaceholder placeholder) {
        List<Integer> indexes = new ArrayList<>();
        for (int row = 0; row < placeholder.allFiguresOnGame.length; row++) {
            boolean f = true;
            for (int column = 0; column < placeholder.allFiguresOnGame[row].length; column++) {
                if (placeholder.allFiguresOnGame[row][column] == null) {
                    f = false;
                    break;
                }
            }
            if (f) {
                indexes.add(row);
            }
        }
        return indexes;
    }
    private static void deleteAllLinesByInd(GamePlaceholder placeholder, List<Integer> ind) {
        for (int index : ind) {
            for (int row = index; row > 0; row--) {
                placeholder.allFiguresOnGame[row] = placeholder.allFiguresOnGame[row - 1];
            }
            placeholder.allFiguresOnGame[0] = new OriginFigure[placeholder.allFiguresOnGame[0].length];
        }
    }
    public static int deleteAllLines(GamePlaceholder placeholder) {
        List<Integer> linesInd = getFullLines(placeholder);
        deleteAllLinesByInd(placeholder, linesInd);
        return linesInd.size();
    }
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

    public static boolean canGoDown(boolean[][] mat) {
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
    private static boolean[][] goDown(boolean[][] mat) {
        boolean[][] copyMat = mat.clone();
        if (canGoDown(copyMat)) {
            for (int i = copyMat.length - 1; i > 0; i--) {
                copyMat[i] = copyMat[i - 1];
            }
            copyMat[0] = new boolean[10];
            return copyMat;
        }
        return mat;
    }
    public static boolean goFigureDown(OriginFigure figure, GamePlaceholder placeholder) {
        boolean[][][] mat = figure.getMat();

        boolean[][] newMat = goDown(mat[figure.position]);
        if (!canGoDown(mat[figure.position])) {
            addFigureToPlaceholder(figure, placeholder);
            return true;
        }
        if (isCollision(newMat, placeholder)) {
            addFigureToPlaceholder(figure, placeholder);
            return true;
        }
        else {
            for (int position = 0; position < mat.length; position++) {
                boolean[][] downMat = goDown(mat[position]);
                mat[position] = downMat;
            }
        }
        return false;
    }
}
