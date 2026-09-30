class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        long required = (long) m * k;

        // Not enough flowers in total
        if (required > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int consecutiveFlowers = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                consecutiveFlowers++;

                if (consecutiveFlowers == k) {
                    bouquets++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }

            if (bouquets >= m) {
                return true;
            }
        }

        return false;
    }
}