package wordCount;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class UI extends JFrame implements ActionListener{
	
	JButton j1;  
    JButton j2;  
    JButton j3;  
    JTextArea jt1,jt2;
    JTextField jtf1,jtf2;
    JPanel j4,j5,j6,j7; 
    String srcFolder,desFolder;
    
	
	 public static void main(String args[]) {  
		 UI demo = new UI();  
	    }
	 
	 public UI() {  
	        init();  
	        this.setSize(600,400);
	        this.setLocation(500, 300);
//	        this.pack();
	        this.setVisible(true);  
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    }  
	 
	 public void init() {  
		 j1 = new JButton("选择第一个文件");  
		 j1.addActionListener(this);
	     j2 = new JButton("选择第二个文件"); 
	     j2.addActionListener(this);
	     j3 = new JButton("运行程序");
	     j3.addActionListener(this);
	     j4 = new JPanel();
	     j4.add(j1);
	     j4.add(j2);
	     j4.add(j3);
	     j4.setVisible(true);
//	     j5.setLayout(new GridLayout(1, 2));
	     
	     jt1 = new JTextArea();
	     jt2 = new JTextArea();
	     jtf1 = new JTextField();
	     jtf2 = new JTextField();
	     
	     
	     j6=new JPanel();
	     j6.setLayout(new BorderLayout());
	     j6.add(jt1,BorderLayout.CENTER);
	     j6.add(jtf1, BorderLayout.SOUTH);
	     
	     j7=new JPanel();
	     j7.setLayout(new BorderLayout());
	     j7.add(jt2,BorderLayout.CENTER);
	     j7.add(jtf2, BorderLayout.SOUTH);
	     
	     j5 = new JPanel();
	     j5.setLayout(new GridLayout(1, 2,5,5));
//	     j6.set
	     j5.add(j6);
	     j5.add(j7);
	     
	     this.setLayout(new BorderLayout());
	     this.add(j4,BorderLayout.NORTH);
	     this.add(j5,BorderLayout.CENTER);
//	     this.add(j4);
	     
	        
	 }
	 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 产生一个文件选择器
		if (e.getSource().equals(j1)) {
			JFileChooser jChooser = new JFileChooser();
			// 设置默认的打开目录,如果不设的话按照window的默认目录(我的文档)
//			jChooser.setCurrentDirectory(new File("/Users"));
			// 设置打开文件类型,此处设置成只能选择文件夹，不能选择文件
			jChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);// 只能打开文件夹
			// 打开一个对话框
			int index = jChooser.showDialog(null, "打开文件");
			if (index == JFileChooser.APPROVE_OPTION) {
				if(jChooser.getSelectedFile().getPath().contains(".txt")){
					srcFolder=jChooser.getSelectedFile().getPath();
				}
				else{
					srcFolder = jChooser.getSelectedFile().getPath()+".txt";

				}
			}
		}
		if(e.getSource().equals(j2)){
			JFileChooser jChooser = new JFileChooser();
			// 设置默认的打开目录,如果不设的话按照window的默认目录(我的文档)
//			jChooser.setCurrentDirectory(new File("/Users"));
			// 设置打开文件类型,此处设置成只能选择文件夹，不能选择文件
			jChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);// 只能打开文件夹
			// 打开一个对话框
			int index = jChooser.showDialog(null, "打开文件");
			if (index == JFileChooser.APPROVE_OPTION) {
				if(jChooser.getSelectedFile().getPath().contains(".txt")){
					desFolder=jChooser.getSelectedFile().getPath();
				}
				else{
					desFolder = jChooser.getSelectedFile().getPath()+".txt";

				}
			}
		}
		if(e.getSource().equals(j3)){
			jt1.setText("");
			jt2.setText("");
			jtf1.setText("");
			jtf2.setText("");
			
			if(srcFolder==null){
				jt1.append("请先选择第一个文件\n");
			}
			
			else if(desFolder==null){
				jt2.append("请先选择第二个文件\n");
			}
			
			else{
				HashSet<String> set1=ReadProcess.getOriginalSet(srcFolder);
				HashSet<String> set2=ReadProcess.getOriginalSet(desFolder);
				HashSet<String> res1=ReadProcess.getUnionSet(set1, set2);
				HashSet<String> res2=ReadProcess.getIntersectionSet(set1, set2);
				
				for(String str:res1){
					jt1.append(str+"\n");
				}
				jtf1.setText("总共有"+res1.size()+"个词语出现在两个文本中");
				
				for(String str:res2){
					jt2.append(str+"\n");
				}
				jtf2.setText("其中有"+res2.size()+"个词语在两个文本中都出现了");
				
			}
			
		}

	}
	 


}
