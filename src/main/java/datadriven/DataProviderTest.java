package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider = "getData")
	public void testDataProvider(String user, String pwd, String cntry) {
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(cntry);
	}

	@DataProvider
	public String[][] getData() throws IOException {
		File f = new File("/home/rakesh/Documents/hash.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet("Sheet1");
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				DataFormatter Stringdata = new DataFormatter();
				data[i][j] = Stringdata.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}

		return data;

	}
}
