package com.ljl.jrmerchant;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;



public class TestHttp {
	
	public TestHttp() {
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://www.baidu.com");
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpEntity ent = response.getEntity();
		
		if (ent != null) {
			InputStream instream = null;
			try {
				instream = ent.getContent();
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int l;
			byte[] tmp = new byte[1024];
			StringBuilder sb = new StringBuilder();

			try {
				while ((l = instream.read(tmp)) != -1) {
					sb.append(new String(tmp,"UTF-8"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(sb);
		}
	}
	public static void main(String args[]) {
		TestHttp th = new TestHttp();
	}
}
