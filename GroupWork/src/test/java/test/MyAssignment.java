package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAssignment {
	public static WebDriver driver;
	public static Properties prop;
	public static String sAppURL;
	public static String city;
	public static String movie;
	public static String details;


	
	//This function is used to read data from specified cell of Excel sheet once you give Excelsheet name and path
	
	public static String BookMyShow_readXL (int row, String column, String strFilePath) throws IOException 
	{
		
		File file =    new File("D:\\JavaWorkspace\\GroupAssignment\\BookMyShow.xls");
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook(inputStream);
		HSSFSheet sheet=wb.getSheet("city");
		@SuppressWarnings("unused")
		HSSFRow row1=sheet.getRow(1);	
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        System.out.println(rowCount);
        //iterate over all the row to print the data present in each cell.
        for(int i=0;i<=rowCount;i++){
            
            //get cell count in a row
            int cellcount=sheet.getRow(i).getLastCellNum();
            System.out.println(cellcount);
            //iterate over each cell to print its value
            System.out.println("Row"+ i+" data is :");
            
            for(int j=0;j<cellcount;j++){
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
            }
            System.out.println();
        }
    
	//System.out.println("NO MATCH FOUND IN GIVEN FILE: PROBLEM IS COMING FROM DATA FILE");
	
	return null;
	}

public static void main(String[] args) throws FileNotFoundException, IOException {
// TODO Auto-generated method stub
try {
	prop = new Properties();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
  prop.load(new FileInputStream("C:\\Users\\swati purohit\\java developer1\\GroupWork\\Configuration\\BO_MyShow.properties"));
  sAppURL = prop.getProperty("sAppURL");
  city= prop.getProperty("city");
  movie = prop.getProperty("movie");
  System.out.println(sAppURL);
  System.out.println(city);
  System.out.println(movie);
System.setProperty("webdriver.chrome.driver","F:\\Driver\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();
driver.get(sAppURL);
driver.manage().window().maximize();
driver.findElement(By.cssSelector("#modal-root > div > div > div > div:nth-child(2) > ul > li:nth-child(1) > div > div > img")).sendKeys(city);
driver.findElement(By.cssSelector("#super-container > div.sc-b1h692-2.bjlzfS > div.sc-133848s-2.sc-b1h692-4.gHrdsr > div.sc-b1h692-8.jfArFP > div:nth-child(2) > div > div > div > div.sc-lnhrs7-0.bKwTw > div > div.sc-lnhrs7-2.eQezya > div:nth-child(1) > a > div > div.sc-133848s-2.sc-1t5vwh0-0.jlNtkC > div > img")).sendKeys(movie);
BookMyShow_readXL(1,"city","C:\\Users\\swati purohit\\java developer1\\GroupWork\\BookMyShow.xls");


}

}
