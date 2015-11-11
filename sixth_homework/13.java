public class Solution {
    public int romanToInt(String s) {
            char roma[] = s.toCharArray();
            int  c_prev=0;
            int  x_prev=0;
            int  I_prev=0;
            int result=0;
            for(int i=0; i< roma.length; i++)
            {
                switch(roma[i])
                {
                    case 'M':
                        result += c_prev>0? 900:1000;
                        c_prev=0;
                        break;
                    case 'D':
                        result += c_prev>0? 400:500;
                        c_prev=0;
                        break;
                    case 'C':
                        if(x_prev==0)
                        {
                            c_prev++;
                            break;
                        }
                        else
                        {
                            result+=90;
                            x_prev=0;
                            break;
                        }
         
                    case 'L':
                        result+=x_prev>0?40:50;
                        x_prev=0;
                        break;
                    case 'X':
                        if(I_prev==0)
                        {
                            x_prev++;
                            break;
                        }
                        else
                        {
                            result+=9;
                            I_prev=0;
                            break;
                        }
                    case 'V':
                        result+=I_prev>0?4:5;
                        I_prev=0;
                        break;
                    case 'I':
                        I_prev++;
                        break;
                }
            }
            result=result+100*c_prev+10*x_prev+I_prev;
            return result; 
        
    }
}