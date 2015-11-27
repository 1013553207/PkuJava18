public class Solution {
    public boolean isPowerOfTwo(int n) {
        if( 0 == n) return false;
        int count = 0;
        boolean flag = true;
        while(n != 0){
            if( (n & 0x01) == 1)
                count++;
            if(count >=2 ) {
                flag = false;
                break;
            }
            n = n>>1;
        }
        return  flag;
    }
}