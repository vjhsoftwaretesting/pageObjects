package testcases;

import org.testng.annotations.Test;

public class RoughClass {
	static String months = "";
	@Test
	public void dd() {
	//Date
		String date="17/12/2024";
		String[] dat = date.split("/");
		String day = dat[0];
		String month = dat[1];
		String year = dat[2];
		
			
		if (month=="12") {
			months = "sam";}
		
		System.out.println(months);
		
		

		
		
	}
	
}
