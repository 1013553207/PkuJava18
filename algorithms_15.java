public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length < 3) return lists;
        Set set = new HashSet();
        int i, j, k, m;
        Arrays.sort(nums);
        for(i = 0; i < nums.length - 2; ++i) {
            if(nums[i] + nums[i + 1] + nums[i + 2] > 0) return lists;
            j = i + 1;
            k = nums.length - 1;
            while(j < k) {
                m = nums[i] + nums[j] + nums[k];
                if(m == 0) {
                    if(set.add(Arrays.asList(nums[i], nums[j], nums[k])))
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                }
                else if(m < 0) ++j;
                else --k;
            }
        }
        return lists;
    }
}