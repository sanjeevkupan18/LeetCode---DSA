import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) {
            return result;
        }

        char[] target = p.toCharArray();
        Arrays.sort(target);

        for (int i = 0; i <= n - m; i++) {
            String substring = s.substring(i, i + m);

            char[] current = substring.toCharArray();
            Arrays.sort(current);

            if (Arrays.equals(current, target)) {
                result.add(i);
            }
        }

        return result;
    }
}