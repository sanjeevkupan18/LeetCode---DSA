class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        for (int rotation = 0; rotation < n; rotation++) {
            boolean sorted = true;

            for (int i = 0; i < n - 1; i++) {
                int current = nums[(i + rotation) % n];
                int next = nums[(i + 1 + rotation) % n];

                if (current > next) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                return true;
            }
        }

        return false;
    }
}