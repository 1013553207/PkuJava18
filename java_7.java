public class Solution {
    public int reverse(int x) {
        long t = x, y = 0, tmp;
        while(t != 0){
            tmp = t%10;
            t = t/10;
            y = y*10;
            y += tmp;
        }
        if(y > max || y<min) {y = 0;}
        return (int)y;
    }
    private int max = 2147483647;
    private int min = -2147483648;
}