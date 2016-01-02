package com.company;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import com.company.OneFilePipeline;
import com.company.Nlpir;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;
import us.codecraft.webmagic.selector.Selectable;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class BaiduNews implements PageProcessor {

	private Site site = Site
			.me()
			.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
			.setRetryTimes(3)
			.setSleepTime(1000);

	private static Date today = new Date();
	private final static  String url = "http://news.baidu.com/2015-01-01/?y=2015&m=01&d=01&begin_date=2015-01-01";
	private final static  String url_pat = "http://news\\.baidu\\.com/\\d+-\\d+-\\d+/\\?y=2015&m=\\d+&d=\\d+&begin_date=\\d+-\\d+-\\d+";

	private final static  String url_format = "http://news.baidu.com/%d-%02d-%02d/?y=%d&m=%02d&d=%02d&begin_date=%d-%02d-%02d";

	private final static String reg_date = "begin_date=(\\d+-\\d+-\\d+)";
	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);


	// private  final static Date today = new Date();
	@Override
	public void process(Page page) {
		Selectable url = page.getUrl();
		String[] dateInfo = null;
		System.out.println(url.toString());
		if(url.regex(url_pat).match()){
			String localdate = url.regex(reg_date).toString();
			dateInfo = localdate.split("-");
			Selectable node = page.getHtml().xpath("//div[@id=\"focus-top\"]/");

			for(String var: node.xpath("//div[@class=\"hotnews\"]").links().all()){
				System.out.println(var);
				Request request = new Request(var).setPriority(0);
				request.putExtra("date", localdate);
				request.putExtra("parse", "hotnews");
				page.addTargetRequest(request);
			}

			 for(String var: node.xpath("//ul[@class=\"focuslistnews\"]").links().all()){
				 System.out.println(var);
				Request request = new Request(var).setPriority(0);
				request.putExtra("date", localdate);
				request.putExtra("parse", "focuslistnews");
				page.addTargetRequest(request);

			}

			for(String var: node.xpath("//ul[@class=\"hotwords\"]").links().all()){
				System.out.println(var);
				Request request = new Request(var).setPriority(0);
				request.putExtra("date", localdate);
				request.putExtra("parse", "hotwords");
				page.addTargetRequest(request);

			}
			dateFormat.setLenient(false);
			String str= String.format("%d-%02d-%02d", Integer.parseInt(dateInfo[0]), Integer.parseInt(dateInfo[1]), Integer.parseInt(dateInfo[2]));
			try{
				Date newDate = dateFormat.parse(str);
				newDate = new Date(newDate.getTime() + 24 * 60 * 60 * 1000);
				if (newDate.getMonth() < today.getMonth() ||(newDate.getMonth() == today.getMonth() && newDate.getDate()<= today.getDate())) {
					String newUrl = String.format(url_format,
							newDate.getYear() + 1900, newDate.getMonth() + 1, newDate.getDate(),
							newDate.getYear() + 1900, newDate.getMonth() + 1, newDate.getDate(),
							newDate.getYear() + 1900, newDate.getMonth() + 1, newDate.getDate());
					System.out.println(newUrl);
					page.addTargetRequest(newUrl);
				}
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}else{
			String content = "";
			String text_select = "//p/text()|//strong/text()";
			if(page.getRequest().getExtra("parse").toString().contains("hotwords"))
				text_select = "//div[@class=\"c-summary c-row \"]/text()";
			List local_list =  page.getHtml().xpath(text_select).nodes();
			int length = local_list.size();
			for(int i=0; i<length; i++){
				content += local_list.get(i);
			}
			String[] localarray = page.getRequest().getExtra("date").toString().split("-");
			String keyword = null;
			try{
				keyword = Nlpir.handle(content);
			}catch (Exception ex){
				ex.printStackTrace();
			}
			if(localarray.length >= 2){
				page.putField(localarray[1],  keyword);
			}
		}
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Spider.create(new BaiduNews())
				.setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()))
				.addPipeline(new OneFilePipeline("C:\\Users\\DIY\\Desktop\\content\\"))
				.addUrl("http://news.baidu.com/2015-01-01/?y=2015&m=01&d=01&begin_date=2015-01-01")
				.thread(5)
				.run();
	}
}