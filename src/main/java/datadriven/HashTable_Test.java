package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HashTable_Test {
	@Test(dataProvider = "test")
	public void demo(HashMap<String, String> d) {
		if (d.get("Runmode").equals("yes")) {
			
	
		System.out.println(d.get("a"));
		System.out.println(d.get("b"));
		}
	}

	@DataProvider(name = "test")
	public static Object[][] getData(String path, String sheetName) throws
	IOException {
	//public static Object[][] getData() throws IOException {

		File f = new File("/home/rakesh/Downloads/urban_clap.xlsx");
		// File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook w = null;
		try {
			w = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		Sheet s = w.getSheet("category");
		int rowCount = s.getLastRowNum();
		int colCount = s.getRow(0).getLastCellNum();
		System.out.println("rows>>>>>>>" + rowCount);
		System.out.println("coloumns>>>>" + colCount);
		Object[][] obj = new Object[rowCount][1];

		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> data = new HashMap<>();
			for (int j = 0; j < colCount; j++) {


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
