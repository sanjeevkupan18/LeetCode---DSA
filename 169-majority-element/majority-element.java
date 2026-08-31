class Solution {
    public int majorityElement(int[] nums) {
        int element=0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                count =1;
                element = num;
            }

            else if (num == element) {
                count++;
            }
            else {
                count--;
            }
        }

        int count1=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == element){
                count1++;
            }
        }
        if(count1 > nums.length / 2){
            return element;
        }
        return -1;
    }
}