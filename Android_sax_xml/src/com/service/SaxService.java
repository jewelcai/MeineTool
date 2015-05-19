package com.service;

import java.io.InputStream;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.sax.handler.MyHandler;

public class SaxService {

	public static List<HashMap<String, String>> readXML(
			InputStream inputstream, String nodeName) {

		List<HashMap<String, String>> list = null;
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser parser= spf.newSAXParser();
			MyHandler handler= new MyHandler(nodeName);
			parser.parse(inputstream, handler);
			inputstream.close();
			return handler.getList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
}
