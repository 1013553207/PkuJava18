public class Solution {
    public String intToRoman(int num) {
        char alpha[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        String roman = "";
        int bit = 0;
        while (num > 0)  
        {  
            int tempnum = num % 10;
            switch (tempnum)  
            {  
                case 3:  
                {   
                    roman = alpha[bit]+roman;  
                    tempnum--;
                }  
                case 2:  
                {  
                    roman = alpha[bit]+roman;  
                    tempnum--;
                }  
                case 1:  
                {  
                    roman = alpha[bit]+roman;  
                    break;  
                }  
                case 4:  
                {  
                    roman = alpha[bit + 1]+roman;
                    roman = alpha[bit]+roman;  
                    break;  
                }  
                case 8:  
                {  
                    roman = alpha[bit]+roman; 
                    tempnum--;
                }  
                case 7:  
                {  
                    roman = alpha[bit]+roman; 
                    tempnum--;
                }  
                case 6:  
                {  
                    roman = alpha[bit]+roman;  
                    tempnum--;
                }  
                case 5:  
                {  
                    roman = alpha[bit + 1]+roman;  
                    break;  
                }  
                case 9:  
                { 
                    roman = alpha[bit + 2]+roman; 
                    roman = alpha[bit]+roman; 
                    break;  
                }  
                default:  
                {  
                    break;  
                }  
            }  
            bit += 2;  
            num = num/10;  
        }  
     return roman;
    }
}