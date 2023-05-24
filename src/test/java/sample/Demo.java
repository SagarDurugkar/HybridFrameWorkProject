package sample;

import java.util.Date;

public class Demo {

	public static void main(String[] args) {

		Date d1=new Date();
		String str = d1.toString();
		String str2 = d1.toString().replace(" ", "_");
		String str3 = d1.toString().replace(" ", "_").replace(":","_");
		
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str3);
	}

}
