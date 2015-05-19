package com.sax.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import com.sax.http.HttpUtil;
import com.service.SaxService;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String path = "http://10.108.89.239:8080/JavaWebTest/name.xml";

		InputStream inputStream = HttpUtil.getXML(path);
		try {
			List<HashMap<String, String>> list = SaxService.readXML(
					inputStream, "person");
			for (HashMap<String, String> hm : list) {
				System.out.println(hm.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
