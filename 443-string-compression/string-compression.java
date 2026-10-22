class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int read = 0;
        int write = 0;

        while (read < n) {
            char ch = chars[read];
            int start = read;

            while (read < n && chars[read] == ch) {
                read++;
            }

            int count = read - start;

            chars[write++] = ch;

            if (count > 1) {
                int divisor = 1;

                while (count / divisor >= 10) {
                    divisor *= 10;
                }

                while (divisor > 0) {
                    int digit = count / divisor;
                    chars[write++] = (char) ('0' + digit);

                    count %= divisor;
                    divisor /= 10;
                }
            }
        }

        return write;
    }
}