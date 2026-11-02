class Solution {
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        Integer[][] dp = new Integer[n + 1][m + 1];

        return solve(0, 0, s, t, dp);
    }

    private int solve(int i, int j, String s, String t,
                      Integer[][] dp) {

        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {

            dp[i][j] = solve(i + 1, j + 1, s, t, dp)
                     + solve(i + 1, j, s, t, dp);

        } else {

            dp[i][j] = solve(i + 1, j, s, t, dp);
        }

        return dp[i][j];
    }
}