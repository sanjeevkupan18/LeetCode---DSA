class Solution {
    public int romanToInt(String s) {
        int result = 0;
int i = 0;
            while (i < s.length()) {
        if (i + 1 < s.length()) {
            String pair = s.substring(i, i + 2);

            switch (pair) {
                case "IV":
                    result += 4;
                    i += 2;
                    continue;
                case "IX":
                    result += 9;
                    i += 2;
                    continue;
                case "XL":
                    result += 40;
                    i += 2;
                    continue;
                case "XC":
                    result += 90;
                    i += 2;
                    continue;
                case "CD":
                    result += 400;
                    i += 2;
                    continue;
                case "CM":
                    result += 900;
                    i += 2;
                    continue;
            }
        }

        switch (s.charAt(i)) {
            case 'I': result += 1; break;
            case 'V': result += 5; break;
            case 'X': result += 10; break;
            case 'L': result += 50; break;
            case 'C': result += 100; break;
            case 'D': result += 500; break;
            case 'M': result += 1000; break;
        }

        i++;
    }

    return result;
}
}  
    
