public class Solution {
    public String reverseWords(String s) {
        String []str_array = s.split(" ");
        String tmp = "";
        List<String> str_list = new ArrayList<String>();
        for(int i=0; i<str_array.length; i++) {
            if(str_array[i] == " " || str_array[i].isEmpty()) continue;
            str_list.add(str_array[i]);
        }
        for(int i=str_list.size()-1; i>=0; i--) {
            tmp += str_list.get(i);
            if(i != 0) tmp += ' ';
        }
        return  tmp;
    }
}