class Solution {

    int[][] dp;

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return solve(s, p, 0, 0);
    }

    private boolean solve(String s, String p, int i, int j) {

        // Base case
        if (j == p.length()) {
            return i == s.length();
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        // Check current character matching
        boolean firstMatch = (i < s.length()) &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean ans;

        // Check whether next pattern character is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Zero occurrences
            boolean skip = solve(s, p, i, j + 2);

            // One or more occurrences
            boolean take = firstMatch &&
                    solve(s, p, i + 1, j);

            ans = skip || take;

        } else {

            // Normal matching
            ans = firstMatch &&
                    solve(s, p, i + 1, j + 1);
        }

        // Store result
        dp[i][j] = ans ? 1 : 0;

        return ans;
    }
}