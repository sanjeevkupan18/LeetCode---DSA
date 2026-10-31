class Solution {

    public int minDistance(String word1, String word2) {

        // Keep word2 as the shorter string
        if (word1.length() < word2.length()) {
            return minDistance(word2, word1);
        }

        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // Base case: converting empty word1 to word2
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {

            // Base case: converting word1 prefix to empty string
            curr[0] = i;

            for (int j = 1; j <= n; j++) {

                // Characters match
                if (word1.charAt(i - 1) ==
                    word2.charAt(j - 1)) {

                    curr[j] = prev[j - 1];

                } else {

                    // Insert
                    int insert = curr[j - 1];

                    // Delete
                    int delete = prev[j];

                    // Replace
                    int replace = prev[j - 1];

                    curr[j] = 1 + Math.min(
                        insert,
                        Math.min(delete, replace)
                    );
                }
            }

            // Move current row to previous row
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}