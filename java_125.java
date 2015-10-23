public class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        char[] chArray = s.toCharArray();
        int i=0, j=chArray.length-1;
        while(i<=j) {
            if(!isAlphanumeric(chArray[i])){
                i++;
                continue;
            }
            if(!isAlphanumeric(chArray[j])){
                j--;
                continue;
            }
            if(toLow(chArray[i]) != toLow(chArray[j]))
                return  false;
            else{
                i++;
                j--;
            }
        }
        return  true;
    }
    private boolean isAlphanumeric(char i){
        boolean flag = false;
        if(i>=48 && i<=57) {
            flag = true;
        }
        else if(i>=65 && i<=90) {
            flag = true;
        }
        else if (i>=97 && i<=122){
            flag = true;
        }
        else {
            flag = false;
        }
        return  flag;
    }
    private char toLow(char ch){
        if(ch>=65 && ch<=90)
            ch = (char)(ch+len);
        return  ch;
    }
    private short  len = 'a' - 'A';
}