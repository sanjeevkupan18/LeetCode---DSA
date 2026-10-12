class Solution {
    public int firstUniqChar(String s) {
        int[] frequency = new int[26];

        // Step 1: Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        // Step 2: Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}