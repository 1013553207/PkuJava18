public class Solution {
    public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> nums_map = new HashMap<Integer, Integer>();
            int length = nums.length;
            int mid_size = length/2;
            for(int i=0; i< length; i++){
                int value = nums_map.getOrDefault(nums[i], 0);
                nums_map.put(nums[i], ++value);
            }
            for(int k: nums_map.keySet()){
                int value = nums_map.get(k);
                if( value > mid_size){
                    return  k;
                }
            }
            return 0;   
    }
}