class Solution {

    public List<List<String>> partition(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        // Precompute palindrome substrings
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result, dp);

        return result;
    }

    private void backtrack(String s, int index,
                           List<String> path,
                           List<List<String>> result,
                           boolean[][] dp) {

        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (dp[index][i]) {

                path.add(s.substring(index, i + 1));

                backtrack(s, i + 1, path, result, dp);

                path.remove(path.size() - 1);
            }
        }
    }
}