class Solution {
    public int maxProduct(int[] nums) {
        int mp = Integer.MIN_VALUE;
        int n = nums.length;
        int prefix = 1 ; int suffix = 1;
        for(int i=0; i<n; i++){
            if(prefix == 0) prefix =1;
            if(suffix == 0) suffix =1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];
            mp = Math.max(mp , Math.max(prefix,suffix));
        }
        return mp;
        
    }
}