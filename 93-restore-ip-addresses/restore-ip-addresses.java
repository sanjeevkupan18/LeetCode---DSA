class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int index,
                           List<String> path,
                           List<String> result) {

        // Exactly four segments and all digits consumed
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // Try segments of length 1, 2 and 3
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // No leading zeros
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            int num = Integer.parseInt(part);

            // Segment must be between 0 and 255
            if (num > 255) {
                break;
            }

            path.add(part);

            backtrack(s, index + len, path, result);

            // Backtracking
            path.remove(path.size() - 1);
        }
    }
}