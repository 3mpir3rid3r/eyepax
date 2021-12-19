package com.eyepax.interview.main;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorGrid {
    private final Random random = new Random();
    @Getter
    private final Color[][] colors;

    private ColorGrid() {
        // limit row and cols random number between 5 to 10 for testing
        int maxRowCols = 10;
        // limit row and cols random number between 5 to 10 for testing
        int minRowCols = 5;
        int cols = randomInt(minRowCols, maxRowCols);
        int rows = randomInt(minRowCols, maxRowCols);
        // limit max color count to 5 for testing
        int maxColor = 5;
        // limit min color count to 3 for testing
        int minColor = 3;
        List<Color> color = new ArrayList<>();
        for (int i = 0; i < randomInt(minColor, maxColor); i++) { // limit color count random number between 3 to 5 for testing
            color.add(new Color(randomInt(0, 255), randomInt(0, 255), randomInt(0, 255)));
        }

        Color[][] colors = new Color[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                colors[i][j] = color.get(randomInt(0, color.size() - 1));
            }
        }

        this.colors = colors;
    }

    public static ColorGrid create() {
        return new ColorGrid();
    }

    private int randomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }


    public Color[][] swapRowCols() {
        Color[][] result = new Color[getColors()[0].length][getColors().length];
        for (int i = 0; i < getColors().length; i++) {
            for (int j = 0; j < getColors()[0].length; j++) {
                result[j][i] = getColors()[i][j]; //change row color to column color
            }
        }
        return result;
    }
}
