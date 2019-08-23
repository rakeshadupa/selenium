package demo;

import java.io.File;
import java.io.FileInputStream;
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

public class ExcelOperations {

	private String filePath = "./src/databaseSheet.xlsx";
	private File f;
	private FileInputStream fis;
	private Workbook w;
	private Sheet s;
	private List<String[]> data;

	public ExcelOperations() throws EncryptedDocumentException, InvalidFormatException, IOException {

		f = new File(filePath);
		fis = new FileInputStream(f);
		w = WorkbookFactory.create(fis);

	}

	public List<String[]> getExcelData(String sheetName) {

		s = w.getSheet(sheetName);
		int rowCount = s.getLastRowNum();
		int columnCount = s.getRow(0).getLastCellNum();
		data = new ArrayList<>();
		String[] rows = null;
		for (int i = 1; i <= rowCount; i++) {
			rows = new String[columnCount];
			for (int j = 0; j < columnCount; j++) {
				DataFormatter format = new DataFormatter();
				rows[j] = format.formatCellValue(s.getRow(i).getCell(j)).trim();

			}
			data.add(rows);

		}
		return data;
	}

	boolean isNewSheetCreated = false;

	public void writeResult(String sheetName, int row, String message) throws IOException {
		if (!isNewSheetCreated) {
			removeSheet(sheetName);
			s = w.createSheet(sheetName);
			isNewSheetCreated = true;
		}

		s.createRow(row).createCell(0).setCellValue(message);

	}

	public void writeDBData(String newSheetName, List<String[]> dbData) throws IOException {

		removeSheet(newSheetName);
		s = w.createSheet(newSheetName);
		for (int i = 0; i < dbData.size(); i++) {
			s.createRow(i);
			for (int j = 0; j < dbData.get(0).length; j++) {
				s.getRow(i).createCell(j).setCellValue(dbData.get(i)[j]);

			}

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

	public void closeExcelStream() throws IOException {
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

}
