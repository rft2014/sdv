package sdv;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class GuiDatenInDB {
	// public static DBConnection dbc = new DBConnection();

	public GuiDatenInDB() {

	}

	private static Connection getInstance() {
		if (DBConnection.con == null)
			new DBConnection();
		return DBConnection.con;
	}

	public static void werteInDB() {
	//final String auswahl = "";
		/*
		 * liest die Selektion der Radiobutton und wandelt in
		 * DB konforme int var bool 1 oder 0 um 
		 */
		Integer[] bool = new Integer[12];
		for (int g=0;g<12;g++){
			 if (Main.booli[g].isSelected()){
				 bool[g]= 1;
			 }
			 else {bool[g] = 0;};
		 }
		DBConnection.con = getInstance();
		if (DBConnection.con != null) {

			try {
				Statement komplettEinfuegen = DBConnection.con.createStatement();
			

				/**
				 * insert erfolgt jetzt wenig elegant, es fehlt abe grad die
				 * Zeit und die Muße für schöne Lösung
				 */

				String insertTextfelder = "INSERT INTO schuelerdaten ("
						+ Main.persDaten[0].getName() + ", "
						+ Main.persDaten[1].getName() + ", "
						+ Main.persDaten[2].getName() + ", "
						+ Main.persDaten[3].getName() + ", "
						+ Main.persDaten[4].getName() + ", "
						+ Main.persDaten[5].getName() + ", "
						+ Main.persDaten[6].getName() + ", "
						+ Main.persDaten[7].getName() + ", "
						+ Main.persDaten[8].getName() + ", "
						+ Main.persDaten[9].getName() + ", "
						+ Main.persDaten[10].getName() + ", "
						+ Main.persDaten[11].getName() + ", "
						+ Main.persDaten[12].getName() + ", "
						+ Main.persDaten[13].getName() + ", "
						+ Main.persDaten[14].getName() + ", "
						+ Main.persDaten[15].getName() + ", "
						+ Main.persDaten[16].getName() + ", "
						+ Main.persDaten[17].getName() + ", "
						+ Main.persDaten[18].getName() + ", "
						+ Main.persDaten[19].getName() + ", "
						+ Main.persDaten[20].getName() + ", "
						+ Main.persDaten[21].getName() + ", "
						+ Main.persDaten[22].getName() + ", "
						+ Main.persDaten[23].getName() + ", "
						+ Main.persDaten[24].getName() + ", "
						+ Main.persDaten[25].getName() + ", "
						+ Main.persDaten[26].getName() + ", "
						+ Main.persDaten[27].getName() + ", "
						+ Main.persDaten[28].getName() + ", "
						+ Main.persDaten[29].getName() + ", "
						+ Main.persDaten[30].getName() + ", "
						+ Main.persDaten[31].getName() + ", "
						+ Main.persDaten[32].getName() + ", "
						+ Main.persDaten[33].getName() + ", "
						+ Main.persDaten[34].getName() + ", "
						+ Main.persDaten[35].getName() + ", "
						+ Main.persDaten[36].getName() + ", "
						+ Main.bemerk[0].getName() + ", "
						+ Main.booli[0].getName() + ", "
						+ Main.booli[1].getName() + ", "
						+ Main.booli[2].getName() + ", "
						+ Main.booli[3].getName() + ", "
						+ Main.booli[4].getName() + ", "
						+ Main.booli[5].getName() + ", "
						+ Main.booli[6].getName() + ", "
						+ Main.booli[7].getName() + ", "
						+ Main.booli[8].getName() + ", "
						+ Main.booli[9].getName() + ", "
						+ Main.booli[10].getName() + ", "
						+ Main.booli[11].getName() + ", "
						+ Main.divDaten[0].getName() + ", "
						+ Main.divDaten[1].getName() + ", "
						+ Main.divDaten[2].getName() + ", "
						+ Main.divDaten[3].getName() + ", "
						+ Main.divDaten[4].getName() + ", "
						+ Main.divDaten[5].getName() + ", "
						+ Main.divDaten[6].getName() + ", "
						+ Main.divDaten[7].getName() + ", "
						+ Main.divDaten[8].getName() + ",term) VALUES ('"
						+ Main.persDaten[0].getText().replaceAll("[^a-zA-ZäöüÄÖÜßéèêáà -]", "") + "', '"
						+ Main.persDaten[1].getText().replaceAll("[^a-zA-ZäöüÄÖÜßéèêáà -]", "") + "', '"
						+ Main.persDaten[2].getText().replaceAll("[^a-zA-ZäöüÄÖÜßéèêáà -]", "") + "', '"
						+ Main.persDaten[3].getText() + "', '"
						+ Main.persDaten[4].getText() + "', '"
						+ Main.persDaten[5].getText() + "', '"
						+ Main.persDaten[6].getText() + "', '"
						+ Main.persDaten[7].getText() + "', '"
						+ Main.persDaten[8].getText() + "', '"
						+ Main.persDaten[9].getText() + "', '"
						+ Main.persDaten[10].getText() + "', '"
						+ Main.persDaten[11].getText() + "', '"
						+ Main.persDaten[12].getText() + "', '"
						+ Main.persDaten[13].getText() + "', '"
						+ Main.persDaten[14].getText() + "', '"
						+ Main.persDaten[15].getText() + "', '"
						+ Main.persDaten[16].getText() + "', '"
						+ Main.persDaten[17].getText() + "', '"
						+ Main.persDaten[18].getText() + "', '"
						+ Main.persDaten[19].getText() + "', '"
						+ Main.persDaten[20].getText() + "', '"
						+ Main.persDaten[21].getText() + "', '"
						+ Main.persDaten[22].getText() + "', '"
						+ Main.persDaten[23].getText() + "', '"
						+ Main.persDaten[24].getText() + "', '"
						+ Main.persDaten[25].getText() + "', '"
						+ Main.persDaten[26].getText() + "', '"
						+ Main.persDaten[27].getText() + "', '"
						+ Main.persDaten[28].getText() + "', '"
						+ Main.persDaten[29].getText() + "', '"
						+ Main.persDaten[30].getText() + "', '"
						+ Main.persDaten[31].getText() + "', '"
						+ Main.persDaten[32].getText() + "', '"
						+ Main.persDaten[33].getText() + "', '"
						+ Main.persDaten[34].getText() + "', '"
						+ Main.persDaten[35].getText() + "', '"
						+ Main.persDaten[36].getText() + "', '"
						+ Main.bemerk[0].getText() + "', '"
						+ bool[0] + "', '"//Zahlenwert aus obenstehender Umwandlung
						+ bool[1] + "', '"//der boolschen Werte der Radiobutton
						+ bool[2] + "', '"
						+ bool[3] + "', '"
						+ bool[4] + "', '"
						+ bool[5] + "', '"
						+ bool[6] + "', '"
						+ bool[7] + "', '"
						+ bool[8] + "', '"
						+ bool[9] + "', '"
						+ bool[10] + "', '"
						+ bool[11] + "', '"
						+ Main.divDaten[0].getSelectedItem() + "', '"
						+ Main.divDaten[1].getSelectedItem() + "', '"
						+ Main.divDaten[2].getSelectedItem() + "', '"
						+ Main.divDaten[3].getSelectedItem() + "', '"
						+ Main.divDaten[4].getSelectedItem() + "', '"
						+ Main.divDaten[5].getSelectedItem() + "', '"
						+ Main.divDaten[6].getSelectedItem() + "', '"
						+ Main.divDaten[7].getSelectedItem() + "', '"
						+ Main.divDaten[8].getSelectedItem() + "', '"
						+ Main.configData.AKTUELLER_TERM + "')"+
								"ON DUPLICATE KEY UPDATE " +
						" kvorname = '"+Main.kvorname.getText()+"', " +
						" kbeiname = '"+Main.kbeiname.getText()+"', " +
						" kname = '"+Main.kname.getText()+"', " +
						" kgeburtstag = '"+Main.kgeburtstag.getText()+"', " +
						" kgeburtsort = '"+Main.kgeburtsort.getText()+"', " +
						" kreligion = '"+Main.kreligion.getText()+"', " +
						" kstrasse = '"+Main.kstrasse.getText()+"', " +
						" kplz = '"+Main.kplz.getText()+"', " +
						" kwohnort = '"+Main.kwohnort.getText()+"', " +
						" kOT = '"+Main.kOT.getText()+"', " +
						" kstaat = '"+Main.kstaat.getText()+"', " +
						" kkrankenkasse = '"+Main.kkrankenkasse.getText()+"', " +
						" khausarzt = '"+Main.khausarzt.getText()+"', " +
						" tag_ersteinschulung = '"+Main.tag_ersteinschulung.getSelectedItem() +"', " +
						" monat_ersteinschulung = '"+Main.monat_ersteinschulung.getSelectedItem() +"', " +
						" jahr_ersteinschulung = '"+Main.jahr_ersteinschulung.getSelectedItem() +"', " +
						" mname = '"+Main.mname.getText()+"', " +
						" mvorname = '"+Main.mvorname.getText()+"', " +
						" mstrasse = '"+Main.mstrasse.getText()+"', " +
						" mplz = '"+Main.mplz.getText()+"', " +
						" mwohnort = '"+Main.mwohnort.getText()+"', " +
						" mtelpriv = '"+Main.mtelpriv.getText()+"', " +
						" mteldienst = '"+Main.mteldienst.getText()+"', " +
						" memail = '"+Main.memail.getText()+"', " +
						" vname = '"+Main.vname.getText()+"', " +
						" vvorname = '"+Main.vvorname.getText()+"', " +
						" vstrasse = '"+Main.vstrasse.getText()+"', " +
						" vplz = '"+Main.vplz.getText()+"', " +
						" vwohnort = '"+Main.vwohnort.getText()+"', " +
						" vtelpriv = '"+Main.vtelpriv.getText()+"', " +
						" vteldienst = '"+Main.vteldienst.getText()+"', " +
						" vemail = '"+Main.vemail.getText()+"', " +
						" oname = '"+Main.oname.getText()+"', " +
						" ovorname = '"+Main.ovorname.getText()+"', " +
						" ostrasse = '"+Main.ostrasse.getText()+"', " +
						" oplz = '"+Main.oplz.getText()+"', " +
						" owohnort = '"+Main.owohnort.getText()+"', " +
						" otel = '"+Main.otel.getText()+"', " +
						" kstammschule = '"+Main.kstammschule.getText()+"', " +
						" geschwistername = '"+Main.geschwistername.getText()+"', " +
						" bemerkungen = '"+Main.bemerkungen.getText()+"', " +
						" zugangsvoraussetzung = '"+Main.zugangsvoraussetzung.getSelectedItem()+"', " +
						" sorgeberechtigung = '"+Main.sorgeberechtigung.getSelectedItem()+"', " +
						" ausklasse = '"+Main.ausklasse.getSelectedItem()+"', " +
						" inklasse = '"+Main.inklasse.getSelectedItem()+"', " +
						" klasse = '"+Main.klasse.getSelectedItem()+"', " +
						" zweiteFremdsprache = '"+Main.zweiteFremdsprache.getSelectedItem()+"', " +
						" maennlich = '"+bool[0]+"', " +
						" weiblich = '"+bool[1]+"', " +
						" geschwister_ja = '"+bool[2]+"', " +
						" geschwister_nein = '"+bool[3]+"', " +
						" landkreis_ja = '"+bool[4]+"', " +
						" landkreis_nein = '"+bool[5]+"', " +
						" religion = '"+bool[6]+"', " +
						" ethik = '"+bool[7]+"', " +
						" oga_nein = '"+bool[8]+"', " +
						" oga_ja = '"+bool[9]+"', " +
						" doppel_ja = '"+bool[10]+"', " +
						" doppel_nein = '"+bool[11]+"' " /*+
								"WHERE uid = '"+auswahl+"';"*/;
		
				
			//kein Eintrag ohne Nachnamen des Kindes
			if (Main.persDaten[2].getText().isEmpty()){JOptionPane.showMessageDialog(null,"Sie haben keinen Namen eingetragen.","Upps, eine Fehlermeldung!"
					,JOptionPane.ERROR_MESSAGE); return;}
			
			if (Main.persDaten[7].getText().length()>5 ||Main.persDaten[16].getText().length()>5 || Main.persDaten[24].getText().length()>5 ||
					Main.persDaten[32].getText().length()>5) {JOptionPane.showMessageDialog(null,"Eine der Postleitzahlen stimmt nicht - zu lang.","Upps, eine Fehlermeldung!"
				,JOptionPane.ERROR_MESSAGE); }
			else
			{
				
				komplettEinfuegen.executeUpdate(insertTextfelder);
				Main.clearGui();
				
				JOptionPane.showMessageDialog(null,"Der Datensatz wurde scheinbar fehlerfrei angelegt." +
						"\n Alles weitere können Sie entspannt mit einem der Lehrer besprechen\n die nun auf Sie warten.","Datensatz erfolgreich gespeichert!"
						,JOptionPane.INFORMATION_MESSAGE); 
			}	
			} catch (SQLException se) {
				
				JOptionPane.showMessageDialog(null,"Es ist ein Fehler beim Anlegen des Datensatzes" +
						" aufgetreten. Die Systemmeldung lautet: \n"+se,"Upps, eine Fehlermeldung!"
						,JOptionPane.ERROR_MESSAGE); 
			}
			finally
			{
			
		//	DBUtils.safeCloseStatement(DBConnection.con.);
		//	DBUtils.safeCloseConnection(DBConnection.con);
			}
			;

		}
	}
public static void updateDB(String auswahl){
	/*
	 * liest die Selektion der Radiobutton und wandelt in
	 * DB konforme int var bool 1 oder 0 um 
	 */
	
	Integer[] bool = new Integer[12];
	for (int g=0;g<12;g++){
		 if (Main.booli[g].isSelected()){
			 bool[g]= 1;
		 }
		 else {bool[g] = 0;};
	 }
		auswahl = auswahl.replaceAll("\\D+","");
		
		DBConnection.con = getInstance();
		if (DBConnection.con != null) {

			try {
				Statement update = DBConnection.con.createStatement();
				String fuerUpdate = "UPDATE schuelerdaten SET" +
						" kvorname = '"+Main.kvorname.getText()+"', " +
						" kbeiname = '"+Main.kbeiname.getText()+"', " +
						" kname = '"+Main.kname.getText()+"', " +
						" kgeburtstag = '"+Main.kgeburtstag.getText()+"', " +
						" kgeburtsort = '"+Main.kgeburtsort.getText()+"', " +
						" kreligion = '"+Main.kreligion.getText()+"', " +
						" kstrasse = '"+Main.kstrasse.getText()+"', " +
						" kplz = '"+Main.kplz.getText()+"', " +
						" kwohnort = '"+Main.kwohnort.getText()+"', " +
						" kOT = '"+Main.kOT.getText()+"', " +
						" kstaat = '"+Main.kstaat.getText()+"', " +
						" kkrankenkasse = '"+Main.kkrankenkasse.getText()+"', " +
						" khausarzt = '"+Main.khausarzt.getText()+"', " +
						" mname = '"+Main.mname.getText()+"', " +
						" mvorname = '"+Main.mvorname.getText()+"', " +
						" mstrasse = '"+Main.mstrasse.getText()+"', " +
						" mplz = '"+Main.mplz.getText()+"', " +
						" mwohnort = '"+Main.mwohnort.getText()+"', " +
						" mtelpriv = '"+Main.mtelpriv.getText()+"', " +
						" mteldienst = '"+Main.mteldienst.getText()+"', " +
						" memail = '"+Main.memail.getText()+"', " +
						" vname = '"+Main.vname.getText()+"', " +
						" vvorname = '"+Main.vvorname.getText()+"', " +
						" vstrasse = '"+Main.vstrasse.getText()+"', " +
						" vplz = '"+Main.vplz.getText()+"', " +
						" vwohnort = '"+Main.vwohnort.getText()+"', " +
						" vtelpriv = '"+Main.vtelpriv.getText()+"', " +
						" vteldienst = '"+Main.vteldienst.getText()+"', " +
						" vemail = '"+Main.vemail.getText()+"', " +
						" oname = '"+Main.oname.getText()+"', " +
						" ovorname = '"+Main.ovorname.getText()+"', " +
						" ostrasse = '"+Main.ostrasse.getText()+"', " +
						" oplz = '"+Main.oplz.getText()+"', " +
						" owohnort = '"+Main.owohnort.getText()+"', " +
						" otel = '"+Main.otel.getText()+"', " +
						" kstammschule = '"+Main.kstammschule.getText()+"', " +
						" geschwistername = '"+Main.geschwistername.getText()+"', " +
						" bemerkungen = '"+Main.bemerkungen.getText()+"', " +
						" zugangsvoraussetzung = '"+Main.zugangsvoraussetzung.getSelectedItem()+"', " +
						" sorgeberechtigung = '"+Main.sorgeberechtigung.getSelectedItem()+"', " +
						" ausklasse = '"+Main.ausklasse.getSelectedItem()+"', " +
						" inklasse = '"+Main.inklasse.getSelectedItem()+"', " +
						" klasse = '"+Main.klasse.getSelectedItem()+"', " +
						" zweiteFremdsprache = '"+Main.zweiteFremdsprache.getSelectedItem()+"', " +
						" maennlich = '"+bool[0]+"', " +
						" weiblich = '"+bool[1]+"', " +
						" geschwister_ja = '"+bool[2]+"', " +
						" geschwister_nein = '"+bool[3]+"', " +
						" landkreis_ja = '"+bool[4]+"', " +
						" landkreis_nein = '"+bool[5]+"', " +
						" religion = '"+bool[6]+"', " +
						" ethik = '"+bool[7]+"', " +
						" oga_nein = '"+bool[8]+"', " +
						" oga_ja = '"+bool[9]+"', " +
						" doppel_ja = '"+bool[10]+"', " +
						" doppel_nein = '"+bool[11]+"' " +
								"WHERE uid = '"+auswahl+"';";
				if (Main.persDaten[2].getText().isEmpty()){JOptionPane.showMessageDialog(null,"Sie haben keinen Datensatz geöffnet.","Upps, eine Fehlermeldung!"
						,JOptionPane.ERROR_MESSAGE); return;}
				
				if (Main.persDaten[7].getText().length()>5 ||Main.persDaten[16].getText().length()>5 || Main.persDaten[24].getText().length()>5 ||
						Main.persDaten[32].getText().length()>5) {JOptionPane.showMessageDialog(null,"Eine der Postleitzahlen stimmt nicht - zu lang.","Upps, eine Fehlermeldung!"
					,JOptionPane.ERROR_MESSAGE); }
				else
				{
				update.executeUpdate(fuerUpdate);
				}
			}catch(SQLException se){
				
				JOptionPane.showMessageDialog(null,"Es sieht so aus, als hätten Sie keinen Datensatz geladen." +
						"  Die Systemmeldung lautet: \n"+se,"Upps, eine Fehlermeldung!"
						,JOptionPane.ERROR_MESSAGE); 
			}
		}
}

public static void datensatzLoeschen(String auswahl){
	
	auswahl = auswahl.replaceAll("\\D+","");
	
	DBConnection.con = getInstance();
	if (DBConnection.con != null) {

		try {
			Statement delete = DBConnection.con.createStatement();
			String fuerDelete = "DELETE FROM schuelerdaten WHERE uid = '"+auswahl+"';";
			delete.executeUpdate(fuerDelete);
		}catch(SQLException sqle){}
	}
}
}