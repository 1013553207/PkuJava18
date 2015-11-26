public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean carry = true;
        for(int i = len - 1; i >= 0; --i ) {
            if(carry) {
                if(digits[i] == 9) {
                    digits[i] = 0;
                    carry = true;
                }
                else {
                    digits[i] += 1;
                    carry = false;
                }
            }
            
            if(i == 0 && digits[i] == 0) {
                int[] ans = new int[len + 1];
                ans[0] = 1;
				for (int j = 1; j <= len; ++j) {
					ans[j] = 0;
				}
				return ans;
            }
        }
        return digits;
    }
}