package com.obsqura.selenium.FinalProject;

import org.testng.annotations.Test;

import pages.CreateNewExpenseRecord;

public class CreateNewExpenseRecordTest extends Base {
	CreateNewExpenseRecord object1;
	@Test
	public void verifyCreateExpenseRecordAndSave() {
		object1=new CreateNewExpenseRecord(driver);
		object1.createExpenseRecordAndSave();
	}

}
