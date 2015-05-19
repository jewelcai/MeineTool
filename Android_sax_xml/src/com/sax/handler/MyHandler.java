package com.sax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class MyHandler extends DefaultHandler {
	private HashMap<String, String> hm = null;
	private List<HashMap<String, String>> list = null;
	private String currentTag = null;
	private String currentValue = null;
	private String nodeName = null;

	public MyHandler(String nodeName) {
		this.nodeName = nodeName;
	}
	
	
	public List<HashMap<String, String>> getList() {
		return list;
	}

	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		list = new ArrayList<HashMap<String, String>>();
	}


	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if (qName.equals(nodeName)) {
			hm = new HashMap<String, String>();
		}
		if (attributes != null && hm != null) {
			for (int i = 0; i < attributes.getLength(); i++) {
				hm.put(attributes.getQName(i), attributes.getValue(i));
			}

		}
		currentTag = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		if (currentTag != null && hm != null) {
			currentValue = new String(ch, start, length);
			if (currentValue != null && !currentValue.trim().equals("")
					&& !currentValue.trim().equals("\n")) {
				hm.put(currentTag, currentValue);
			}
		}
		currentTag = null;
		currentValue = null;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		if(qName.equals(nodeName))
		{
			list.add(hm);
			hm=null;
		}
		
		super.endElement(uri, localName, qName);
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

}
