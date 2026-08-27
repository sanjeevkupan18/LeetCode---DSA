class Solution {
    public int maxProduct(int[] nums) {
        int mp = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int prod = 1;
            int start = i;
            for(int j=i; j<nums.length; j++){
                prod = prod * nums[j];
                mp = Math.max(prod , mp);
            }
            mp = Math.max(prod , mp);
        }
        return mp;
        
    }
}