import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Dataexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        File file = new File("C:\\Users\\Peter\\Desktop\\Data.xlsx");
        
        FileInputStream inputStream = new FileInputStream(file);
        
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        
        XSSFSheet sheet = wb.getSheet("Sheet1");
        
        XSSFRow row2 = sheet.getRow(1);
        
        XSSFCell cell = row2.getCell(5);
        
        String address = cell.getStringCellValue();
        
        System.out.println("Here is the address " + address);
    }

}
