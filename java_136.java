public class Solution {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<length; i++) {
            // if(map.containsKey(nums[i]))
            //    map.put(nums[i], 2);
            // else
            //    map.put(nums[i], 1);
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++value);
        }
        int result = 0;
        for(int key: map.keySet())
            if(1 == map.get(key))
                result = key;
        return  result;
    }
}