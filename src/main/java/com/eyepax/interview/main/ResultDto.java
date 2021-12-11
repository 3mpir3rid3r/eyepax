package com.eyepax.interview.main;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultDto {
    private int row;
    private int col;
    private int count;

    public int startX() {
        return Math.max(row - count, 0);
    }

    public int startY() {
        return Math.max(col - count, 0);
    }

    public int endX() {
        return row;
    }

    public int endY() {
        return col;
    }
}
