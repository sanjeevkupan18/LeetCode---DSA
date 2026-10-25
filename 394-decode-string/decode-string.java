import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                // Build the repetition count
                k = k * 10 + (ch - '0');

            } else if (ch == '[') {
                // Save the current decoding context
                countStack.push(k);
                stringStack.push(currentString);

                // Start decoding the nested substring
                currentString = new StringBuilder();
                k = 0;

            } else if (ch == ']') {
                // Retrieve the repetition count and previous string
                int repeat = countStack.pop();
                StringBuilder previousString = stringStack.pop();

                // Append the current substring 'repeat' times
                for (int i = 0; i < repeat; i++) {
                    previousString.append(currentString);
                }

                currentString = previousString;

            } else {
                // Append a regular character
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}