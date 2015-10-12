public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int i=0,j=0;
        int n,m;
        for(;i<nums.length-1;++i) {
            n=nums[i];
            for(j=i+1;j<nums.length;++j) {
                if(n+nums[j]==target){
                    m=nums[j];
                    answer[0]=i+1;
                    answer[1]=j+1;
                    return answer;
                }
            }
        }
        return answer;
    }
}