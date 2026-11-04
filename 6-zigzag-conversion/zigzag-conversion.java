class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();

        if (numRows == 1 || numRows >= n) {
            return s;
        }

        StringBuilder result = new StringBuilder();

        int cycleLen = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {

            for (int j = 0; j + row < n; j += cycleLen) {

                // Vertical character
                result.append(s.charAt(j + row));

                // Diagonal character (middle rows only)
                int diagonalIndex = j + cycleLen - row;

                if (row != 0 && row != numRows - 1
                        && diagonalIndex < n) {

                    result.append(s.charAt(diagonalIndex));
                }
            }
        }

        return result.toString();
    }
}