
package sdv;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.*;
public class Klassenzusammensetzung extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private static final String akt_term = Main.configData.AKTUELLER_TERM;

	private static Connection getInstance() {
		if (DBConnection.con == null)
			new DBConnection();
		return DBConnection.con;
	}

	static JPanel contentPane = new JPanel();
	static JLabel lblKlasse5a = new JLabel("5 a");
	static JLabel lblKlasse5b = new JLabel("5 b");
	static JLabel lblKlasse5c = new JLabel("5 c");
	static JLabel lblKlasseAM = new JLabel("Jungen");
	static JLabel lblKlasseAW = new JLabel("Mädchen");
	static JLabel lblKlasseBM = new JLabel("Jungen");
	static JLabel lblKlasseBW = new JLabel("Mädchen");
	static JLabel lblKlasseCM = new JLabel("Jungen");
	static JLabel lblKlasseCW = new JLabel("Mädchen");
	static JLabel lblgesamta = new JLabel("gesamt");
	static JLabel lblgesamtb = new JLabel("gesamt");
	static JLabel lblgesamtc = new JLabel("gesamt");
	static JLabel lblgesamtFrz = new JLabel("Französisch");
	static JLabel lblgesamtLat = new JLabel("Latein");
	static JLabel lblgesamtevRel = new JLabel("ev. Religion");
	static JLabel lblgesamtkathRel = new JLabel("kath. Religion");
	static JLabel lblgesamtEth = new JLabel("Ethik");
	static JLabel lblgesamt5a_wert = new JLabel("-");
	static JLabel lblgesamt5b_wert = new JLabel("-");
	static JLabel lblgesamt5c_wert = new JLabel("-");
	static JLabel lblKlasseAM_wert = new JLabel("-");
	static JLabel lblKlasseAW_wert = new JLabel("-");
	static JLabel lblKlasseBM_wert = new JLabel("-");
	static JLabel lblKlasseBW_wert = new JLabel("-");
	static JLabel lblKlasseCM_wert = new JLabel("-");
	static JLabel lblKlasseCW_wert = new JLabel("-");
	static JLabel lblgesamtFrz_wert = new JLabel("-");
	static JLabel lblgesamtLat_wert = new JLabel("-");
	static JLabel lblgesamtevRel_wert = new JLabel("-");
	static JLabel lblgesamtkathRel_wert = new JLabel("-");
	static JLabel lblgesamtEth_wert = new JLabel("-");
	static JLabel lblKlasseCFrz = new JLabel("Frz.");
	static JLabel lblKlasseCFrz_wert = new JLabel("-");
	static JLabel lblKlasseCLat = new JLabel("Lat.");
	static JLabel lblKlasseCLat_wert = new JLabel("-");
	static JLabel lblKlasseCevRel = new JLabel("ev. Rel.");
	static JLabel lblKlasseCevRel_wert = new JLabel("-");
	static JLabel lblKlasseCkathRel = new JLabel("kath. Rel.");
	static JLabel lblKlasseCkathRel_wert = new JLabel("-");
	static JLabel lblKlasseCEth = new JLabel("Ethik");
	static JLabel lblKlasseCEth_wert = new JLabel("-");
	static JLabel lblKlasseBFrz = new JLabel("Frz.");
	static JLabel lblKlasseBFrz_wert = new JLabel("-");
	static JLabel lblKlasseBLat = new JLabel("Lat.");
	static JLabel lblKlasseBLat_wert = new JLabel("-");
	static JLabel lblKlasseBevRel = new JLabel("ev. Rel.");
	static JLabel lblKlasseBevRel_wert = new JLabel("-");
	static JLabel lblKlasseBkathRel = new JLabel("kath. Rel.");
	static JLabel lblKlasseBkathRel_wert = new JLabel("-");
	static JLabel lblKlasseBEth = new JLabel("Ethik");
	static JLabel lblKlasseBEth_wert = new JLabel("-");
	static JLabel lblKlasseAFrz = new JLabel("Frz.");
	static JLabel lblKlasseAFrz_wert = new JLabel("-");
	static JLabel lblKlasseALat = new JLabel("Lat.");
	static JLabel lblKlasseALat_wert = new JLabel("-");
	static JLabel lblKlasseAevRel = new JLabel("ev. Rel.");
	static JLabel lblKlasseAevRel_wert = new JLabel("-");
	static JLabel lblKlasseAkathRel = new JLabel("kath. Rel.");
	static JLabel lblKlasseAkathRel_wert = new JLabel("-");
	static JLabel lblKlasseAEth = new JLabel("Ethik");
	static JLabel lblKlasseAEth_wert = new JLabel("-");
	//static JButton aktButton = new JButton("Aktualisieren");

	/**
	 * Create the frame.
	 */
	public Klassenzusammensetzung() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	}

	public void klassenzusammensetzung() {

		JFrame frame = new JFrame("Klassenzusammensetzung");
		frame.setBounds(200, 200, 550, 280);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);

		frame.getContentPane().setLayout(new MigLayout());
		JPanel panel5a = new JPanel();
		panel5a.setBorder(new TitledBorder(null, "5a", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel5a.setLayout(new MigLayout());
		frame.getContentPane().add(panel5a);
		panel5a.add(lblgesamta);
		panel5a.add(lblgesamt5a_wert, "wrap");
		panel5a.add(lblKlasseAM);
		panel5a.add(lblKlasseAM_wert, "wrap");
		panel5a.add(lblKlasseAW);
		panel5a.add(lblKlasseAW_wert, "wrap");
		panel5a.add(lblKlasseAFrz);
		panel5a.add(lblKlasseAFrz_wert, "wrap");
		panel5a.add(lblKlasseALat);
		panel5a.add(lblKlasseALat_wert, "wrap");
		panel5a.add(lblKlasseAevRel);
		panel5a.add(lblKlasseAevRel_wert, "wrap");
		//panel5a.add(lblKlasseAkathRel);
		//panel5a.add(lblKlasseAkathRel_wert, "wrap");
		panel5a.add(lblKlasseAEth);
		panel5a.add(lblKlasseAEth_wert, "wrap");
		panel5a.setBackground(Color.yellow);

		JPanel panel5b = new JPanel();
		panel5b.setBorder(new TitledBorder(null, "5b", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel5b.setLayout(new MigLayout());
		frame.getContentPane().add(panel5b);
		panel5b.add(lblgesamtb);
		panel5b.add(lblgesamt5b_wert, "wrap");
		panel5b.add(lblKlasseBM);
		panel5b.add(lblKlasseBM_wert, "wrap");
		panel5b.add(lblKlasseBW);
		panel5b.add(lblKlasseBW_wert, "wrap");
		panel5b.add(lblKlasseBFrz);
		panel5b.add(lblKlasseBFrz_wert, "wrap");
		panel5b.add(lblKlasseBLat);
		panel5b.add(lblKlasseBLat_wert, "wrap");
		panel5b.add(lblKlasseBevRel);
		panel5b.add(lblKlasseBevRel_wert, "wrap");
		//panel5b.add(lblKlasseBkathRel);
		//panel5b.add(lblKlasseBkathRel_wert, "wrap");
		panel5b.add(lblKlasseBEth);
		panel5b.add(lblKlasseBEth_wert, "wrap");
		panel5b.setBackground(Color.green);
		
		JPanel panel5c = new JPanel();
		panel5c.setBorder(new TitledBorder(null, "5c", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel5c.setLayout(new MigLayout());
		frame.getContentPane().add(panel5c);
		panel5c.add(lblgesamtc);
		panel5c.add(lblgesamt5c_wert, "wrap");
		panel5c.add(lblKlasseCM);
		panel5c.add(lblKlasseCM_wert, "wrap");
		panel5c.add(lblKlasseCW);
		panel5c.add(lblKlasseCW_wert, "wrap");
		panel5c.add(lblKlasseCFrz);
		panel5c.add(lblKlasseCFrz_wert, "wrap");
		panel5c.add(lblKlasseCLat);
		panel5c.add(lblKlasseCLat_wert, "wrap");
		panel5c.add(lblKlasseCevRel);
		panel5c.add(lblKlasseCevRel_wert, "wrap");
		//panel5c.add(lblKlasseCkathRel);
		//panel5c.add(lblKlasseCkathRel_wert, "wrap");
		panel5c.add(lblKlasseCEth);
		panel5c.add(lblKlasseCEth_wert, "wrap");
		panel5c.setBackground(Color.cyan);
		
		JPanel panelsprachen_reli = new JPanel();
		panelsprachen_reli.setBorder(new TitledBorder(null, "Diverses", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelsprachen_reli.setLayout(new MigLayout());
		frame.getContentPane().add(panelsprachen_reli);
		panelsprachen_reli.add(lblgesamtFrz);
		panelsprachen_reli.add(lblgesamtFrz_wert, "wrap");
		panelsprachen_reli.add(lblgesamtLat);
		panelsprachen_reli.add(lblgesamtLat_wert, "wrap");
		panelsprachen_reli.add(lblgesamtevRel);
		panelsprachen_reli.add(lblgesamtevRel_wert, "wrap");
		//panelsprachen_reli.add(lblgesamtkathRel);
		//panelsprachen_reli.add(lblgesamtkathRel_wert, "wrap");
		panelsprachen_reli.add(lblgesamtEth);
		panelsprachen_reli.add(lblgesamtEth_wert, "wrap");
		panelsprachen_reli.setBackground(Color.white);

/**
 * 
 * AktualisiereKlassenzusammensetzung startet in einem seperaten Thread 
 * regelmaessig aller 1000 ms die Anzeige im Statistikframe
 *
 */
		

		final class AktualisiereKlassenzusammensetzung implements Runnable
		{
		  @Override public void run()
		  {  
		while(true)
			{
				try
					{
						Thread.sleep(1000);
						
					}catch(Exception e){};
		
				lblgesamt5a_wert.setText(schuelerzahl("5a", "","","",akt_term));
				lblgesamt5b_wert.setText(schuelerzahl("5b", "","","",akt_term));
				lblgesamt5c_wert.setText(schuelerzahl("5c", "","","",akt_term));
				lblKlasseAM_wert.setText(schuelerzahl("5a", "1","","",akt_term));
				lblKlasseAW_wert.setText(schuelerzahl("5a", "0","","",akt_term));
				lblKlasseBM_wert.setText(schuelerzahl("5b", "1","","",akt_term));
				lblKlasseBW_wert.setText(schuelerzahl("5b", "0","","",akt_term));
				lblKlasseCM_wert.setText(schuelerzahl("5c", "1","","",akt_term));
				lblKlasseCW_wert.setText(schuelerzahl("5c", "0","","",akt_term));
				lblgesamtEth_wert.setText(schuelerzahl("","","0","",akt_term));
				lblgesamtevRel_wert.setText(schuelerzahl("","","1","",akt_term));
				lblgesamtFrz_wert.setText(schuelerzahl("","","","Französisch",akt_term));
				lblgesamtLat_wert.setText(schuelerzahl("","","","Latein",akt_term));
				lblKlasseAEth_wert.setText(schuelerzahl("5a","","0","",akt_term));
				lblKlasseAevRel_wert.setText(schuelerzahl("5a","","1","",akt_term));
				lblKlasseAFrz_wert.setText(schuelerzahl("5a","","","Französisch",akt_term));
				lblKlasseALat_wert.setText(schuelerzahl("5a","","","Latein",akt_term));
				lblKlasseBEth_wert.setText(schuelerzahl("5b","","0","",akt_term));
				lblKlasseBevRel_wert.setText(schuelerzahl("5b","","1","",akt_term));
				lblKlasseBFrz_wert.setText(schuelerzahl("5b","","","Französisch",akt_term));
				lblKlasseBLat_wert.setText(schuelerzahl("5b","","","Latein",akt_term));
				lblKlasseCEth_wert.setText(schuelerzahl("5c","","0","",akt_term));
				lblKlasseCevRel_wert.setText(schuelerzahl("5c","","1","",akt_term));
				lblKlasseCFrz_wert.setText(schuelerzahl("5c","","","Französisch",akt_term));
				lblKlasseCLat_wert.setText(schuelerzahl("5c","","","Latein",akt_term));
					}
		  	}
		}
		
Thread t1 = new Thread(new AktualisiereKlassenzusammensetzung());
t1.start();

	}
	
	/*
	 * Ermittlung der Schueler fuer die Klassenlisten es gelten zwei
	 * Suchkriterien
	 */

	static String schuelerzahl(String klasse, String geschlecht,String religion, String zweiteFremdsprache, String term) {
		ResultSet rs = null;
		String abfrage = "";
		//Connection con = getInstance();
		//if (con != null) {
		//}
		if (DBConnection.con == null) {
			getInstance();
		}else {}
		try {
			
			Statement anzahlDerSchueler = DBConnection.con.createStatement();
			
			if (geschlecht == "")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"' AND term = '"+akt_term+"' ";
			//System.out.println("1");
			}
			if (geschlecht == "0")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"' AND term = '"+akt_term+"' AND maennlich = '0' ";
			//System.out.println("2");
			}
			if (geschlecht == "1")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"' AND term = '"+akt_term+"' AND maennlich = '1' ";
			//System.out.println("3");
			}
			if (religion == "0")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE inklasse = '5' AND religion = '0' AND term = '"+akt_term+"'";
			//System.out.println("4");
			}
			if (religion == "1")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE inklasse = '5' AND religion = '1' AND term = '"+akt_term+"'";
			//System.out.println("5");
			}
			if (zweiteFremdsprache == "Französisch")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE inklasse = '5' AND zweiteFremdsprache = 'Französisch' AND term = '"+akt_term+"'";
			//System.out.println("6");
			}
			if (zweiteFremdsprache == "Latein")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE inklasse = '5' AND zweiteFremdsprache = 'Latein' AND term = '"+akt_term+"'";
			//System.out.println("7");
			}
			if (religion == "0" && klasse != "")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"'  AND religion = '0' AND term = '"+akt_term+"'";
			//System.out.println("8");
			}
			if (religion == "1" && klasse != "")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"' AND religion = '1' AND term = '"+akt_term+"'";
			//System.out.println("9");
			}
			if (zweiteFremdsprache == "Französisch" && klasse != "")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"' AND zweiteFremdsprache = 'Französisch' AND term = '"+akt_term+"'";
			//System.out.println("10");
			}
			if (zweiteFremdsprache == "Latein" && klasse != "")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"' AND zweiteFremdsprache = 'Latein' AND term = '"+akt_term+"'";
			//System.out.println("11");
			}
			rs = anzahlDerSchueler.executeQuery(abfrage);
		}
		
		catch (SQLException se) 
				{
				}
		
			int anzahl = 0;
			
		    try {
		        rs.last();
		        anzahl = rs.getRow();
		        rs.beforeFirst();
		        rs.close();
		      
		        
		    } 
		    catch(Exception ex)  {
		    }
		      

		
		String ausgabe = Integer.toString(anzahl);

		return ausgabe;
	}
}
