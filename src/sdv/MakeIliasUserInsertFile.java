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
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JFileChooser;



public class MakeIliasUserInsertFile extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6997991677903055706L;
	private JPanel contentPane;
	private JTextField validFrom;
	private JTextField validUntil;
	private JTextField kurs5a;
	private JTextField kurs5b;
	private JTextField kurs5c;
	private JTextField eltern5a;
	private JTextField eltern5b;
	private JTextField eltern5c;
	
	
	
	SimpleDateFormat df = new SimpleDateFormat( "dd.MM.yyyy" );
	Calendar cal = Calendar.getInstance();
	Date today = cal.getTime();
	
	
	
	
	 JFileChooser chooser = new JFileChooser();
	 FileNameExtensionFilter filter = new FileNameExtensionFilter("XML - Dateien", "xml");
	 passwordGenerator pg = new passwordGenerator();
	
	 
	private static Connection getInstance() {
		if (DBConnection.con == null)
			new DBConnection();
		return DBConnection.con;
	}
	MakeIliasUserInsertFile(){
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	setTitle("Anmeldedaten für Ilias");
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[306px][grow]", "[25px][][][][][][][][]"));
	
	JLabel lblNewLabel = new JLabel("gültig ab:");
	contentPane.add(lblNewLabel, "cell 0 1,alignx left");
	
	validFrom = new JTextField();
	contentPane.add(validFrom, "cell 1 1,growx");
	validFrom.setColumns(10);
	validFrom.setText(df.format(today));
	JLabel lblNewLabel_1 = new JLabel("gültig bis:");
	contentPane.add(lblNewLabel_1, "cell 0 3,alignx left");
	
	validUntil = new JTextField();
	contentPane.add(validUntil, "cell 1 3,growx");
	validUntil.setColumns(10);
	//validUntil.setText(df.format(abitime));
	
	JButton btnNewButton = new JButton("Datei erstellen");
	contentPane.add(btnNewButton, "cell 1 8");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		//	some code
			chooser.setFileFilter(filter);
			chooser.setSelectedFile(new File(System.getProperty("user.home").concat("/sdv/export/exportFileIliasUser.xml")));
			chooser.showSaveDialog(null);
			createFile(chooser.getSelectedFile().toString());
			
			
			
	    
		}
	});
	
	/*
	JButton btnNewButton_1 = new JButton("Serienbrief erstellen");
	contentPane.add(btnNewButton_1, "cell 1 9");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		//	some code
			chooser.setFileFilter(filter);
			chooser.setSelectedFile(new File(System.getProperty("user.home").concat("/sdv/reports/anschreiben.tex")));
			chooser.showSaveDialog(null);
			//createFile(chooser.getSelectedFile().toString());
			
	    
		}
	});*/
	}
	

	/*
	 * Erzeugt aus dem uebergebenen Vor- und Zunamen den Login fuer die xml
	 * Ilias Anmeldatei
	 */
	private String makeLoginName(String vorname, String nachname,
			Integer anzahlDurchlauf) {
		String vn = vorname.replace(" ","");
		vn = vn.replace("ä","ae");
		vn = vn.replace("ö","oe");
		vn = vn.replace("ü","ue");
		vn = vn.replace("ß","ss");
		String login = "";
		Integer i = anzahlDurchlauf;
		login = vn + "_" + nachname.substring(0, i);

		if (checkLoginNameIfDouble(login) == false)
			return login;

		else

			return makeLoginName(vorname, nachname, i + 1);

	}
	
	/*
	 * Prueft die Namenskonstrukte ob sie in der Iliasdatenbank
	 * ilias.usr_data schon vorhanden sind. Wenn ja geben sie true zurueck.
	 */
	
	private Boolean checkLoginNameIfDouble(String login) {
		Boolean LoginValid = true;
		String Login = login;
		ResultSet rs = null;
		Connection con = getInstance();
		if (con != null) {
		}
		try {
			Statement DatenFuerCheck = DBConnection.con.createStatement();
			String fuerCheckIfDouble = "SELECT * FROM ilias.usr_data WHERE login = '"
					+ Login + "' ";
			rs = DatenFuerCheck.executeQuery(fuerCheckIfDouble);
			rs.last();

		} catch (SQLException se) {
		}
		try {

			if (rs.getRow() == 0) {
				LoginValid = false;
			}
		} catch (SQLException exc) {
		}

		return LoginValid;
	}
	
	private void createFile(String filename){
		//int anzahl = 0;
		ResultSet rs = null;
		Connection con = getInstance();
		if (con != null) {
		}
		try {
			Statement DatenFuerIliasAnmeldung = DBConnection.con.createStatement();
			String fuerIlias = "SELECT * FROM schuelerdaten WHERE term = '1' AND (klasse ='5a' OR klasse ='5b' OR klasse='5c')";
			rs = DatenFuerIliasAnmeldung.executeQuery(fuerIlias);

		} catch (SQLException se) {
		}	
			try
		{
			
			FileWriter fw = new FileWriter(filename);
		    BufferedWriter bw = new BufferedWriter(fw);
		    FileWriter anschreiben = new FileWriter("/home/rft/sdv/reports/anschreiben.tex");
		    BufferedWriter brief = new BufferedWriter(anschreiben);
		    bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"); 
		    bw.write("<Users>");
		    brief.write(SerienbriefIliasAnmeldungen.texVorspann);
		   while (rs.next()){
			String Passwort_K = pg.createPassword();
			//String Passwort_M = pg.createPassword();
			String Login_K = makeLoginName(rs.getString("kvorname"), rs.getString("kname"), 1);
			//String Login_M = makeLoginName(rs.getString("mname"), rs.getString("mvorname"), 1);
			bw.write("<User Action=\"Insert\" Language=\"de\">");
		    bw.write("<Lastname>");
		    bw.write(rs.getString("kname"));
		    bw.write("</Lastname>");
		    bw.write("<Firstname>");
		    bw.write(rs.getString("kvorname"));
		    bw.write("</Firstname>");
		    bw.write("<Gender>");
		  
		    if (rs.getString("maennlich").equals("1"))
		    {
		    	bw.write("m");
		    }
		    else
		    {
		    	bw.write("f");
		    }
		    bw.write("</Gender>");
		    bw.write("<Login>");
		    bw.write(Login_K);
		    bw.write("</Login>");
		    bw.write("<Password Type=\"ILIAS3\">");
		    bw.write(MD5.getMD5(Passwort_K));
		    bw.write("</Password>");
		    bw.write("<Role Action=\"Assign\" Id=\"_1\" Type=\"Global\">");
		    bw.write("User");
		    bw.write("</Role>");
		    
		    if (rs.getString("klasse").equals("5a"))
		    {
		    	bw.write("<Role Action=\"Assign\" Id=\"_2\" Type=\"Local\">");
		    	bw.write("il_crs_member_25380");
		    }
		    if (rs.getString("klasse").equals("5b"))
		    {
		    	bw.write("<Role Action=\"Assign\" Id=\"_3\" Type=\"Local\">");
		    	bw.write("il_crs_member_25382");
		    }
		    if (rs.getString("klasse").equals("5c"))
		    {
		    	bw.write("<Role Action=\"Assign\" Id=\"_4\" Type=\"Local\">");
		    	bw.write("il_crs_member_25384");
		    }
		    
		    bw.write("</Role>");
		    bw.write("<UserDefinedField Id=\"_1\" Name=\"Klasse\">");
		    bw.write(rs.getString("klasse")+"_neu");
		    bw.write("</UserDefinedField>");
		    bw.write("<TimeLimitUnlimited>");
		    bw.write("0");
		    bw.write("</TimeLimitUnlimited>");
		    bw.write("<TimeLimitFrom>");
		    bw.write(validFrom.getText());
		    bw.write("</TimeLimitFrom>");
		    bw.write("<TimeLimitUntil>");
		    bw.write(validUntil.getText());
		    bw.write("</TimeLimitUntil>");
		    bw.write("</User>");
		    /*Zugangsdaten fuer die Eltern resp. die Mutter
		    bw.write("<User Action=\"Insert\" Language=\"de\">");
		    bw.write("<Lastname>");
		    bw.write(rs.getString("mname"));
		    bw.write("</Lastname>");
		    bw.write("<Firstname>");
		    bw.write(rs.getString("mvorname"));
		    bw.write("</Firstname>");
		    bw.write("<Gender>");
		    bw.write("f");
		    bw.write("</Gender>");
		    bw.write("<Login>");
		    bw.write(Login_M);
		    bw.write("</Login>");
		    bw.write("<Password Type=\"ILIAS3\">");
		    bw.write(MD5.getMD5(Passwort_M));
		    bw.write("</Password>");
		    bw.write("<Role Action=\"Assign\" Id=\"_1\" Type=\"Global\">");
		    bw.write("User");
		    bw.write("</Role>");
		    
		    if (rs.getString("klasse").equals("5a"))
		    {
		    	bw.write("<Role Action=\"Assign\" Id=\"_5\" Type=\"Local\">");
		    	bw.write("il_grp_member_25380");
		    }
		    if (rs.getString("klasse").equals("5b"))
		    {
		    	bw.write("<Role Action=\"Assign\" Id=\"_6\" Type=\"Local\">");
		    	bw.write("il_grp_member_25382");
		    }
		    if (rs.getString("klasse").equals("5c"))
		    {
		    	bw.write("<Role Action=\"Assign\" Id=\"_7\" Type=\"Local\">");
		    	bw.write("il_grp_member_25384");
		    }
		    bw.write("</Role>");
		    bw.write("<UserDefinedField Id=\"_1\" Name=\"Klasse\">");
		    bw.write(rs.getString("klasse")+"_Eltern");
		    bw.write("</UserDefinedField>");
		   	bw.write("<UserDefinedField Id=\"_5\" Name=\"Referenz_Kind_Login\">");
		    bw.write(Login_K);
		    bw.write("</UserDefinedField>");
		    bw.write("<TimeLimitUnlimited>");
		    bw.write("0");
		    bw.write("</TimeLimitUnlimited>");
		    bw.write("<TimeLimitFrom>");
		    bw.write(validFrom.getText());
		    bw.write("</TimeLimitFrom>");
		    bw.write("<TimeLimitUntil>");
		    bw.write(validUntil.getText());
		    bw.write("</TimeLimitUntil>");
		    bw.write("</User>");*/
		    
		    brief.write("\\textsf{\\rightline{{\\Huge von-B\\\"ulow-Gymnasium -- Neudietendorf}}\\\\[-10pt] \\rule{1.02\\linewidth}{0.5pt}}\\\\[3cm]");
		    brief.write("Fam. "+rs.getString("kname")+"\\\\");
		    brief.write(rs.getString("kplz")+" "+rs.getString("kwohnort")+"\\\\");
		    brief.write(rs.getString("kstrasse")+"\\\\[1.3cm]");
		    brief.write("\\subsection*{Liebe Familie "+rs.getString("kname")+"}");
		    brief.write(SerienbriefIliasAnmeldungen.Brieftext_1);
		    brief.write("Das Passwort des Kindes lautet: "+Passwort_K+"\\\\");
		    brief.write("Der Benutzername des Kindes lautet: "+Login_K.replace("_", "\\_")+"\\\\[.5cm] ");
		    //brief.write(SerienbriefIliasAnmeldungen.Brieftext_3+"\\\\[.5cm]");
		    //brief.write(SerienbriefIliasAnmeldungen.ElternAccount);
		    //brief.write("Das Passwort der Eltern lautet: "+Passwort_M+"\\\\");
		    //brief.write("Der Benutzername der Eltern lautet: "+Login_M.replace("_", "\\_")+"\\\\[.5cm] ");
		    brief.write(SerienbriefIliasAnmeldungen.Brieftext_3+"\\\\[.5cm]");
		    brief.write(SerienbriefIliasAnmeldungen.beiFragen);
		    brief.write(SerienbriefIliasAnmeldungen.Gruss);
		    
		    brief.write("\\newpage ");
		   }
		   
		   bw.write("</Users>");
		   
		   brief.write("\\end{document}");

 

		    bw.close();
		    brief.close();
		    
		    

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
	public JTextField getKurs5a() {
		return kurs5a;
	}
	public void setKurs5a(JTextField kurs5a) {
		this.kurs5a = kurs5a;
	}
	public JTextField getKurs5b() {
		return kurs5b;
	}
	public void setKurs5b(JTextField kurs5b) {
		this.kurs5b = kurs5b;
	}
	public JTextField getEltern5a() {
		return eltern5a;
	}
	public void setEltern5a(JTextField eltern5a) {
		this.eltern5a = eltern5a;
	}
	public JTextField getEltern5b() {
		return eltern5b;
	}
	public void setEltern5b(JTextField eltern5b) {
		this.eltern5b = eltern5b;
	}
	public JTextField getKurs5c() {
		return kurs5c;
	}
	public void setKurs5c(JTextField kurs5c) {
		this.kurs5c = kurs5c;
	}
	public JTextField getEltern5c() {
		return eltern5c;
	}
	public void setEltern5c(JTextField eltern5c) {
		this.eltern5c = eltern5c;
	}	
	
}


