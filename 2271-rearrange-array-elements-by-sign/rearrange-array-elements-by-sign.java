class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;

        int[] positive = new int[n / 2];
        int[] negative = new int[n / 2];

        int p = 0;
        int neg = 0;

        // Separate positive and negative numbers
        for (int num : nums) {

            if (num > 0) {
                positive[p++] = num;
            } else {
                negative[neg++] = num;
            }
        }

        int[] ans = new int[n];

        // Alternate positive and negative
        for (int i = 0; i < n / 2; i++) {

            ans[2 * i] = positive[i];
            ans[2 * i + 1] = negative[i];
        }

        return ans;
    }
}