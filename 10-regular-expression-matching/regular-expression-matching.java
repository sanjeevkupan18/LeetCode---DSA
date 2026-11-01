class Solution {

    public boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    private boolean solve(String s, String p, int i, int j) {

        // Pattern completely processed
        if (j == p.length()) {
            return i == s.length();
        }

        // Check whether current characters match
        boolean firstMatch = (i < s.length()) &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // If next character is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Option 1: Match zero occurrences
            boolean skip = solve(s, p, i, j + 2);

            // Option 2: Match one or more occurrences
            boolean take = firstMatch &&
                    solve(s, p, i + 1, j);

            return skip || take;
        }

        // Normal character or '.'
        return firstMatch && solve(s, p, i + 1, j + 1);
    }
}