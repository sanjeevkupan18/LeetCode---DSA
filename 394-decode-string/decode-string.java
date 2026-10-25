class Solution {
    public String decodeString(String s) {
        StringBuilder current = new StringBuilder(s);

        while (true) {
            int close = -1;

            // Find the first closing bracket
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == ']') {
                    close = i;
                    break;
                }
            }

            // No brackets remain
            if (close == -1) {
                break;
            }

            // Find the matching opening bracket
            int open = close - 1;

            while (current.charAt(open) != '[') {
                open--;
            }

            // Extract the encoded substring
            String encoded = current.substring(open + 1, close);

            // Extract the repetition count
            int digitStart = open - 1;

            while (digitStart >= 0 &&
                   Character.isDigit(current.charAt(digitStart))) {
                digitStart--;
            }

            int k = Integer.parseInt(
                current.substring(digitStart + 1, open)
            );

            // Repeat the substring
            StringBuilder decoded = new StringBuilder();

            for (int i = 0; i < k; i++) {
                decoded.append(encoded);
            }

            // Replace the encoded section with its decoded result
            current.replace(
                digitStart + 1,
                close + 1,
                decoded.toString()
            );
        }

        return current.toString();
    }
}