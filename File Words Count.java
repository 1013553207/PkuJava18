import java.util.Set;
import java.util.HashSet;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) {
		Set<String> set0 = getWords("file0.txt");
		Set<String> set1 = getWords("file1.txt");

		System.out.println("File0 Words List: " + set0);
		System.out.println("File1 Words List: " + set1);
		System.out.println("File0 Words Count: " + set0.size());
		System.out.println("File1 Words Count: " + set1.size());

		Set<String> set2 = new HashSet<>();
		set2.addAll(set0);
		set2.retainAll(set1);
		System.out.println("Merge File Words List: " + set2);
	}

	public static Set<String> getWords(String filename){
		char[] chars_buf = new char[30];
		int readLength = 0;
		BufferedReader reader = null;
		Set<String> set = new HashSet<>();
		try {
			reader = new BufferedReader(new FileReader(filename));
			String word = "";
			while((readLength = reader.read(chars_buf)) != -1){
				for(int i = 0; i < readLength; i++){
                    if( (chars_buf[i] == 39 || chars_buf[i] == 45) 
                            || (chars_buf[i] >= 65 && chars_buf[i] <= 90) 
                            || (chars_buf[i] >= 97 && chars_buf[i] <= 122) )
                        word += chars_buf[i];
						word += chars_buf[i];
					else {
						if( !word.isEmpty() ) {
							set.add(word);
							word = "";
						}
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return set;
	}
}