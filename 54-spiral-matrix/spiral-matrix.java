import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        boolean[][] visited = new boolean[m][n];

        // Right, Down, Left, Up
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int row = 0;
        int col = 0;
        int direction = 0;

        for (int i = 0; i < m * n; i++) {

            result.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];

            // Change direction if next cell is invalid or already visited
            if (nextRow < 0 || nextRow >= m ||
                nextCol < 0 || nextCol >= n ||
                visited[nextRow][nextCol]) {

                direction = (direction + 1) % 4;

                nextRow = row + dr[direction];
                nextCol = col + dc[direction];
            }

            row = nextRow;
            col = nextCol;
        }

        return result;
    }
}