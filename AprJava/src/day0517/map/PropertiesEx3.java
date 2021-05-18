package day0517.map;
import java.util.*;
import java.io.*;

class PropertiesEx3 {
	public static void main(String[] args) {
		Properties prop = new Properties(); // Properties를 활용하기 위해 객체 선언

		prop.setProperty("timeout","30");
		prop.setProperty("language","한글");
		prop.setProperty("size","10");
		prop.setProperty("capacity","10");

		try {
			prop.store(new FileOutputStream("C:\\Users\\daumu\\Desktop/output.txt"), "Properties Example");
			prop.storeToXML(new FileOutputStream("C:\\Users\\daumu\\Desktop/output.xml"),  "Properties Example");
		} catch(IOException e) {
			e.printStackTrace();		
		}
	} // main의 끝
}