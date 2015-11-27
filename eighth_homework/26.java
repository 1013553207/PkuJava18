public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(0 == length) return 0;
        int count = 1;
        for(int i=1; i< length; i++){
                if(nums[count-1] == nums[i])
                    continue;
                else {
                    nums[count] = nums[i];
                    count++;
                }
        }
        return  count;
    }
}