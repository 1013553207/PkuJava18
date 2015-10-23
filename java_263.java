public class Solution {
    public boolean isUgly(int num) {
            if(1 == num) return true;
            if(0 == num) return false;
            while(num != 0 && num%2 == 0) {
                num = num/2;
                continue;
            }
            while(num != 0 && num%5 ==0) {
                num = num/5;
                continue;
            }
            while (num != 0 && num%3 == 0) {
                num = num/3;
                continue;
            }
            //System.out.println(2%2);
            if(num == 1)
                return true;
            else
                return false;
        
    }
}