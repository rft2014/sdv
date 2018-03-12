package sdv;


import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;
//import java.util.Set;

//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Sample Java program to read and write Excel file in Java using Apache POI
 *
 */
public class makeXLSX {
	
	private static Connection getInstance() {
		if (DBConnection.con == null)
			new DBConnection();
		return DBConnection.con;
	}

	public static void writeXLSXFile(String ausklasse,String inklasse, String filename)//für Schüler mit Probeunterricht
	{
		Connection con = getInstance();
		if (con != null) {
		}
		try {
			Statement listeSA = DBConnection.con.createStatement();
			String fuerXSLXListeSA = "Select * FROM schuelerdaten WHERE ausklasse = '"
					+ ausklasse + "' AND  inklasse = '"+ inklasse +"' AND zugangsvoraussetzung = 'Probeunterricht' AND term = '1' ORDER BY kname; ";
			ResultSet rs = listeSA.executeQuery(fuerXSLXListeSA);	

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet arbeitsblatt = workbook.createSheet("Aufnahmeprüfung_Gym_50237");
	Map<String, CellStyle> styles = createStyles(workbook);
	
	arbeitsblatt.setDisplayGridlines(false);
	
    XSSFRow headerRow = arbeitsblatt.createRow(0);
    headerRow.setHeightInPoints(30);
    XSSFCell titleCell = headerRow.createCell(0);
    titleCell.setCellValue("Anmeldung zur Aufnahmeprüfung ans Gymnasium "+Main.configData.JAHRGANG);
    titleCell.setCellStyle(styles.get("title"));
    
    XSSFRow subHeaderRow = arbeitsblatt.createRow(1);
    subHeaderRow.setHeightInPoints(14);
    XSSFCell subtitleCell = subHeaderRow.createCell(0);
    subtitleCell.setCellValue("§7 Abs.2 ThürSchulG i.V.m. §125 ThürSchulO");
    subtitleCell.setCellStyle(styles.get("subtitle"));
    
    XSSFRow schoolNameRow = arbeitsblatt.createRow(2);
    schoolNameRow.setHeightInPoints(30);
    XSSFCell schoolNameCell = schoolNameRow.createCell(0);
    schoolNameCell.setCellValue("von-Bülow-Gymnasium, Neudietendorf");
    schoolNameCell.setCellStyle(styles.get("title"));
    
    XSSFCell schoolNumberCell = schoolNameRow.createCell(6);
    schoolNumberCell.setCellValue("Schulnr.: 50237");
    schoolNumberCell.setCellStyle(styles.get("title"));
    
    XSSFRow subsubHeaderRow = arbeitsblatt.createRow(3);
    subsubHeaderRow.setHeightInPoints(16);
    XSSFCell subsubtitleCell = subsubHeaderRow.createCell(0);
    subsubtitleCell.setCellValue("Übergang Klasse "+ausklasse+" nach Klasse "+inklasse);
    subsubtitleCell.setCellStyle(styles.get("subtitle"));
    
   
    
    arbeitsblatt.setColumnWidth(0, 256*3);
 /*   arbeitsblatt.setColumnWidth(1, 256*8);
    arbeitsblatt.setColumnWidth(2, 256*8);
    arbeitsblatt.setColumnWidth(3, 256*4);
    arbeitsblatt.setColumnWidth(4, 256*10);
    arbeitsblatt.setColumnWidth(5, 256*20);
    arbeitsblatt.setColumnWidth(6, 256*8);
    arbeitsblatt.setColumnWidth(7, 256*20);
    arbeitsblatt.setColumnWidth(8, 256*20);
    arbeitsblatt.setColumnWidth(9, 256*20);
    arbeitsblatt.setColumnWidth(10, 256*16);
    arbeitsblatt.setColumnWidth(11, 256*6);*/
    XSSFRow tableHeaderRow = arbeitsblatt.createRow(5);
    tableHeaderRow.setHeightInPoints(36);
    XSSFCell tableHeaderCell_0 = tableHeaderRow.createCell(0);
    XSSFCell tableHeaderCell_1 = tableHeaderRow.createCell(1);
    XSSFCell tableHeaderCell_2 = tableHeaderRow.createCell(2);
    XSSFCell tableHeaderCell_3 = tableHeaderRow.createCell(3);
    XSSFCell tableHeaderCell_4 = tableHeaderRow.createCell(4);
    XSSFCell tableHeaderCell_5 = tableHeaderRow.createCell(5);
    XSSFCell tableHeaderCell_6 = tableHeaderRow.createCell(6);
    XSSFCell tableHeaderCell_7 = tableHeaderRow.createCell(7);
    XSSFCell tableHeaderCell_8 = tableHeaderRow.createCell(8);
    XSSFCell tableHeaderCell_9 = tableHeaderRow.createCell(9);
    XSSFCell tableHeaderCell_10 = tableHeaderRow.createCell(10);
    XSSFCell tableHeaderCell_11 = tableHeaderRow.createCell(11); 
    
    tableHeaderCell_0.setCellValue("Nr");
    tableHeaderCell_0.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_1.setCellValue("Kind\n Vorname");
    tableHeaderCell_1.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_2.setCellValue("Kind\n Nachname");
    tableHeaderCell_2.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_3.setCellValue("m/w");
    tableHeaderCell_3.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_4.setCellValue("geb.");
    tableHeaderCell_4.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_5.setCellValue("Stammschule");
    tableHeaderCell_5.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_6.setCellValue("prüfendes\n Gymnasium");
    tableHeaderCell_6.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_7.setCellValue("Mutter\n Name, Anschrift");
    tableHeaderCell_7.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_8.setCellValue("Vater\n Name, Anschrift");
    tableHeaderCell_8.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_9.setCellValue("Kind\n Anschrift");
    tableHeaderCell_9.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_10.setCellValue("Telefon");
    tableHeaderCell_10.setCellStyle(styles.get("tableheader"));
    
    tableHeaderCell_11.setCellValue("Wunschort für\n Aufnahmeprüfung");
    tableHeaderCell_11.setCellStyle(styles.get("tableheader"));
    
    int lfdNr = 0;
	while (rs.next()){
		String gender = "";
		if(rs.getString("maennlich").equals("1")){gender = "m";}
		if(rs.getString("weiblich").equals("1")){gender = "w";}	
	lfdNr += 1;	
	XSSFRow tableContentRow = arbeitsblatt.createRow(lfdNr + 5);
    tableContentRow.setHeightInPoints(46);
	
    XSSFCell tableContentCell_0 = tableContentRow.createCell(0);
    XSSFCell tableContentCell_1 = tableContentRow.createCell(1);
    XSSFCell tableContentCell_2 = tableContentRow.createCell(2);
    XSSFCell tableContentCell_3 = tableContentRow.createCell(3);
    XSSFCell tableContentCell_4 = tableContentRow.createCell(4);
    XSSFCell tableContentCell_5 = tableContentRow.createCell(5);
    XSSFCell tableContentCell_6 = tableContentRow.createCell(6);
    XSSFCell tableContentCell_7 = tableContentRow.createCell(7);
    XSSFCell tableContentCell_8 = tableContentRow.createCell(8);
    XSSFCell tableContentCell_9 = tableContentRow.createCell(9);
    XSSFCell tableContentCell_10 = tableContentRow.createCell(10);
    XSSFCell tableContentCell_11 = tableContentRow.createCell(11); 
    
    tableContentCell_0.setCellValue(Integer.toString(lfdNr));
    tableContentCell_0.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_1.setCellValue(rs.getString("kvorname"));
    tableContentCell_1.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_2.setCellValue(rs.getString("kname"));
    tableContentCell_2.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_3.setCellValue(gender);
    tableContentCell_3.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_4.setCellValue(rs.getString("kgeburtstag"));
    tableContentCell_4.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_5.setCellValue(rs.getString("kstammschule"));
    tableContentCell_5.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_6.setCellValue("Ernestinum");
    tableContentCell_6.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_7.setCellValue(rs.getString("mname")+", "+
    								rs.getString("mvorname") +"\n"+
    								rs.getString("mplz")+" "+
    								rs.getString("mwohnort")+"\n"+
    								rs.getString("mstrasse"));
    tableContentCell_7.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_8.setCellValue(rs.getString("vname")+", "+
									rs.getString("vvorname") +"\n"+
									rs.getString("vplz")+" "+
									rs.getString("vwohnort")+"\n"+
									rs.getString("vstrasse"));
    tableContentCell_8.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_9.setCellValue(rs.getString("kplz")+" "+
									rs.getString("kwohnort")+"\n"+
									rs.getString("kstrasse"));
    tableContentCell_9.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_10.setCellValue("Mutter: "+rs.getString("mtelpriv")+"\n"+
    								"Vater: "+rs.getString("vtelpriv"));
    tableContentCell_10.setCellStyle(styles.get("tablecontent"));
    
    tableContentCell_11.setCellValue("ohne");
    tableContentCell_11.setCellStyle(styles.get("tablecontent"));
    
	}
	//arbeitsblatt.autoSizeColumn(0);
	arbeitsblatt.autoSizeColumn(1);
	arbeitsblatt.autoSizeColumn(2);
	arbeitsblatt.autoSizeColumn(3);
	arbeitsblatt.autoSizeColumn(4);
	arbeitsblatt.autoSizeColumn(5);
	arbeitsblatt.autoSizeColumn(6);
	arbeitsblatt.autoSizeColumn(7);
	arbeitsblatt.autoSizeColumn(8);
	arbeitsblatt.autoSizeColumn(9);
	arbeitsblatt.autoSizeColumn(10);
	arbeitsblatt.autoSizeColumn(11);
	
    	FileOutputStream out = 
    		new FileOutputStream(new File(filename),false);//false überschreibt alte datei
    
    	workbook.write(out);
    	out.close();
    	workbook.close();
    	System.out.println("Datei erfolgreich geschrieben");
    } catch (FileNotFoundException e){
    	e.printStackTrace();
    } catch (IOException eio) {
    	eio.printStackTrace();
    } catch(SQLException sqe){
    	sqe.printStackTrace();
    }
}
	

//public static void main(String[] args) throws IOException
//{
//	writeXLSXFile("4","5");
//}

private static Map<String, CellStyle>createStyles(XSSFWorkbook workbook)
{
	Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
	
	CellStyle style;
	Font titleFont = workbook.createFont();
	titleFont.setFontHeightInPoints((short)36);
	style = workbook.createCellStyle();
	style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	style.setFont(titleFont);
	styles.put("title",style);
	
	Font subtitleFont = workbook.createFont();
	titleFont.setFontHeightInPoints((short)14);
	style = workbook.createCellStyle();
	style.setFont(subtitleFont);
	styles.put("subtitle",style);
	
	Font tableHeaderFont = workbook.createFont();
	tableHeaderFont.setFontHeightInPoints((short)9);
	style = workbook.createCellStyle();
	style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	style.setAlignment(CellStyle.ALIGN_CENTER);
	style.setBorderBottom(CellStyle.BORDER_THIN);
	style.setBorderLeft(CellStyle.BORDER_THIN);
	style.setBorderRight(CellStyle.BORDER_THIN);
	style.setBorderTop(CellStyle.BORDER_THIN);
	//style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	//style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	style.setWrapText(true);
	style.setFont(tableHeaderFont);
	styles.put("tableheader",style);
	
	Font tableContentFont = workbook.createFont();
	tableContentFont.setFontHeightInPoints((short)8);
	style = workbook.createCellStyle();
	style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	style.setAlignment(CellStyle.ALIGN_CENTER);
	style.setBorderBottom(CellStyle.BORDER_THIN);
	style.setBorderLeft(CellStyle.BORDER_THIN);
	style.setBorderRight(CellStyle.BORDER_THIN);
	style.setBorderTop(CellStyle.BORDER_THIN);
	style.setWrapText(true);
	styles.put("tablecontent", style);
	
	return styles;
}
}



