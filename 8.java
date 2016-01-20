public class Solution {
    public int myAtoi(String str) {
     int res=0;
		int flag=1;
		int i=0;
		if(str==null||str.equals("")){
			return 0;
		}
		else{
			while(str.charAt(i)==' '&&i<str.length()){
				i++;
			}
			if(str.charAt(i)=='+'){
				i++;
			}
			else if(str.charAt(i)=='-'){
				i++;
				flag=-1;
			}
			while(i<str.length()){
				if(str.charAt(i)<'0'||str.charAt(i)>'9')
					break;
				if ((flag == 1) && ((res > Integer.MAX_VALUE / 10)
						|| ((res == Integer.MAX_VALUE / 10) && ((str.charAt(i) - '0') > Integer.MAX_VALUE % 10)))) {
					return Integer.MAX_VALUE;
				}
				if ((flag == -1) && ((res > Integer.MAX_VALUE / 10)
						|| ((res == Integer.MAX_VALUE / 10) && ((str.charAt(i) - '0') > Integer.MAX_VALUE % 10+1)))) {
					return Integer.MIN_VALUE;
				}
				res=res*10+(str.charAt(i)-'0');
				i++;
			}
			
			return res*flag;
		}
}
}