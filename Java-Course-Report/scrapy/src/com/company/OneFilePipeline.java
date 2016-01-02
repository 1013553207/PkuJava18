package com.company;

/**
 * Created by DIY on 2015/12/19.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map;

public class OneFilePipeline extends FilePersistentBase implements Pipeline {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private String basePath = null;
	private Map<String, PrintWriter> writeMap = new HashMap<>(20);
	static final Properties PROPERTIES = new Properties(System.getProperties());
	static final String planText = ".txt";
	// private PrintWriter printWriter;

	/**
	 * create a FilePipeline with default path"/data/webmagic/"
	 */
	public static String getPathSeparator(){
		return PROPERTIES.getProperty("file.separator");
	}
	public OneFilePipeline() {
		basePath = "./";
	}
	public OneFilePipeline(String basePath) {
		this.basePath = basePath;
	}

	public PrintWriter getPrintWrite(String name) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter printWriter = writeMap.getOrDefault(name, null);
		if(null != printWriter){
			return  printWriter;
		}else {
			String fullPath = basePath + getPathSeparator() + name + planText;
			printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(getFile(fullPath)), "UTF-8"));
			writeMap.put(name, printWriter);
		}
		return printWriter;
	}

	@Override
	public synchronized void process(ResultItems resultItems, Task task) {
		for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
			String key = entry.getKey();
			PrintWriter printWriter = null;
			try{
				printWriter = getPrintWrite(key);
			}catch (Exception ex){
				ex.printStackTrace();
				return;
			}
			if (entry.getValue() instanceof Iterable) {
				Iterable value = (Iterable) entry.getValue();
				// printWriter.println(entry.getKey() + "");
				for (Object o : value) {
					printWriter.println(o);
				}
			} else {
				printWriter.println(entry.getValue());
			}
			printWriter.flush();
		}
		/*
		 for(PrintWriter p : writeMap.values()){
			 p.flush();
		 }
		*/
	}
}
