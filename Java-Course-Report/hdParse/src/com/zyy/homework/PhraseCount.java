package com.zyy.homework;

import java.io.IOException;
import java.net.URI;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class PhraseCount {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString(), "#");
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
      }
    }
  }

  public static class IntSumReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      context.write(key, result);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, PhraseCount.class.getName());
    job.setJarByClass(PhraseCount.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);
    
    job.setCombinerClass(IntSumReducer.class);
    
    job.setReducerClass(IntSumReducer.class);
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    FileSystem fsSystem = FileSystem.get(new URI(args[1]), conf);
    fsSystem.delete(new Path(args[1]), true);
    fsSystem.delete(new Path(args[2]), true);
    
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    if(!job.waitForCompletion(true)){
    	System.exit(1);
    }
    
    Job job2 = Job.getInstance(conf, SortCount.class.getName());
    job2.setJarByClass(SortCount.class);
    job2.setMapperClass(SortCount.countMapper.class);
    job2.setMapOutputKeyClass(IntWritable.class);
    job2.setMapOutputValueClass(Text.class);
    
    // job2.setCombinerClass(IntSumReducer.class);
    
    job2.setReducerClass(SortCount.countReducer.class);
    
    job2.setOutputKeyClass(IntWritable.class);
    job2.setOutputValueClass(Text.class);
    

    
    FileInputFormat.addInputPath(job2, new Path(args[1]));
    FileOutputFormat.setOutputPath(job2, new Path(args[2]));
    System.exit(job2.waitForCompletion(true) ? 0 : 1);
  }
}