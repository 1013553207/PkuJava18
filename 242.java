public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map=new HashMap<>();
		
		for(int i=0;i<s.length();i++){
			if(map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			else{
				map.put(s.charAt(i),1);
			}
		}
		for(int j=0;j<t.length();j++){
			if(!map.containsKey(t.charAt(j)))
				return false;
			else{
				map.replace(t.charAt(j), map.get(t.charAt(j))-1);
			}
		}
		for(Character c:map.keySet()){
			if(map.get(c)!=0)
				return false;
		}
		return true;

}
}