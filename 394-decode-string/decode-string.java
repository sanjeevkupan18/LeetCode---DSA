import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch != ']') {
                stack.push(ch);
            } else {
                // Extract the encoded substring
                StringBuilder decoded = new StringBuilder();

                while (stack.peek() != '[') {
                    decoded.append(stack.pop());
                }

                stack.pop(); // Remove '['

                // Extract the repetition count
                StringBuilder number = new StringBuilder();

                while (!stack.isEmpty() &&
                       Character.isDigit(stack.peek())) {
                    number.append(stack.pop());
                }

                int k = Integer.parseInt(number.reverse().toString());

                // Repeat the decoded substring
                String repeated = decoded.reverse().toString();
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < k; i++) {
                    result.append(repeated);
                }

                // Push the expanded substring back onto the stack
                for (char c : result.toString().toCharArray()) {
                    stack.push(c);
                }
            }
        }

        // Construct the final decoded string
        StringBuilder answer = new StringBuilder();

        for (char ch : stack) {
            answer.append(ch);
        }

        return answer.toString();
    }
}