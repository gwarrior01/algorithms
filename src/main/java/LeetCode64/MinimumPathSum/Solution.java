package LeetCode64.MinimumPathSum;

import java.util.Arrays;
import java.util.function.Predicate;

public class Solution {
    private final int MAX_HEIGHT = 200;
    private final int MIN_HEIGHT = 1;
    private final int MAX_WIDTH = 200;
    private final int MIN_WIDTH = 1;
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 100;

    private int gridWidth;

    public int minPathSum(int[][] grid) {
        if (isNotValidGrid(grid)) {
            throw new IllegalArgumentException("Grid is not valid");
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, array[i], 0, grid[i].length);
        }
        for (int j = 1; j < n; j++) {
            array[0][j] = array[0][j - 1] + array[0][j];
        }
        for (int i = 1; i < m; i++) {
            array[i][0] = array[i - 1][0] + array[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] += Math.min(array[i - 1][j], array[i][j - 1]);
            }
        }
        return array[m - 1][n - 1];
    }


    private boolean isNotValidGrid(int[][] grid) {
        return !isValidGrid(grid);
    }

    private boolean isValidGrid(int[][] grid) {
        if (isNotValidHeight(grid)) {
            return false;
        }
        gridWidth = grid[0].length;
        return Arrays.stream(grid)
                .allMatch(this::isValidGridRow);
    }

    private boolean isNotValidHeight(int[][] grid) {
        return grid.length > MAX_HEIGHT || grid.length < MIN_HEIGHT;
    }

    private boolean isValidGridRow(int[] gridRow) {
        Predicate<int[]> predicate = row -> row.length < MAX_WIDTH && row.length > MIN_WIDTH && row.length == gridWidth;
        return predicate
                .and(row -> Arrays.stream(row).allMatch(value -> value >= MIN_VALUE && value <= MAX_VALUE))
                .test(gridRow);
    }
}
