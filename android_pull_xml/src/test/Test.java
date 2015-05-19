package test;

import java.io.InputStream;
import java.util.List;

import com.httpUtils.HttpUtils;
import com.pull.parser.PullXmlTools;

import domain.Person;

public class Test {

	public static void main(String[] args) {
		
		String path="http://10.108.89.239:8080/JavaWebTest/name.xml";
		InputStream inputStream = HttpUtils.getXML(path);
		try {
			List<Person> list = PullXmlTools.parserXML(inputStream, "utf-8");
			for(Person person : list)
			{
				System.out.println(person.toString());
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
