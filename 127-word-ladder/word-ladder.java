class Solution {

    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        dict.remove(beginWord);
        dict.remove(endWord);

        int steps = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            // Always expand the smaller frontier.
            if (beginSet.size() > endSet.size()) {

                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();

            for (String word : beginSet) {

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        chars[i] = ch;

                        String newWord = new String(chars);

                        // Both searches have met.
                        if (endSet.contains(newWord)) {
                            return steps + 1;
                        }

                        if (dict.contains(newWord)) {

                            nextSet.add(newWord);
                            dict.remove(newWord);
                        }
                    }

                    chars[i] = original;
                }
            }

            beginSet = nextSet;
            steps++;
        }

        return 0;
    }
}