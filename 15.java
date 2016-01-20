public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<>();
        if (num.length<3)
            return list;
             
        Arrays.sort(num);
         
        for (int i=0; i<num.length-2; i++) {
            if(i!=0 && num[i]==num[i-1])
                continue;
                 
            int left = i+1;
            int right = num.length-1;
            while (left<right) {
                if (left>i+1 && num[left]==num[left-1]) {
                    left++;
                    continue;
                }
                if (right<num.length-2 && num[right]==num[right+1]) {
                    right--;
                    continue;
                }
                 
                int sum = num[i] + num[left] + num[right];
                if (sum==0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(num[i]);
                    item.add(num[left]);
                    item.add(num[right]);
                    list.add(item);
                     
                    left++;
                    right--;
                } else if (sum>0) {
                    right--;
                } else {
                    left++;
                }
            } // while
        } // for
         
        return list;
        
    }
}