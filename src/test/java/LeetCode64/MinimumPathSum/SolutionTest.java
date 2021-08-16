package LeetCode64.MinimumPathSum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    public void minPathSum() {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        assertEquals(7, solution.minPathSum(grid));
    }

    @Test
    public void throwExceptionIfNotValidGrid() {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 101},
                {4, 2, 1}
        };

        assertThrows(IllegalArgumentException.class, () -> solution.minPathSum(grid));
    }
}