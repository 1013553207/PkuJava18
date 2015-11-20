package wordCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadUtil {

	public ReadUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static String readTxtFile(String filePath,String encoding) {
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String res="";
                while((lineTxt = bufferedReader.readLine()) != null){
                	res+=lineTxt;
                }
				read.close();
//				System.out.println(buf.toString());
				return res;
			} else {
				System.out.println("找不到指定的文件呜呜呜");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错呜呜呜呜");
			e.printStackTrace();
		}
		return null;

	}


}
