import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<>();

        // Step 1: Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}