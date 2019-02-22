package googlesheets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GSheetTest extends GoogleSheetAPI {

	@DataProvider
	Object[][] data() throws IOException {
		GoogleSheetAPI g = new GoogleSheetAPI();
		List<List<Object>> sheetData = g.getSpreadSheetRecords("10nDEOPLeoPDMayHak5wUZQvVnZKAs4ehTyt0jX5p0mE",
				"Sheet1!A:B");
		System.err.println();

		List<Object> firstRowList = sheetData.get(0);

		/*
		 * for (Object object : firstRowList) { if (object.equals("blowout")) {
		 * 
		 * 
		 * System.err.println("done"); } }
		 */
		Object[][] obj = new Object[sheetData.size()-1][1];
		Map<String, String> data = null;
		for (int i = 1; i < sheetData.size(); i++) {
			data = new HashMap<>();
			for (int j = 0; j < firstRowList.size(); j++) {

				DataFormatter df = new DataFormatter();
				// String key = df.formatCellValue(s.getRow(0).getCell(j));
				// String value = df.formatCellValue(s.getRow(i).getCell(j));
				String key = (String) firstRowList.get(j);
				// System.out.println(key);
				String value = (String) sheetData.get(i).get(j);
				// System.out.println(value);
				data.put(key, value);
				

			}
			
			obj[i - 1][0] = data;
		}
		return obj;

	}

	@Test(dataProvider = "data")
	public void testM(HashMap<String, String> data) throws IOException {
		System.err.println(data.get("haircut"));
		System.err.println(data.get("blowout"));
	}

}
