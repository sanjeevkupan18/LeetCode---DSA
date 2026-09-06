class Solution {
    public void sortColors(int[] nums) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        // Count occurrences
        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int index = 0;

        // Put 0s
        while (count0-- > 0) {
            nums[index++] = 0;
        }

        // Put 1s
        while (count1-- > 0) {
            nums[index++] = 1;
        }

        // Put 2s
        while (count2-- > 0) {
            nums[index++] = 2;
        }
    }
}