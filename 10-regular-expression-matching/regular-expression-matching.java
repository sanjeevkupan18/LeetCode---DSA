class Solution {

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[] next = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];

        // Base case: Empty string matches empty pattern
        next[m] = true;

        // Process string from bottom to top
        for (int i = n; i >= 0; i--) {

            curr[m] = (i == n);

            // Process pattern from right to left
            for (int j = m - 1; j >= 0; j--) {

                boolean firstMatch = (i < n) &&
                        (s.charAt(i) == p.charAt(j) ||
                         p.charAt(j) == '.');

                // If next character is '*'
                if (j + 1 < m && p.charAt(j + 1) == '*') {

                    // Zero occurrences OR one/more occurrences
                    curr[j] = curr[j + 2] ||
                            (firstMatch && next[j]);

                } else {

                    // Normal character matching
                    curr[j] = firstMatch && next[j + 1];
                }
            }

            // Move current row to next
            boolean[] temp = next;
            next = curr;
            curr = temp;
        }

        return next[0];
    }
}