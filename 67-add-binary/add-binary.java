class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        int maxLen = Math.max(a.length(), b.length());

        char[] result = new char[maxLen + 1];

        int k = maxLen;

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            result[k--] = (char) ('0' + (sum % 2));

            carry = sum / 2;
        }

        return new String(result, k + 1, maxLen - k);
    }
}