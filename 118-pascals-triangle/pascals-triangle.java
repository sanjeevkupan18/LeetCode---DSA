class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int n = 0; n < numRows; n++) {

            List<Integer> row = new ArrayList<>();

            long value = 1;

            for (int k = 0; k <= n; k++) {
                row.add((int) value);

                value = value * (n - k) / (k + 1);
            }

            result.add(row);
        }

        return result;
    }
}