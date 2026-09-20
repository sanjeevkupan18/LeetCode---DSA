class Solution {
    public int searchInsert(int[] nums, int target) {

        // Search for target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        // Find insertion position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
        }

        return nums.length;
    }
}