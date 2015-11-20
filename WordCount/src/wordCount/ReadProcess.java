package wordCount;

import java.util.HashSet;

public class ReadProcess {

	public ReadProcess() {
		// TODO Auto-generated constructor stub
	}

//	public static void main(String[] args) {
	HashSet<String> set1=getOriginalSet("/Users/yangyudong/研究生学习/test1.txt");
//	
//	HashSet<String> set2=getOriginalSet("/Users/yangyudong/研究生学习/test2.txt");
//	
//	HashSet<String> res1=getUnionSet(set1,set2);
//	
//	HashSet<String> res2=getIntersectionSet(set1, set2);
////	
////	for(String str:res1){
////		System.out.println(str);
////	}
//	
//	for(String str:res2){
//		System.out.println(str);
//	}
//	
//	
////		System.out.println(res1.size());
////		System.out.println(text2);
////	countProcess(text1, text2);
//
//	}
	
	/**
	 * 传入一个文件路径，读取文件内容后返回一个包括其中所有词组的HashSet
	 * @param filePath
	 */
	public static HashSet<String> getOriginalSet(String filePath){
//		System.out.println(filePath);
		String text=ReadUtil.readTxtFile(filePath,"UTF-8");
		String[] word=text.split("[ \n\t\r.,;:!?(){]");
		HashSet<String> set=new HashSet<>();
		for(int i=0;i<word.length;i++){
			set.add(word[i]);
		}
//		System.out.println("here");
		return set;
		
	}
	
	public static HashSet<String> getUnionSet(HashSet<String> set1,HashSet<String> set2){
		HashSet<String> res1=new HashSet<>();//该集合用来返回第一问所要求的并集
		res1.addAll(set1);
		res1.addAll(set2);
		return res1;
	}
	
	public static HashSet<String> getIntersectionSet(HashSet<String> set1,HashSet<String> set2){
		HashSet<String> res2=new HashSet<>();//该集合用来返回第二问所要求的交集
		res2.addAll(set1);
		res2.retainAll(set2);
//		res1.addAll(set2);
		return res2;
	}
	
	
	
	
//	public static void countProcess(String text1,String text2){
//		String[] word1=text1.split("[ \n\t\r.,;:!?(){]");
//		String[] word2=text2.split("[ \n\t\r.,;:!?(){]");
//		HashSet<String> set1=new HashSet<>();
//		HashSet<String> set2=new HashSet<>();
//		for(int i=0;i<word1.length;i++){
//			set1.add(word1[i]);
//		}
//		for(int i=0;i<word2.length;i++){
//			set2.add(word2[i]);
//		}
//		HashSet<String> res1=new HashSet<>();//该集合用来返回第一问所要求的并集
//		HashSet<String> res2=new HashSet<>();//该集合用来返回第二问所要求的交集
//		
//		res1.addAll(set1);
//		res1.addAll(set2);
//		
//		res2.addAll(set1);
//		res2.retainAll(set2);
//		
////		System.out.println(res2.size());
//		
////		set1.addAll(set2);
////		System.out.println(set1.size());
//		for(String str:res1){
//			System.out.println(str);
//		}
//		System.out.println("-------------------");
//		for(String str:res2){
//			System.out.println(str);
//		}
////		System.out.println("-------------------");
////		for(String str:set2){
////			System.out.println(str);
////		}
//		
////		set1.
////		}
////		System.out.println(word1.length);
////		System.out.println(word2.length);
//	}
	Object o=new Object();
}
