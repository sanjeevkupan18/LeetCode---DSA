class Solution {
    public String convertToTitle(int columnNumber) {
        char[] result = new char[10];
        int index = 0;

        while (columnNumber > 0) {
            columnNumber--;

            int remainder = columnNumber % 26;
            result[index++] = (char) ('A' + remainder);

            columnNumber /= 26;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = index - 1; i >= 0; i--) {
            answer.append(result[i]);
        }

        return answer.toString();
    }
}