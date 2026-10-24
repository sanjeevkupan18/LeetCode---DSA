class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        int n = pattern.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                boolean sameChar =
                    pattern.charAt(i) == pattern.charAt(j);

                boolean sameWord =
                    words[i].equals(words[j]);

                if (sameChar != sameWord) {
                    return false;
                }
            }
        }

        return true;
    }
}