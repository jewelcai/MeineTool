package com.pull.parser;

import java.beans.XMLDecoder;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import domain.Person;

public class PullXmlTools {

	/**
	 * @param inputStream
	 * @param encode
	 * @return
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	public static List<Person> parserXML(InputStream inputStream, String encode)
			throws Exception {
		List<Person> list = null;
		Person person = null;

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser parser = factory.newPullParser();
		parser.setInput(inputStream, encode);
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
			case XmlPullParser.START_DOCUMENT:
				list = new ArrayList<Person>();
				break;
			case XmlPullParser.START_TAG:
				if ("person".equals(parser.getName())) {
					person = new Person();
					int id = Integer.parseInt(parser.getAttributeValue(0));
					// int id = Integer.parseInt(parser.nextText());
					person.setId(id);

				} else if ("name".equals(parser.getName())) {
					String name = parser.nextText();
					person.setName(name);
				} else if ("age".equals(parser.getName())) {
					int age = Integer.parseInt(parser.nextText());
					person.setAge(age);

				}
				break;
			case XmlPullParser.END_TAG:
				if ("person".equals(parser.getName())) {
					list.add(person);
					person = null;
				}
				break;
			default:
				break;
			}
			eventType = parser.next();

		}
		return list;
	}

}
