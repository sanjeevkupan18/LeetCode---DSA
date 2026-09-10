class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {

            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {

                int offset = i - first;

                // Save top-left
                int temp = matrix[first][i];

                // Bottom-left -> top-left
                matrix[first][i] = matrix[last - offset][first];

                // Bottom-right -> bottom-left
                matrix[last - offset][first] =
                        matrix[last][last - offset];

                // Top-right -> bottom-right
                matrix[last][last - offset] =
                        matrix[i][last];

                // Top-left -> top-right
                matrix[i][last] = temp;
            }
        }
    }
}