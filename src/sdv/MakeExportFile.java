package sdv;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFileChooser;


public class MakeExportFile extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection getInstance() {
		if (DBConnection.con == null)
			new DBConnection();
		return DBConnection.con;
	}
	
	JFileChooser chooser = new JFileChooser();
	 FileNameExtensionFilter filter = new FileNameExtensionFilter("XML - Dateien", "xml");
	MakeExportFile(){
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	setTitle("Datenexport für PrimeLine");
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	//contentPane.setLayout(null);
	
	
	JButton datenexport = new JButton("Datei zur Datenübergabe an PrimeLine erstellen");
	contentPane.add(datenexport);
	datenexport.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		//	some code

			chooser.setFileFilter(filter);
			chooser.setSelectedFile(new File(System.getProperty("user.home").concat("/sdv/export/exportFilePrimeLine.xml")));
			chooser.showSaveDialog(null);
			createFile(chooser.getSelectedFile().toString());
		}
	});
	}
	
	private String cleanString(String x){
		String a = "";
		String b = "";
		String c = "";
		String d = "";
		String e = "";
		
		a = x.replaceAll("&", "&amp;");
		b = a.replaceAll("'", "&apos;");
		c = b.replaceAll("\"", "&quot;");
		d = c.replaceAll("<", "&lt;");
		e = d.replaceAll(">", "&gt;");
		
		return e;
	}

	private void createFile(String filename){
		//int anzahl = 0;
		ResultSet rs = null;
		Connection con = getInstance();
		if (con != null) {
		}
		try {
			Statement DatenFuerExport = DBConnection.con.createStatement();
			String fuerExport = "SELECT * FROM schuelerdaten WHERE term = '1' ";
			rs = DatenFuerExport.executeQuery(fuerExport);
			//rs.first();

		} catch (SQLException se) {
		}	
			try
		{
			
			FileWriter fw = new FileWriter(filename);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"); 
		    bw.write("<schuljahr"+Main.configData.JAHRGANG+">");
		    
		   while (rs.next()){
			bw.write("<schülerknoten>");
		    bw.write("<nachname>");
		    bw.write(rs.getString("kname"));
		    bw.write("</nachname>");
		    bw.write("<rufname>");
		    bw.write(rs.getString("kvorname"));
		    bw.write("</rufname>");
		    bw.write("<zweiterVorname>");
		    bw.write(rs.getString("kbeiname"));
		    bw.write("</zweiterVorname>");
		    bw.write("<geburtstag>");
		    bw.write(rs.getString("kgeburtstag"));
		    bw.write("</geburtstag>");
		    bw.write("<geburtsort>");
		    bw.write(rs.getString("kgeburtsort"));
		    bw.write("</geburtsort>");
		    bw.write("<religion>");
		    bw.write(rs.getString("kreligion"));
		    bw.write("</religion>");
		    bw.write("<strasse>");
		    bw.write(rs.getString("kstrasse"));
		    bw.write("</strasse>");
		    bw.write("<plz>");
		    bw.write(rs.getString("kplz"));
		    bw.write("</plz>");
		    bw.write("<wohnort>");
		    bw.write(rs.getString("kwohnort"));
		    bw.write("</wohnort>");
		    bw.write("<ortsteil>");
		    bw.write(rs.getString("kOT"));
		    bw.write("</ortsteil>");
		    bw.write("<staatsangehörigkeit>");
		    bw.write(rs.getString("kstaat"));
		    bw.write("</staatsangehörigkeit>");
		    bw.write("<krankenkasse>");
		    bw.write(rs.getString("kkrankenkasse"));
		    bw.write("</krankenkasse>");
		    bw.write("<hausarzt>");
		    bw.write(rs.getString("khausarzt"));
		    bw.write("</hausarzt>");
		    bw.write("<ersteinschulung>");
		    bw.write(rs.getString("tag_ersteinschulung")+"."+rs.getString("monat_ersteinschulung")+"."+rs.getString("jahr_ersteinschulung"));
		    bw.write("</ersteinschulung>");
		    bw.write("<geschlecht>");
		    if (rs.getString("maennlich").equals("1"))
		    {
		    	bw.write("männlich");
		    }
		    else
		    {
		    	bw.write("weiblich");
		    }
		    bw.write("</geschlecht>");
		    bw.write("<teilnahmeReEth>");
		    if (rs.getString("religion").equals("1"))
		    {
		    	bw.write("Religion");
		    }
		    else
		    {
		    	bw.write("Ethik");
		    }
		    bw.write("</teilnahmeReEth>");
		    bw.write("<AP>");
		    bw.write("<art>Mutter</art>");
		    bw.write("<name>");
		    bw.write(rs.getString("mname"));
		    bw.write("</name>");
		    bw.write("<vorname>");
		    bw.write(rs.getString("mvorname"));
		    bw.write("</vorname>");
		    bw.write("<strasse>");
		    bw.write(rs.getString("mstrasse"));
		    bw.write("</strasse>");
		    bw.write("<plz>");
		    bw.write(rs.getString("mplz"));
		    bw.write("</plz>");
		    bw.write("<wohnort>");
		    bw.write(rs.getString("mwohnort"));
		    bw.write("</wohnort>");
		    bw.write("<telefon_privat>");
		    bw.write(rs.getString("mtelpriv"));
		    bw.write("</telefon_privat>");
		    bw.write("<telefon_dienst>");
		    bw.write(rs.getString("mteldienst"));
		    bw.write("</telefon_dienst>");
		    bw.write("<email>");
		    bw.write(rs.getString("memail"));
		    bw.write("</email>");
		    bw.write("</AP>");
		    
		    bw.write("<AP>");
		    bw.write("<art>Vater</art>");
		    bw.write("<name>");
		    bw.write(rs.getString("vname"));
		    bw.write("</name>");
		    bw.write("<vorname>");
		    bw.write(rs.getString("vvorname"));
		    bw.write("</vorname>");
		    bw.write("<strasse>");
		    bw.write(rs.getString("vstrasse"));
		    bw.write("</strasse>");
		    bw.write("<plz>");
		    bw.write(rs.getString("vplz"));
		    bw.write("</plz>");
		    bw.write("<wohnort>");
		    bw.write(rs.getString("vwohnort"));
		    bw.write("</wohnort>");
		    bw.write("<telefon_privat>");
		    bw.write(rs.getString("vtelpriv"));
		    bw.write("</telefon_privat>");
		    bw.write("<telefon_dienst>");
		    bw.write(rs.getString("vteldienst"));
		    bw.write("</telefon_dienst>");
		    bw.write("<email>");
		    bw.write(rs.getString("vemail"));
		    bw.write("</email>");
		    bw.write("</AP>");
		    
		    bw.write("<AP>");
		    bw.write("<art>Vertrauensperson</art>");
		    bw.write("<name>");
		    bw.write(rs.getString("oname"));
		    bw.write("</name>");
		    bw.write("<vorname>");
		    bw.write(cleanString((rs.getString("ovorname"))));
		    bw.write("</vorname>");
		    bw.write("<strasse>");
		    bw.write(rs.getString("ostrasse"));
		    bw.write("</strasse>");
		    bw.write("<plz>");
		    bw.write(rs.getString("oplz"));
		    bw.write("</plz>");
		    bw.write("<wohnort>");
		    bw.write(rs.getString("owohnort"));
		    bw.write("</wohnort>");
		    bw.write("<telefon>");
		    bw.write(rs.getString("otel"));
		    bw.write("</telefon>");
		    bw.write("</AP>");
		    
		    bw.write("</schülerknoten>");
		    
		   }
		   
		    bw.write("</schuljahr"+Main.configData.JAHRGANG+">");

 

		    bw.close();

		}
		catch	(IOException ex)
		{
			ex.printStackTrace();

		}
		catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
	}
}
