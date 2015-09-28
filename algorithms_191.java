public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int i = 0, c = 0;
        for(;i<s.length();++i) {
            if(s.charAt(i) == '1') ++c;
        }
        return c;
    }
}