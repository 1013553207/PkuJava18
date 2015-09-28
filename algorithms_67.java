public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length(), j = b.length();
        if(i + j == 0) return "";
        else if(i == 0) return b;
        else if(j == 0) return a;
        --i;
        --j;
        int x, y, z = 0, w;
        String r = "";
        for(;i>=0 || j>=0;) {
            if(i >= 0) {
                x = Character.getNumericValue(a.charAt(i--));
            }
            else x = 0;
            if(j >= 0) {
                y = Character.getNumericValue(b.charAt(j--));
            }
            else y = 0;
            w = x + y + z;
            if(w == 0) {
                r = "0" + r;
                z = 0;
            }
            else if(w == 1) {
                r = "1" + r;
                z = 0;
            }
            else if(w == 2) {
                r = "0" + r;
                z = 1;
            }
            else if(w == 3) {
                r = "1" + r;
                z = 1;
            }
            
        }
        if(z == 1) r = "1" + r;
        return r;
    }
}