package org.assertpractice;

import org.base.BaseClass;
import org.testng.annotations.DataProvider;

public class DataProviderBasic extends BaseClass {

	
	@DataProvider(name = "Login")
	private Object[][] getLoginDatas() {
		
		return new Object[][] {
			
			{ excelRead(0, 0), excelRead(0, 1)},
			{ excelRead(1, 0), excelRead(1, 1)},
			{ excelRead(2, 0), excelRead(2, 1)},
			{ excelRead(3, 0), excelRead(3, 1)},
			{ excelRead(4, 0), excelRead(4, 1)},			
		};	
	}	

}
