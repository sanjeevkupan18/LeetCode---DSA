class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();

        if (numRows == 1 || numRows >= n) {
            return s;
        }

        int cycleLen = 2 * numRows - 2;
        int cols = (n / cycleLen + 1) * (numRows - 1);

        char[][] matrix = new char[numRows][cols];

        int row = 0, col = 0;
        int index = 0;

        while (index < n) {

            // Move vertically downward
            while (row < numRows && index < n) {
                matrix[row][col] = s.charAt(index++);
                row++;
            }

            row -= 2;
            col++;

            // Move diagonally upward
            while (row > 0 && index < n) {
                matrix[row][col] = s.charAt(index++);
                row--;
                col++;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != '\0') {
                    result.append(matrix[i][j]);
                }
            }
        }

        return result.toString();
    }
}