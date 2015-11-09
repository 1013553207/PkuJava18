public class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int length = s.length();
        int result = 0;
        int i = length - 1;
        int a = map.get(s.charAt(i--));
        result = a;
        int b = 0;
        for(; i >= 0; --i) {
            b = map.get(s.charAt(i));
            if(a > b) {
                result -= b;
            }
            else result += b;
            a = b;
        }
        return result;
    }
}