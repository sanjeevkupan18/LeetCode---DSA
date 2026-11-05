class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int step = 2; step <= n; step++) {
            StringBuilder sb = new StringBuilder();

            int count = 1;

            for (int i = 1; i < result.length(); i++) {
                if (result.charAt(i) == result.charAt(i - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(i - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));

            result = sb.toString();
        }

        return result;
    }
}