package com.eyepax.interview.main;

import java.awt.*;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        // Create new color grid
        ColorGrid colors = ColorGrid.create();
        // Check colors in rows
        ResultDto resultForRows = checkColors(colors.getColors());
        // Check colors in columns
        ResultDto resultForCols = checkColors(colors.swapRowCols());

        //check node counts
        if (resultForRows.getCount() > resultForCols.getCount()) {
            System.out.println("Max count: " + resultForRows.getCount());
            System.out.println("Start X,Y : " + resultForRows.getRow() + "," + (resultForRows.getCol() - (resultForRows.getCount() - 1)));
            System.out.println("End X,Y : " + resultForRows.getRow() + "," + resultForRows.getCol());
        } else if (resultForRows.getCount() < resultForCols.getCount()) {
            System.out.println("Max count: " + resultForCols.getCount());
            System.out.println("Start X,Y : " + (resultForCols.getCol() - (resultForCols.getCount() - 1)) + "," + resultForCols.getRow());
            System.out.println("End X,Y : " + resultForCols.getCol() + "," + resultForCols.getRow());
        } else if (resultForRows.getCount() == resultForCols.getCount()) {
            System.out.println("Max count for both side: " + resultForCols.getCount());
        }
    }

    private static ResultDto checkColors(Color[][] colors) {
        ResultDto resultDto = new ResultDto();
        int count;
        for (int i = 0; i < colors.length; i++) {
            count = 1;
            for (int j = 0; j < colors[i].length - 1; j++) {
                if (colors[i][j] == colors[i][j + 1]) { // check right node color is same to current
                    count++;
                    if (resultDto.getCount() < count) {    // I skipped the same length value. if we want we can add <= instead of < and add all results to the List object
                        resultDto.setRow(i);
                        resultDto.setCol(j + 1);
                        resultDto.setCount(count);
                    }
                } else {
                    count = 1;
                }
            }
        }
        return resultDto;
    }
}
