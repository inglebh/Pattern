/**
 * 
 */
package samplepkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author hp
 *
 */
public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//ReadFile.readXLSData();
		ReadFile.readTableMapping();
	}
	public static void readXLSData()
	{
		try {
			
			FileInputStream fis = new FileInputStream("F:\\Automation\\RTQRESPONSE.txt");
			BufferedReader br =new BufferedReader(new InputStreamReader(fis));
			String strline;
			
			List<Map<String,String>>maplist	= new ArrayList<Map<String,String>>();
			try {
				while((strline=br.readLine())!=null)
				{
					Map<String,String> map = new HashMap<String,String>();
					if(!strline.contains("*"))
					{
						if(strline.contains("="))
						{
							String[]spilt =strline.split("=");
							if(spilt.length>=2)
							{
								map.put(spilt[0].trim(),spilt[1].trim());
																	
							}
							else
							{
								map.put(spilt[0].trim(), " ");
							}
							maplist.add(map);
						}
						else if(strline.contains(":"))
						{
							String[] spilt1 =strline.split(":");
							
							if(spilt1.length>=2)
							{
								map.put(spilt1[0].trim(),spilt1[1].trim());
																	
							}
							else
							{
								map.put(spilt1[0].trim(), " ");
							}
							maplist.add(map);
						}
						}
					}
					for(Iterator iterator = maplist.iterator();iterator.hasNext();)
					{
						Map<String,String> map =(Map<String, String>) iterator.next();
						System.out.println(map);
					}
				
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(FileNotFoundException e)
{
	// TODO Auto-generated catch block
	System.out.println("File is Not Available....");
	e.printStackTrace();
}
// TODO Auto-generated method stub

}
	public static void keyValueMapObject()
	{
		
try {
			ReadKeyValue r1 =new ReadKeyValue();
			FileInputStream fis = new FileInputStream("F:\\Automation\\RTQRESPONSE.txt");
			BufferedReader br =new BufferedReader(new InputStreamReader(fis));
			String strline;
			
			List<Map<String,String>>maplist	= new ArrayList<Map<String,String>>();
			try {
				while((strline=br.readLine())!=null)
				{
					Map<String,String> map = new HashMap<String,String>();
					if(!strline.contains("*"))
					{
						if(strline.contains("="))
						{
							String[]spilt =strline.split("=");
							if(spilt.length>=2)
							{
								map.put(spilt[0].trim(),spilt[1].trim());
																	
							}
							else
							{
								map.put(spilt[0].trim(), " ");
							}
							maplist.add(map);
						}
						else if(strline.contains(":"))
						{
							String[] spilt1 =strline.split(":");
							
							if(spilt1.length>=2)
							{
								map.put(spilt1[0].trim(),spilt1[1].trim());
																	
							}
							else
							{
								map.put(spilt1[0].trim(), " ");
							}
							maplist.add(map);
						}
						}
					}
					for(Iterator iterator = maplist.iterator();iterator.hasNext();)
					{
						Map<String,String> map =(Map<String, String>) iterator.next();
						//System.out.println(map);
						List<ReadKeyValue> list = new ArrayList();
						//list.set(1,r1.getKey(),2,r1.getValue());
							
						
					}
				
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(FileNotFoundException e)
{
	// TODO Auto-generated catch block
	System.out.println("File is Not Available....");
	e.printStackTrace();
}
		
	}
	
public static void readTableMapping()
{
	 File file =    new File("F:\\Automation\\eclipse\\RTQ\\TableMapping.xlsx");
	 
	 String fileName="TableMapping.xlsx";
	 List<Map<String,String>>maplist	= new ArrayList<Map<String,String>>();
	 ArrayList<String> a1 = new ArrayList<String>();
     ArrayList<String> a2 = new ArrayList<String>();

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    Workbook wb = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    try {
			wb = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls"))
	    {

	        //If it is xls file then create object of XSSFWorkbook class

	    	try {
				wb = new HSSFWorkbook(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

	    //Read sheet inside the workbook by its name

	    org.apache.poi.ss.usermodel.Sheet sh1 = wb.getSheetAt(0);

	    //Find number of rows in excel file

	    int rowCount = sh1.getLastRowNum()-sh1.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) 
	    {

	        Row row = sh1.getRow(i);
	        Map<String,String> map = new HashMap<String,String>();
	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) 
	        {

	            //Print Excel data in console

	           System.out.print(row.getCell(j+1).getStringCellValue()+"|| ");
	        	a1.add(row.getCell(j).getStringCellValue());
	            
	            a2.add(row.getCell(j).getStringCellValue());

	        }

	        //System.out.println();

	    }

	    
	    System.out.println(a1.size()+"Total Rows in A1 : "+a2.size());
	   // Row row = sh1.getRow(rowno);
	    
	   // String str= row.getCell(colno).getStringCellValue();
}
}
