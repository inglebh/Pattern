package samplepkg;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static void main(String[] args) throws Exception {
		
		File cfile=new File("C:\\Users\\hp\\Desktop\\Book1.xlsx");
		FileInputStream fis=new FileInputStream(cfile);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		String data=sheet1.getRow(1).getCell(0).getStringCellValue();
		System.out.println(data);
		wb.close();

	}

}
