public class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int tmp_nums[] = new int[length];
        for(int i=0; i<length; i++){
            tmp_nums[(i+k)%length] = nums[i];
        }
        for(int i=0; i<length; i++)
        {
            nums[i] = tmp_nums[i];
        }
    }
}
