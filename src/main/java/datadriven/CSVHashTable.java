package datadriven;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
public class CSVHashTable {
	@DataProvider
	public Object[][] demo() throws InterruptedException, IOException {
		CSVReader r = new CSVReader(new FileReader("/home/rakesh/Downloads/sample.csv"));

		List<String[]> totalList = r.readAll();
		String[] firstRow = totalList.get(0);
		int colCount = firstRow.length;
		int rowCount = totalList.size();
		Object[][] obj = new Object[rowCount - 1][1];

		for (int i = 1; i < rowCount; i++) {
			Hashtable<String, String> data = new Hashtable<String, String>();
			for (int j = 0; j < colCount; j++) {

				String key = firstRow[j];
				String[] d = totalList.get(i);
				String value = d[j];
				data.put(key, value);

			}
			obj[i - 1][0] = data;
		}

		return obj;

	}

	@Test(dataProvider = "demo")
	public void testCSV(Hashtable<String, String> d) {
		System.out.println("final out put>>>>>>>" + d.get("user"));
		System.out.println(">>>>>>>" + d.get("pass"));

	}

}
