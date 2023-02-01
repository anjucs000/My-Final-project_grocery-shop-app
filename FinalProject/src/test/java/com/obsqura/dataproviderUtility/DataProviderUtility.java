package com.obsqura.dataproviderUtility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name="NewDeliveryBoyRecord")
	public Object[][] getDataFromDataprovider(){
		return new Object[][]
		{
			{"John Samuel","john123@gmail.com","556485226","Sam villa,North carolina,Zip-45236"}
		};
	}

}
