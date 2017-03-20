package sdv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBDatenInGui {

	private static Connection getInstance() {
		if (DBConnection.con == null)
			new DBConnection();
		return DBConnection.con;
	}
	
	/**
	 * Wandelt die Zahl 1 oder 0 aus der DB Abfrage in
	 * boolschen Wert um für die initialisierung der Radiobutton in der GUI
	 * beim Rückschreiben der Daten
	 * @param String x 
	 * @return boolscher Wert
	 */
private static boolean zahl2bool(String x){
	boolean y = false;
	if (x.equals("1")){
		 y = true;
	}
	if (x.equals("0")){
		y = false;
	}
	return y;
}
	/**
	 * Methode erstellt das Stringarray fuer die Auswahlliste im Menue Datei >
	 * Schüler auswählen
	 * 
	 * @return String[]
	 */
	
	public static String[] stringFuerAuswahlMenu() {
		String[] auswahlArray = null;
		ArrayList<String> auswahlListe = new ArrayList<String>(200);
		DBConnection.con = getInstance();
		if (DBConnection.con != null) {

			try {
				Statement komplettAuslesen = DBConnection.con.createStatement();
				String fuerAuswahlMenu = "Select uid,kname,kvorname FROM schuelerdaten WHERE term = '1' ORDER BY kname; ";
				ResultSet rs = komplettAuslesen.executeQuery(fuerAuswahlMenu);
				int rowcount = 0;
				while (rs.next()) {
					auswahlListe.add(rs.getString("uid"));
					auswahlListe.add(rs.getString("kname"));
					auswahlListe.add(rs.getString("kvorname"));
					rowcount += 1;
				}
				auswahlArray = new String[rowcount];

				int k = 0;
				for (int i = 0; i < rowcount; i++) {

					auswahlArray[i] = auswahlListe.get(k+1);
					auswahlArray[i] = auswahlArray[i].concat("_");
					auswahlArray[i] = auswahlArray[i].concat(auswahlListe.get(k+2));
					auswahlArray[i] = auswahlArray[i].concat("-");
					auswahlArray[i] = auswahlArray[i].concat(auswahlListe.get(k));
					k = k + 3;
				}

			}

			catch (SQLException se) {
				System.out.println("Fehler beim Lesen aus der DB: ");
			}

		}
		return auswahlArray;
	}

	public static void datenInGui(String auswahl){
		
		auswahl = auswahl.replaceAll("\\D+","");
		
		DBConnection.con = getInstance();
		if (DBConnection.con != null) {

			try {
				Statement zeileAuslesen = DBConnection.con.createStatement();
				String fuerGui = "SELECT * FROM schuelerdaten WHERE uid = '"+auswahl+"'; ";
				ResultSet rs = zeileAuslesen.executeQuery(fuerGui);
					rs.first();
				Main.kvorname.setText(rs.getString("kvorname"));	
				Main.kbeiname.setText(rs.getString("kbeiname"));	
				Main.kname.setText(rs.getString("kname"));	
				Main.kgeburtsort.setText(rs.getString("kgeburtsort"));	
				Main.kgeburtstag.setText(rs.getString("kgeburtstag"));	
				Main.kreligion.setText(rs.getString("kreligion"));	
				Main.kstrasse.setText(rs.getString("kstrasse"));	
				Main.kplz.setText(rs.getString("kplz"));
				Main.kwohnort.setText(rs.getString("kwohnort"));
				Main.kOT.setText(rs.getString("kOT"));	
				Main.kstaat.setText(rs.getString("kstaat"));	
				Main.kkrankenkasse.setText(rs.getString("kkrankenkasse"));	
				Main.khausarzt.setText(rs.getString("khausarzt"));
				Main.tag_ersteinschulung.setSelectedItem(rs.getString("tag_ersteinschulung"));
				Main.monat_ersteinschulung.setSelectedItem(rs.getString("monat_ersteinschulung"));
				Main.jahr_ersteinschulung.setSelectedItem(rs.getString("jahr_ersteinschulung"));
				Main.mname.setText(rs.getString("mname"));
				Main.mvorname.setText(rs.getString("mvorname"));
				Main.mstrasse.setText(rs.getString("mstrasse"));
				Main.mplz.setText(rs.getString("mplz"));
				Main.mwohnort.setText(rs.getString("mwohnort"));
				Main.mtelpriv.setText(rs.getString("mtelpriv"));
				Main.mteldienst.setText(rs.getString("mteldienst"));
				Main.memail.setText(rs.getString("memail"));
				Main.vname.setText(rs.getString("vname"));
				Main.vvorname.setText(rs.getString("vvorname"));
				Main.vstrasse.setText(rs.getString("vstrasse"));
				Main.vplz.setText(rs.getString("vplz"));
				Main.vwohnort.setText(rs.getString("vwohnort"));
				Main.vtelpriv.setText(rs.getString("vtelpriv"));
				Main.vteldienst.setText(rs.getString("vteldienst"));
				Main.vemail.setText(rs.getString("vemail"));
				Main.oname.setText(rs.getString("oname"));
				Main.ovorname.setText(rs.getString("ovorname"));
				Main.otel.setText(rs.getString("otel"));
				Main.oplz.setText(rs.getString("oplz"));
				Main.owohnort.setText(rs.getString("owohnort"));
				Main.ostrasse.setText(rs.getString("ostrasse"));
				Main.kstammschule.setText(rs.getString("kstammschule"));
				Main.geschwistername.setText(rs.getString("geschwistername"));
				Main.zugangsvoraussetzung.setSelectedItem(rs.getString("zugangsvoraussetzung"));
				Main.sorgeberechtigung.setSelectedItem(rs.getString("sorgeberechtigung"));
				Main.ausklasse.setSelectedItem(rs.getString("ausklasse"));
				Main.inklasse.setSelectedItem(rs.getString("inklasse"));
				Main.klasse.setSelectedItem(rs.getString("klasse"));
				Main.zweiteFremdsprache.setSelectedItem(rs.getString("zweiteFremdsprache"));
				Main.maennlich.setSelected(zahl2bool(rs.getString("maennlich")));
				Main.weiblich.setSelected(zahl2bool(rs.getString("weiblich")));
				Main.geschwister_ja.setSelected(zahl2bool(rs.getString("geschwister_ja")));
				Main.geschwister_nein.setSelected(zahl2bool(rs.getString("geschwister_nein")));
				Main.landkreis_ja.setSelected(zahl2bool(rs.getString("landkreis_ja")));
				Main.landkreis_nein.setSelected(zahl2bool(rs.getString("landkreis_nein")));
				Main.religion.setSelected(zahl2bool(rs.getString("religion")));
				Main.ethik.setSelected(zahl2bool(rs.getString("ethik")));
				Main.oga_ja.setSelected(zahl2bool(rs.getString("oga_ja")));
				Main.oga_nein.setSelected(zahl2bool(rs.getString("oga_nein")));
				Main.doppel_ja.setSelected(zahl2bool(rs.getString("doppel_ja")));
				Main.doppel_nein.setSelected(zahl2bool(rs.getString("doppel_nein")));
				Main.bemerkungen.setText(rs.getString("bemerkungen"));
				Main.lblNewLabel_45.setText(rs.getString("kvorname"));
				Main.lblNewLabel_46.setText(rs.getString("kname"));
				Main.lblNewLabel_47.setText(rs.getString("kOT"));
			}
			catch(SQLException ex){System.out.println("geht nich: " + ex);}
			finally
			{
				//DBUtils.safeCloseConnection(DBConnection.con);
			}
			
		
		
		}
	}
	

}
