public class Solution {
    public void sortColors(int[] nums) {
     //System.out.println(nums);
        int end = nums.length;
        //快速排序
        quicksort(0, end - 1, nums);
    }

    public void quicksort(int start, int end, int[] nums)
    {
        if(start >= end) return;
        int low = start;
        int high =end;
        int key = nums[low];
        while(low < high) {
            while (low < high && key <= nums[high]) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
                low++;
            }
            while (low < high && nums[low] <= key) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
                high--;
            }
        }
        nums[low] = key;
        quicksort(start, low-1, nums);
        quicksort(low + 1, end, nums);
    }
}
