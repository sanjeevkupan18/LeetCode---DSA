class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // Correct pairing: nums[mid] == nums[mid + 1]
            if (nums[mid] == nums[mid + 1]) {
                // Single element is on the right
                low = mid + 2;
            } else {
                // Single element is on the left
                high = mid;
            }
        }

        return nums[low];
    }
}