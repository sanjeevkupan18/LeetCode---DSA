class Solution {

    private boolean isValid(int[] window, int[] required) {
        for (int i = 0; i < 128; i++) {
            if (window[i] < required[i]) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {

        int m = s.length();

        int[] required = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            required[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < m; right++) {

            window[s.charAt(right)]++;

            while (isValid(window, required)) {

                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                window[s.charAt(left)]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}