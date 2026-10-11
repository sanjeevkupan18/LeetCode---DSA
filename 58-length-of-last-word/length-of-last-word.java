class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int lastLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                if (length > 0) {
                    lastLength = length;
                    length = 0;
                }
            }
        }

        return length > 0 ? length : lastLength;
    }
}