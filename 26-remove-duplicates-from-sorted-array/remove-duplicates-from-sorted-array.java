import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int k = 0;

        for (int num : set) {
            nums[k] = num;
            k++;
        }

        return k;
    }
}