import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        char[] target = s1.toCharArray();
        Arrays.sort(target);

        for (int i = 0; i <= m - n; i++) {
            char[] window = s2.substring(i, i + n).toCharArray();
            Arrays.sort(window);

            if (Arrays.equals(target, window)) {
                return true;
            }
        }

        return false;
    }
}