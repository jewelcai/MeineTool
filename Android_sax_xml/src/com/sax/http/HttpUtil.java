package com.sax.http;

import java.io.InputStream;
import java.net.*;

public class HttpUtil {

	public static InputStream getXML(String path) {
		InputStream inputStream = null;
		try {
			URL url = new URL(path);
			if (url != null) {
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				conn.setConnectTimeout(8000);
				conn.setDoInput(true);
				conn.setRequestMethod("GET");
				int responseCode = conn.getResponseCode();
				if (responseCode == 200) {

					inputStream = conn.getInputStream();
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return inputStream;
	}

}
