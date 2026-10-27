class Solution {
    public String multiply(String num1, String num2) {
        String result = "0";

        for (int i = num2.length() - 1; i >= 0; i--) {
            int digit = num2.charAt(i) - '0';
            String partial = "0";

            // Multiply num1 by the current digit using repeated addition
            for (int j = 0; j < digit; j++) {
                partial = addStrings(partial, num1);
            }

            // Append zeros only if the partial product is not zero
            if (!partial.equals("0")) {
                for (int k = 0; k < num2.length() - 1 - i; k++) {
                    partial += "0";
                }
            }

            result = addStrings(result, partial);
        }

        return result;
    }

    private String addStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}