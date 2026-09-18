class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        int k = 0;

        for (int i = 0; i < n; i++) {
            if (k == 0 || temp[k - 1] != nums[i]) {
                temp[k] = nums[i];
                k++;
            }
        }

        // Copy unique elements back into nums
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

        return k;
    }
}