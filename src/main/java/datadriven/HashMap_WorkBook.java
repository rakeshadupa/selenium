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



public class HashMap_WorkBook {
	@DataProvider
	public static Object[][] getWorkbookData() throws IOException {
		Object[][] obj = null;
		Map<String, String> data = null;
		try {
			File f = new File("excel path");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = null;

			try {
				w = WorkbookFactory.create(fis);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
			int noOfSheets = w.getNumberOfSheets();
			int rowsss = 0;
			int coloumnsss = 0;
			for (int a = 0; a < noOfSheets; a++) {
				Sheet s = w.getSheetAt(a);
				rowsss += s.getLastRowNum();
				coloumnsss += s.getRow(0).getLastCellNum();

			}

			Sheet s = w.getSheetAt(0);
			int rowCount = s.getLastRowNum();

			obj = new Object[rowCount][1];

			for (int i = 1; i <= rowCount; i++) {
				data = new HashMap<String, String>();
				for (int z = 0; z < noOfSheets; z++) {
					int cCount = w.getSheetAt(z).getRow(0).getLastCellNum();
					for (int j = 0; j < cCount; j++) {

						DataFormatter df = new DataFormatter();
						String key = df.formatCellValue(w.getSheetAt(z).getRow(0).getCell(j));
						String value = df.formatCellValue(w.getSheetAt(z).getRow(i).getCell(j));
						data.put(key, value);
					}

				}

				obj[i - 1][0] = data;

			}
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		return obj;

	}
}
