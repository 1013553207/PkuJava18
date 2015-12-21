package com.company;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import com.company.OneFilePipeline;
import com.company.Nlpir;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class Main implements PageProcessor {
	public static final String URL_LIST = "http://www\\.news\\.cn/\\.*";
	public static final String URL_CONTENT = "http://.*\\.xinhuanet\\.com/\\w+/\\d+-\\d+/\\d+/c_\\d+\\.htm";
	public static final String URL_TOPNEWS = "http://www\\.xinhuanet\\.com/\\w+/\\d+/\\d+.htm";

	private String xp_select = "//div[@class=\"article\"]/p/text()|//div[@class=\"content\"]/p/text()|//span[@id=\"content\"]/p/text()|//div[@id=\"content\"]/p/text()";
	private String reg_pat = "http://news\\.xinhuanet\\.com/\\w+/(\\d+-\\d+/\\d+)/c_\\d+\\.htm";

	private Site site = Site
			.me()
			.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
			.setRetryTimes(3)
			.setSleepTime(500);

	@Override
	public void process(Page page) {
		// System.out.println(page.getUrl());
		String content = "";
		if(page.getUrl().regex(URL_LIST).match()) {
			page.addTargetRequests(page.getHtml().links().regex(URL_CONTENT).all());
		} else if(page.getUrl().regex(URL_TOPNEWS).match()){
			page.addTargetRequests(page.getHtml().links().regex(URL_CONTENT).all());
		} else if(page.getUrl().regex(URL_CONTENT).match()){

			String localtime = page.getUrl().regex(reg_pat).toString().replace('/', '-');
			String[] localarray = localtime.split("-");
			if (null == localarray || ! localarray[0].contains("2015")){
				page.setSkip(true);
				System.out.println("Skip the URL");
				return;
			}

			List mylist =  page.getHtml().xpath(xp_select).nodes();
			int length = mylist.size();
			for(int i=0; i<length; i++){
				content += mylist.get(i);
			}

			String keyword1 = page.getHtml().xpath("//meta[@name=\"keywords\"]/@content").toString();
			content += page.getHtml().xpath("//meta[@name=\"description\"]/@content").toString();
			String keyword2 = "";
			try{
				keyword2 = Nlpir.handle(content);
			}catch (Exception ex){
				ex.printStackTrace();
			}

			// String keyword = keyword1 + "#" + keyword2;
			if(null != localtime && !keyword2.isEmpty()){
				page.putField(keyword1.replace(",","#"),  keyword2);
			}
			page.addTargetRequests(page.getHtml().links().regex(URL_CONTENT).all());

		}else{
			page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
			page.addTargetRequests(page.getHtml().links().regex(URL_CONTENT).all());
		}
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Spider.create(new Main())
				.setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()))
				.addPipeline(new OneFilePipeline("C:\\Users\\DIY\\Desktop\\models\\result.txt"))
				.addUrl("http://www.xinhuanet.com/")
				.thread(5)
				.run();
	}
}