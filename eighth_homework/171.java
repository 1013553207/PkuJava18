public class Solution {
    public int titleToNumber(String s) {
        char[] char_array = s.toCharArray();
        int length = char_array.length;
        int pos = 0;
        for(int i = 0; i < length; i++){
            pos += ((char_array[i] - 'A')+1)* Math.pow(26, length-i-1);
        }
        return pos;
    }
}