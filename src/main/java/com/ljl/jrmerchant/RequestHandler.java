package com.ljl.jrmerchant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;

import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.HttpStatus;  
import org.apache.http.NameValuePair;  
import org.apache.http.StatusLine;  
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.CloseableHttpResponse;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.entity.StringEntity;  
import org.apache.http.impl.client.CloseableHttpClient;  
import org.apache.http.impl.client.HttpClients;  
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.protocol.HTTP;  
import org.apache.http.util.EntityUtils;

//import org.apache.log4j.Logger;  
  

public class RequestHandler {

	/*
	 * 调用地址:：https://paygate.jd.com/service/uniorder
	 * 编码格式:：UTF-8
	 * 调用方式：POST
	 * 数据格式：application/xml
	 */
		
	public RequestHandler(){
	}

	
	public void doXmlRequest(String url, String encode, String reqMethod, String xmlData) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		HttpResponse httpResp = null;
		HttpEntity httpEntity = null;

        List<BasicNameValuePair> parameters = new ArrayList<>();  
        parameters.add(new BasicNameValuePair("xml", xmlData));  
        
		try {
			httpResp = httpClient.execute(httpPost);
			httpPost.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));
			httpResp = httpClient.execute(httpPost);
	        System.out.println(httpResp.toString());  
	        httpEntity = httpResp.getEntity();  
	        String result = EntityUtils.toString(httpEntity, "UTF-8");  
	        System.out.println(result); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
