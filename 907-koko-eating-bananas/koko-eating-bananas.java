class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            for (int pile : piles) {
                hours += (pile + (long) mid - 1) / mid;

                if (hours > h) {
                    break;
                }
            }

            if (hours <= h) {
                // mid works, try smaller speed
                high = mid - 1;
            } else {
                // mid is too slow
                low = mid + 1;
            }
        }

        return low;
    }
}