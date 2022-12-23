package com.crm.crmApp_1;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.crm.crmApp_1.base.ExcelReader;
import com.crm.crmApp_1.base.Keywords;

public class LoginTest {
	
	
	@Test
	public void loginTest() {
		Keywords key = new Keywords();
		ArrayList testData = ExcelReader.getTestData("D://test//loginTestCase.xlsx");
		for (int i = 0; i < testData.size(); i++) {
			if(testData.get(i).equals("open")) {
				key.open();
			}
			if(testData.get(i).equals("url")) {
				String httpUrl = testData.get(i+1).toString();
				key.url(httpUrl);
			}
			if(testData.get(i).equals("input")) {
				String data = testData.get(i+1).toString();
				String objectname = testData.get(i+2).toString();
				key.input(data,objectname);
			}
			if(testData.get(i).equals("click")) {
				String objectname = testData.get(i+2).toString();
				key.click(objectname);
			}
			if(testData.get(i).equals("close")) {
				key.close();
			}
		}
	}
}
