import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		String file_name1 = "file1.txt";
		String file_name2 = "file2.txt";
		Set<String> set1 = getWords(file_name1);
		Set<String> set2 = getWords(file_name2);
		System.out.println("file1 word list:" + set1);
		System.out.println("file2 word list:" + set2);
		System.out.println("file1 word list size:" + set1.size());
		System.out.println("file2 word list size:" + set2.size());
		Set<String> result = new HashSet<>();
		result.addAll(set1);
		result.retainAll(set2);
		System.out.println("file1 ∩ file2:" + result);
	}
	public static Set<String> getWords(String filename){
		char[] chars_buf = new char[30];
		int reads = 0;
		BufferedReader reader = null;
		Set<String> set = new HashSet<>();
		try{
			reader = new BufferedReader(new FileReader(filename));
			String tmp = "";
			while((reads = reader.read(chars_buf)) != -1){
				for(int i = 0; i< reads; i++){
					if((chars_buf[i]>=65 && chars_buf[i] <=90) || (chars_buf[i]>=97 && chars_buf[i] <=122)||
							(chars_buf[i] == 39 || chars_buf[i] == 45))
						tmp += chars_buf[i];
					else {
						if(!tmp.isEmpty()) {
							set.add(tmp);
							tmp = "";
						}
					}
				}
			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}finally {
			if (reader != null)
				try{
					reader.close();
				}catch (IOException e){

				}
		}
		return  set;
	}
}
