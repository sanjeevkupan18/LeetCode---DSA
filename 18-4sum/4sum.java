import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> result = new HashSet<>();

        int n = nums.length;

        for (int a = 0; a < n - 3; a++) {

            for (int b = a + 1; b < n - 2; b++) {

                Set<Long> seen = new HashSet<>();

                for (int c = b + 1; c < n; c++) {

                    long required = (long) target
                            - nums[a]
                            - nums[b]
                            - nums[c];

                    if (seen.contains(required)) {

                        List<Integer> quad = Arrays.asList(
                                nums[a],
                                nums[b],
                                (int) required,
                                nums[c]
                        );

                        Collections.sort(quad);
                        result.add(quad);
                    }

                    seen.add((long) nums[c]);
                }
            }
        }

        return new ArrayList<>(result);
    }
}