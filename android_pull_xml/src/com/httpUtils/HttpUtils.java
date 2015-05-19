package com.httpUtils;

import java.io.*;
import java.net.*;

public class HttpUtils {

	public static InputStream getXML(String path) {
		InputStream inputStream = null;
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(8000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();
			if (responseCode == 200) {
				inputStream = conn.getInputStream();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return inputStream;
	}

}
