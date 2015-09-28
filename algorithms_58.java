public class Solution {
    public int lengthOfLastWord(String s) {
        int l = s.length() - 1;
        int c = 0;
        char a;
        for(;l >= 0;--l) {
            a = s.charAt(l);
            if(a != ' ') ++c;
            else if(c != 0) return c;
        }
        return c;
    }
}