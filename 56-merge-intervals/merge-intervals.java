class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // Add first interval
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] current = intervals[i];
            int[] last = result.get(result.size() - 1);

            // Overlapping intervals
            if (current[0] <= last[1]) {

                last[1] = Math.max(last[1], current[1]);

            } else {

                // Non-overlapping interval
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}