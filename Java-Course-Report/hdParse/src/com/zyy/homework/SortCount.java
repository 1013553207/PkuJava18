package com.zyy.homework;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class SortCount {
	
		  public static class countMapper
		       extends Mapper<Object, Text, IntWritable, Text>{

		    private Text first = new Text();
		    private Text second = new Text();

		    public void map(Object key, Text value, Context context
		                    ) throws IOException, InterruptedException {
		      first.clear();
		      second.clear();
		      StringTokenizer itr = new StringTokenizer(value.toString(), "\t");
		      while (itr.hasMoreTokens()) {
		    	  second.set(first.toString());
		    	  first.set(itr.nextToken());  
		      }
	    	  try{
	    		  context.write(new IntWritable(Integer.parseInt(first.toString())), second);
	    	  }catch(Exception ex){
	    		  System.out.println(first.toString());
	    	  }
		    }
		  }

		  public static class countReducer
		       extends Reducer<IntWritable,Text,IntWritable, Text> {
		    
		    public void reduce(IntWritable key, Iterable<Text> values,
		                       Context context
		                       ) throws IOException, InterruptedException {
		      String result = "";
		      for (Text val : values) {
		    	  	result += val.toString();
		    	  	result += ",";
		      }
		      context.write(key, new Text(result));
		    }
		  }
}
