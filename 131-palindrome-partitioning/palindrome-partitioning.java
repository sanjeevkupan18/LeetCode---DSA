class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int index,
                           List<String> path,
                           List<List<String>> result) {

        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            String substring = s.substring(index, i + 1);

            if (isPalindrome(substring)) {

                path.add(substring);

                backtrack(s, i + 1, path, result);

                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}