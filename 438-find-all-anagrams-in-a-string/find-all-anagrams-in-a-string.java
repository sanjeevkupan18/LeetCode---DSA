import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) {
            return result;
        }

        int[] targetFreq = new int[26];

        for (int i = 0; i < m; i++) {
            targetFreq[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= n - m; i++) {
            int[] windowFreq = new int[26];

            for (int j = i; j < i + m; j++) {
                windowFreq[s.charAt(j) - 'a']++;
            }

            if (Arrays.equals(targetFreq, windowFreq)) {
                result.add(i);
            }
        }

        return result;
    }
}