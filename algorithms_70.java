public class Solution {
    public int climbStairs(int n) {
        int i = 1, j = 0;
        for(int k = 0; k < n; ++k) {
            i += j;
            j = i - j;
        }
        return i;
    }
}