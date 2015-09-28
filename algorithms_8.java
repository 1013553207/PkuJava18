public class Solution {
    
    final static int INT_MAX = 2147483647;
    final static int INT_MIN = -2147483648;
    
    public int myAtoi(String str) {
        boolean enterNumber = false;
        int number = 0, sign = 0, i = 0;
        long n = 0;
        char s;
        for(;i<str.length();++i){
            s=str.charAt(i);
            if(s == '-') {
                if(enterNumber) return 0;
                enterNumber = true;
                sign = -1;
            }
            else if(s == '+') {
                if(enterNumber) return 0;
                enterNumber = true;
                sign = 1;
            }
            else if(s >= '0' && s<= '9'){
                enterNumber = true;
                if(sign == 0) sign = 1;
                n = n * 10 + s - '0';
                if(n * sign > INT_MAX) {
                    return INT_MAX;
                }
                else if(n * sign < INT_MIN) {
                    return INT_MIN;
                }
            }
            else if(enterNumber) {
                break;
            }
            else if(s != ' ') break;
        }
        
        number = (int) (n * sign);
        return number;
    }
}