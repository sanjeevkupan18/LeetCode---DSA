class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        boolean[][] visited,
                        int r, int c, int index) {

        if (index == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 ||
            r >= board.length || c >= board[0].length ||
            visited[r][c] ||
            board[r][c] != word.charAt(index)) {

            return false;
        }

        visited[r][c] = true;

        boolean found =
            dfs(board, word, visited, r + 1, c, index + 1) ||
            dfs(board, word, visited, r - 1, c, index + 1) ||
            dfs(board, word, visited, r, c + 1, index + 1) ||
            dfs(board, word, visited, r, c - 1, index + 1);

        visited[r][c] = false;

        return found;
    }
}