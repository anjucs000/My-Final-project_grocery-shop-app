package com.obsqura.dataproviderUtility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name="NewDeliveryBoyRecord")
	public Object[][] getDataFromDataprovider(){
		return new Object[][]
		{
			{"John Samuel","john123@gmail.com","556485226","Sam villa,North carolina,Zip-45236"},
			{"George Antony","anto@gmail.com","445255694","Leo mansion,ontario,zip-425569"}
		};
	}
	@DataProvider(name="LoginPage")
	public Object[][] getDataForLoginPageFromDataprovider(){
		return new Object[][]
		{
			{"admin","admin"},
			{"admin123","admin123"},
			{"abc","abc"},
			{"admin","admin123"},
			{"12345","abc"}
		};
	}
}

