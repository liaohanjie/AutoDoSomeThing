package cainiaolicai;

import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import util.HttpClientRequest;
import util.HttpClientUtil;
import util.HttpRequest;

public class cnlc_flow {
//	public static void main(String[] args) {
//		cnlc_login aa = new cnlc_login();
//		aa.login();
//	}
	public void autoDo(cnUser user){
		HttpClientUtil httpUtil = new HttpClientUtil();
		Map<String,String> para = new HashMap<String, String>();
		para.put("telephone", user.getTelephone());
		para.put("password", user.getPassword());
		//��¼
		String login_res = httpUtil.doPost("http://app.cainiaolc.com/user/login", para, "utf-8");
		System.out.println(login_res);
		//�鿴�˵�
		String coin_userSumary = httpUtil.doGet("http://app.cainiaolc.com/coin/userSummary", "utf-8");
		System.out.println(coin_userSumary);
		//��ҳ
		String api_homeData = httpUtil.doGet("http://app.cainiaolc.com/api/homeData", "utf-8");
		System.out.println(api_homeData);
		List<String> ids = new ArrayList<String>();
		getIDs(api_homeData,ids);
		
        for (String id : ids) {
        	//�鿴����
        	String article_detailSimple = httpUtil.doGet("http://app.cainiaolc.com/article/detailSimple?id="+id, "utf-8");
    		System.out.println(article_detailSimple);
    		String coin_userSumary2 = httpUtil.doGet("http://app.cainiaolc.com/coin/userSummary", "utf-8");
    		System.out.println(coin_userSumary2);
    		try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        //����
//        String forum_content = "����˵һ���˵��ʽ��ŷ�ɢͶ�ʵ����ٸ�ƽ̨���ʣ�";
//        Map<String,String> forum_para = new HashMap<String, String>();
//        try {
////			forum_para.put("content-disposition: form-data; name=\"content\"\r\n" + 
////					"Content-Length: "+forum_content.getBytes("utf-8").length, forum_content);
////			forum_para.put("content-disposition: form-data; name=\"category\"\r\n" + 
////		        		"Content-Length: 3", "p2p");
////		    forum_para.put("content-disposition: form-data; name=\"cateId\"\r\n" + 
////		    		"Content-Length: 6", "225410");
////		    forum_para.put("content-disposition: form-data; name=\"upload\"\r\n" + 
////		    		"Content-Length: 1", "0");
//		    forum_para.put("content", forum_content);
//			forum_para.put("category", "p2p");
//		    forum_para.put("cateId", "225410");
//		    forum_para.put("upload", "0");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//       
//        String forum_post = httpUtil.doFormPost("http://app.cainiaolc.com/forum/post", forum_para, "utf-8");
//		System.out.println(forum_post);
//		String coin_userSumary3 = httpUtil.doGet("http://app.cainiaolc.com/coin/userSummary", "utf-8");
//		System.out.println(coin_userSumary3);
		//�ղ�����
		int randomId = (new Random()).nextInt(ids.size());
		String article_detailSimple = httpUtil.doGet("http://app.cainiaolc.com/article/favor?id="+ids.get(randomId)+"&status=1", "utf-8");
		System.out.println(article_detailSimple);
		String coin_userSumary4 = httpUtil.doGet("http://app.cainiaolc.com/coin/userSummary", "utf-8");
		System.out.println(coin_userSumary4);
		//��������
		for(int i=0;i<2;i++) {
			int shareRandomId = (new Random()).nextInt(ids.size());
			Map<String,String> share = new HashMap<String, String>();
			System.out.println(ids.get(shareRandomId));
			share.put("path", "/articleShare");
			share.put("referer", "/article/"+ids.get(shareRandomId));
			String share_result1 = httpUtil.doPost("http://app.cainiaolc.com/log/menuClick", para, "utf-8");
			share.clear();
			share.put("fk", ids.get(shareRandomId));
			share.put("type", "7");
			String share_result2 = httpUtil.doPost("http://app.cainiaolc.com/log/articleShare", para, "utf-8");
			System.out.println(share_result1 + " and "+share_result2);	
			String coin_userSumary5 = httpUtil.doGet("http://app.cainiaolc.com/coin/userSummary", "utf-8");
			System.out.println(coin_userSumary5);
		}
		
	}
	public void getIDs(String api_homeData,List<String> ids) {
		JSONObject json1 = JSONObject.parseObject(api_homeData);
		JSONObject json1_data = (JSONObject)json1.get("Data");
		JSONArray  articles = json1_data.getJSONArray("articles");
//		JSONArray  carousels = json1_data.getJSONArray("carousels");
//		JSONArray  posts = json1_data.getJSONArray("posts");
//		JSONArray  refers = json1_data.getJSONArray("refers");
		getJsonID(articles, ids);
//		getJsonID(carousels, ids);
//		getJsonID(posts, ids);
//		getJsonID(refers, ids);
	}
	
	public void getJsonID(JSONArray  jsonArray,List<String> ids) {
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) { 
        	JSONObject job = (JSONObject) iterator.next(); 
        	ids.add(job.get("id").toString());
        }
	}
	
}