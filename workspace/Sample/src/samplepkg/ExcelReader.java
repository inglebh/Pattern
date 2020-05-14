package samplepkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{

	public static void main(String[] args)
	{
		
	}
    public static HashMap loadExcelLines(File fileName)
    {
        // Used the LinkedHashMap and LikedList to maintain the order
    	List<Map<String,String>>maplist	= new ArrayList<Map<String,String>>();

        
        String sheetName = null;
        // Create an ArrayList to store the data read from excel sheet.
        // List sheetData = new ArrayList();
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fileName);
            // Create an excel workbook from the file system
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            // Get the first sheet on the workbook.
           
                XSSFSheet sheet = workBook.getSheetAt(0);
                // XSSFSheet sheet = workBook.getSheetAt(0);
                //sheetName = workBook.getSheetName(i);
                ArrayList<String> a1 = new ArrayList<String>();
                ArrayList<String> a2 = new ArrayList<String>();
                
                Iterator rows = sheet.rowIterator();
                while (rows.hasNext())
                {
                    XSSFRow row = (XSSFRow) rows.next();
                    Iterator cells = row.cellIterator();

                	Map<String,String> map = new HashMap<String,String>();
                    while (cells.hasNext())
                    {
                        XSSFCell cell = (XSSFCell) cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        a1.add(cell.getStringCellValue());
                    }
                    hashMap.put(row.getRowNum(), data);

                    // sheetData.add(data);
                }
                outerMap.put(sheetName, hashMap);
                hashMap = new LinkedHashMap<Integer, List>();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return outerMap;

    }
}
