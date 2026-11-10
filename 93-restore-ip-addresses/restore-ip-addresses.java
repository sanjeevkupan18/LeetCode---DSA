class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        if (n < 4 || n > 12) {
            return result;
        }

        for (int i = 1; i <= 3 && i <= n - 3; i++) {
            String a = s.substring(0, i);

            if (!isValid(a)) continue;

            for (int j = i + 1; j <= i + 3 && j <= n - 2; j++) {
                String b = s.substring(i, j);

                if (!isValid(b)) continue;

                for (int k = j + 1; k <= j + 3 && k <= n - 1; k++) {
                    String c = s.substring(j, k);
                    String d = s.substring(k);

                    if (d.length() > 3) continue;

                    if (isValid(c) && isValid(d)) {
                        result.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String part) {
        if (part.length() == 0 || part.length() > 3) {
            return false;
        }

        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(part);

        return num <= 255;
    }
}