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
        int[] windowFreq = new int[26];

        for (int i = 0; i < m; i++) {
            targetFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(targetFreq, windowFreq)) {
            result.add(0);
        }

        for (int right = m; right < n; right++) {
            // Add the new character to the window
            windowFreq[s.charAt(right) - 'a']++;

            // Remove the character leaving the window
            windowFreq[s.charAt(right - m) - 'a']--;

            // Compare character frequencies
            if (Arrays.equals(targetFreq, windowFreq)) {
                result.add(right - m + 1);
            }
        }

        return result;
    }
}