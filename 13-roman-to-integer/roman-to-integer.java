class Solution {
    public int romanToInt(String s) {
        int[] values = new int[128];

        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int result = 0;
        int previous = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = values[s.charAt(i)];

            if (current < previous) {
                result -= current;
            } else {
                result += current;
            }

            previous = current;
        }

        return result;
    }
}