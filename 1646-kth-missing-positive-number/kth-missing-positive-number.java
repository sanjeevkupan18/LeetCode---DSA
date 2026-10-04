import java.util.HashSet;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int num = 1;

        while (k > 0) {
            if (!set.contains(num)) {
                k--;
            }

            if (k == 0) {
                return num;
            }

            num++;
        }

        return -1;
    }
}