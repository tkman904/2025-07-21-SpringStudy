package com.sist.main2;

import java.util.*;
import java.io.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ClassPathXmlApplicationContext implements ApplicationContext {
	private Map clsMap = new HashMap();

	public ClassPathXmlApplicationContext(String path) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLParse xml = new XMLParse();
			sp.parse(new File(path), xml);
			clsMap = xml.getMap();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public Object getBean(String key) {
		// TODO Auto-generated method stub
		return clsMap.get(key);
	}
}
