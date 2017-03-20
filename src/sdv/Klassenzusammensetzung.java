
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
	static JLabel lblgesamt5a_wert = new JLabel("-");
	static JLabel lblgesamt5b_wert = new JLabel("-");
	static JLabel lblgesamt5c_wert = new JLabel("-");
	static JLabel lblKlasseAM_wert = new JLabel("-");
	static JLabel lblKlasseAW_wert = new JLabel("-");
	static JLabel lblKlasseBM_wert = new JLabel("-");
	static JLabel lblKlasseBW_wert = new JLabel("-");
	static JLabel lblKlasseCM_wert = new JLabel("-");
	static JLabel lblKlasseCW_wert = new JLabel("-");
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
		frame.setBounds(200, 200, 450, 180);
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
		panel5c.setBackground(Color.cyan);

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
		
				lblgesamt5a_wert.setText(schuelerzahl("5a", "","1"));
				lblgesamt5b_wert.setText(schuelerzahl("5b", "","1"));
				lblgesamt5c_wert.setText(schuelerzahl("5c", "","1"));
				lblKlasseAM_wert.setText(schuelerzahl("5a", "1","1"));
				lblKlasseAW_wert.setText(schuelerzahl("5a", "0","1"));
				lblKlasseBM_wert.setText(schuelerzahl("5b", "1","1"));
				lblKlasseBW_wert.setText(schuelerzahl("5b", "0","1"));
				lblKlasseCM_wert.setText(schuelerzahl("5c", "1","1"));
				lblKlasseCW_wert.setText(schuelerzahl("5c", "0","1"));
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

	static String schuelerzahl(String klasse, String geschlecht, String term) {
		ResultSet rs = null;
		String abfrage = "";
		Connection con = getInstance();
		if (con != null) {
		}
		try {
			Statement anzahlDerSchueler = DBConnection.con.createStatement();
			
			if (geschlecht == "")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"' AND term = '1' ";
			}
			if (geschlecht == "0")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"' AND term = '1' AND maennlich = '0' ";
			}
			if (geschlecht == "1")
			{
			abfrage = "SELECT * FROM schuelerdaten WHERE klasse = '"+klasse+"' AND term = '1' AND maennlich = '1' ";
			}
			rs = anzahlDerSchueler.executeQuery(abfrage);
		
			} catch (SQLException se) 
				{
				}	
			int anzahl = 0;
			
		    try {
		        rs.last();
		        anzahl = rs.getRow();
		        rs.beforeFirst();
		    } 
		    catch(Exception ex)  {
		    }
		      
		    
		      
			
			
			
			

		
		String ausgabe = Integer.toString(anzahl);

		return ausgabe;
	}
}
