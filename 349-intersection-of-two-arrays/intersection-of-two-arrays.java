class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        boolean[] seen = new boolean[1001];

        // Mark elements of nums1
        for (int num : nums1) {
            seen[num] = true;
        }

        int[] temp = new int[1001];
        int k = 0;

        // Find intersection
        for (int num : nums2) {
            if (seen[num]) {
                temp[k++] = num;

                // Prevent duplicate
                seen[num] = false;
            }
        }

        return Arrays.copyOf(temp, k);
    }
}