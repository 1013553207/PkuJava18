public class Solution {
    public void moveZeroes(int[] nums) {
         int k=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				k++;
			}
			else{
				nums[i-k]=nums[i];
			}
		}
		for(int i=nums.length-k;i<=nums.length-1;i++){
			nums[i]=0;
    }
}
}