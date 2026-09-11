class Solution {
    public int[][] merge(int[][] intervals) {

        boolean[] removed = new boolean[intervals.length];
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            if (removed[i]) {
                continue;
            }

            int start = intervals[i][0];
            int end = intervals[i][1];

            boolean merged;

            do {
                merged = false;

                for (int j = 0; j < intervals.length; j++) {

                    if (i == j || removed[j]) {
                        continue;
                    }

                    // Check overlap
                    if (start <= intervals[j][1] &&
                        intervals[j][0] <= end) {

                        start = Math.min(start, intervals[j][0]);
                        end = Math.max(end, intervals[j][1]);

                        removed[j] = true;
                        merged = true;
                    }
                }

            } while (merged);

            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
    }
}