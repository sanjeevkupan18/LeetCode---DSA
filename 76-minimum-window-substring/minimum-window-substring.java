class Solution {
    public String minWindow(String s, String t) {

        int m = s.length();
        int n = t.length();

        if (m < n) {
            return "";
        }

        int[] freq = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int required = 0;

        for (int count : freq) {
            if (count > 0) {
                required++;
            }
        }

        int formed = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < m; right++) {

            char c = s.charAt(right);
            freq[c]--;

            if (freq[c] == 0) {
                formed++;
            }

            while (formed == required) {

                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}