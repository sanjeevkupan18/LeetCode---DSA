class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        for (int i = 1; i <= 3 && i < n; i++) {
            for (int j = i + 1; j <= i + 3 && j < n; j++) {
                for (int k = j + 1; k <= j + 3 && k < n; k++) {
                    int l = n - k;

                    if (l < 1 || l > 3) {
                        continue;
                    }

                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);

                    if (isValid(a) && isValid(b)
                            && isValid(c) && isValid(d)) {
                        result.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
}