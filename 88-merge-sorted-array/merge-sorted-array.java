class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int currentSize = m;

        for (int j = 0; j < n; j++) {

            int i = currentSize - 1;

            // Find correct position
            while (i >= 0 && nums1[i] > nums2[j]) {
                nums1[i + 1] = nums1[i];
                i--;
            }

            // Insert nums2[j]
            nums1[i + 1] = nums2[j];

            currentSize++;
        }
    }
}