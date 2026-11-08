class Solution {

    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {

            for (int i = 0; i < word.length(); i++) {

                String pattern =
                    word.substring(0, i) + "*" +
                    word.substring(i + 1);

                map.computeIfAbsent(pattern,
                    k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return steps;
                }

                for (int j = 0; j < word.length(); j++) {

                    String pattern =
                        word.substring(0, j) + "*" +
                        word.substring(j + 1);

                    for (String neighbor :
                         map.getOrDefault(pattern,
                             new ArrayList<>())) {

                        if (!visited.contains(neighbor)) {

                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }

                    // Avoid processing the same pattern again.
                    map.remove(pattern);
                }
            }

            steps++;
        }

        return 0;
    }
}