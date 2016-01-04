public class Solution {
    public int[] twoSum(int[] nums, int target) {
     HashMap<Integer, Integer> m = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (m.containsKey(target - nums[i])) {
				int index1 = m.get(target - nums[i]) <= i + 1 ? m.get(target - nums[i]) : i + 1;
				int index2 = m.get(target - nums[i]) > i + 1 ? m.get(target - nums[i]) : i + 1;
				return new int[] { index1, index2 };
			} else {
				m.put(nums[i], i + 1);
			}

		}
		return null;
}
}