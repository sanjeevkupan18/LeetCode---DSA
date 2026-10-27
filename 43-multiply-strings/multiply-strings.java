class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';

            for (int j = m - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2
                            + result[i + j + 1];

                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }

        StringBuilder answer = new StringBuilder();
        int i = 0;

        while (i < result.length && result[i] == 0) {
            i++;
        }

        while (i < result.length) {
            answer.append(result[i]);
            i++;
        }

        return answer.toString();
    }
}