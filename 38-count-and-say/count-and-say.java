class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int step = 1; step < n; step++) {
            StringBuilder sb = new StringBuilder();

            int i = 0;

            while (i < result.length()) {
                int j = i;

                while (j < result.length() &&
                       result.charAt(i) == result.charAt(j)) {
                    j++;
                }

                sb.append(j - i);
                sb.append(result.charAt(i));

                i = j;
            }

            result = sb.toString();
        }

        return result;
    }
}