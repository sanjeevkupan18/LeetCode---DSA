class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;

            // Check if nums1[i] exists in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    found = true;
                    break;
                }
            }

            // Check if already added
            boolean alreadyPresent = false;
            for (int j = 0; j < k; j++) {
                if (temp[j] == nums1[i]) {
                    alreadyPresent = true;
                    break;
                }
            }

            if (found && !alreadyPresent) {
                temp[k++] = nums1[i];
            }
        }

        return Arrays.copyOf(temp, k);
    }
}