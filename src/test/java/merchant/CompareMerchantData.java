package merchant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class CompareMerchantData {

	private String filePath = "./src/merchant.xlsx";
	private File f;
	private FileInputStream fis;
	private Workbook w;
	private List<String> data;

	@Test
	private void testCompareMerchantData() throws EncryptedDocumentException, InvalidFormatException, IOException {

		List<String> inputList = getExcelColoumnData("inputfile");
		List<String> ccrTansList = getExcelColoumnData("ccrtans");
		int uncommonRowCount = 1;
		for (int i = 0; i < ccrTansList.size(); i++) {

			String ccrTrans = ccrTansList.get(i);
			boolean status = false;

			for (int j = 0; j < inputList.size(); j++) {

				if (ccrTrans.equals(inputList.get(j))) {
					status = true;
					break;

				}

			}
			if (!status) {
				writeUncommonData("uncommondata", getRowData("ccrtans", i + 1), uncommonRowCount);
				uncommonRowCount++;
			}

		}
		closeExcelConnections();

	}

	public CompareMerchantData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		f = new File(filePath);
		fis = new FileInputStream(f);
		w = WorkbookFactory.create(fis);
	}

	private List<String> getExcelColoumnData(String sheetName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		Sheet s = w.getSheet(sheetName);
		int rows = s.getLastRowNum();
		data = new ArrayList<String>();
		for (int i = 1; i <= rows; i++) {
			DataFormatter format = new DataFormatter();
			data.add(format.formatCellValue(s.getRow(i).getCell(0)).trim());

		}
		return data;

	}

	private List<String> getRowData(String sheetName, int rowNo) {

		Sheet s = w.getSheet(sheetName);

		int cells = s.getRow(rowNo).getLastCellNum();
		data = new ArrayList<String>();
		for (int i = 0; i <= cells; i++) {
			DataFormatter format = new DataFormatter();
			data.add(format.formatCellValue(s.getRow(rowNo).getCell(i)).trim());

		}

		return data;

	}

	boolean isNewSheetCreated = false;

	private void writeUncommonData(String sheetName, List<String> rowData, int rowNo) {
		Sheet s;
		if (!isNewSheetCreated) {
			removeSheet(sheetName);
			s = w.createSheet(sheetName);
			isNewSheetCreated = true;
		}
		s = w.getSheet(sheetName);
		s.createRow(rowNo);
		for (int i = 0; i < rowData.size(); i++) {
			s.getRow(rowNo).createCell(i).setCellValue(rowData.get(i));

		}

	}

	private void removeSheet(String sheet) {
		for (int i = 0; i < w.getNumberOfSheets(); i++) {
			if (w.getSheetName(i).equals(sheet)) {
				w.removeSheetAt(i);
				break;
			}

		}
	}

	private void closeExcelConnections() throws IOException {
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}

}
