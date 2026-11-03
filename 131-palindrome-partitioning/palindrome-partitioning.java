class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        generate(s, 0, path, result);

        return result;
    }

    private void generate(String s, int index,
                          List<String> path,
                          List<List<String>> result) {

        if (index == s.length()) {
            if (isValid(path)) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {

            path.add(s.substring(index, i + 1));

            generate(s, i + 1, path, result);

            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(List<String> path) {
        for (String str : path) {
            if (!isPalindrome(str)) {
                return false;
            }
        }
        return true;
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