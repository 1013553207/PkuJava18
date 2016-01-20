public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
          int re = 0;

        while(0 != n)
        {
            n = n&(n - 1);
            ++re;
        }

        return re;
    }
}