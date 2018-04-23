package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javafx.scene.input.DataFormat;

public class HashTable_Test {
//	@Test(dataProvider = "test")
	public void demo(HashMap<String, String> d) {
		System.out.println("*************");
		System.out.println(d.get("username"));
		System.out.println(d.get("password"));
		System.out.println(d.get("name"));
	}

	// @DataProviderTest(name = "test")
	public static Object[][] getData(String excelPath, String sheetName) throws IOException {
		File f = new File(excelPath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet(sheetName);
		int rowCount = s.getLastRowNum();
		int colCount = s.getRow(0).getLastCellNum();
		 System.out.println("rows>>>>>>>"+rowCount);
		 System.out.println("coloumns>>>>"+colCount);
		Object[][] obj = new Object[rowCount][1];

		for (int i = 1; i <= rowCount; i++) {
			HashMap<String, String> data = new HashMap<String, String>();
			for (int j = 0; j < colCount; j++) {

				// data.put(s.getRow(0).getCell(j).getStringCellValue(),
				// s.getRow(i).getCell(j).getStringCellValue());
				DataFormatter df = new DataFormatter();
				String key = df.formatCellValue(s.getRow(0).getCell(j));
				String value = df.formatCellValue(s.getRow(i).getCell(j));
				data.put(key, value);

			}
			obj[i - 1][0] = data;
		}

		return obj;

	}

}
