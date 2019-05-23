package com.maven.sample;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;



public class Interview {

	
	@Test
	public  void test() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		/*File f1=new File("C:\\Users\\Rakesh\\Desktop\\interview.xlsx");
		FileReader fr= new FileReader(f1);
		ObjectOutputStream oos=new ObjectOutputStream(f1);
		WorkbookFactory w=new WorkbookFactory();
		Sheet s1=new Sheet("testsignup");
		int lastRowNumber=s1.getLastRowNum();
		int lastCellNumber=s1.getLastCellNum();
		for(int i=1; i<=lastRowNumber; i++)
		{
			for(int j=1;j<=lastCellNumber;j++)
			{
				String s2=w.getSheet(s1).getRow(i).getCell(j).getText();
				System.out.println(s2);
			}
		}
		
		
		
		*/
		
		File f=new  File("C:\\Users\\Rakesh\\Desktop\\interview.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=WorkbookFactory.create(fis);
		Sheet s=w.getSheetAt(0);
		System.err.println(s.getLastRowNum());
		for (int i = 0; i < s.getLastRowNum(); i++) {
			for (int j = 0; j < s.getRow(0).getLastCellNum(); j++) {
				DataFormatter format=new DataFormatter();
				String cellValue=format.formatCellValue(s.getRow(i).getCell(j));
				System.err.println(cellValue);
			}
			
		}
				
		
	}




}
