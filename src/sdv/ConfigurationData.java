package sdv;

import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class  ConfigurationData {
	public String DBNAME = "";
	public String DBHOST = "";
	public String DBUSER = "";
	public String DBPORT = "";
	public String DBPASSWORD = "";
	public String JAHRGANG = "";
	public boolean USER_HAS_PERMISSION = false;
	public String TAG_ERSTEINSCHULUNG = "";
	public String MONAT_ERSTEINSCHULUNG = "";
	public String JAHR_ERSTEINSCHULUNG = "";
	public String AKTUELLER_TERM = "";
	public String BRIEFTEXT1 = "";
	public String BRIEFTEXT2 = "";
	public String BRIEFTEXT3 = "";
	public String BRIEFTEXT4 = "";
	public String[] ROLLE_ALS_SORGEBERECHTIGTER1;
	public String[] ROLLE_ALS_SORGEBERECHTIGTER2;
	public String[] ART_DER_SORGEBERECHTIGUNG;
	public String[] ART_DER_ZUGANGSVORAUSSETZUNG;
	public String PROBEUNTERRICHT_INDEX;
	public String PROBEUNTERRICHT_TEXT;
	public String ZEUGNIS_FEHLT_INDEX;
	public String ZEUGNIS_FEHLT_TEXT;
	public String EMPFEHLUNG_FEHLT_INDEX;
	public String EMPFEHLUNG_FEHLT_TEXT;
	public String EINVERSTAENDNIS_FEHLT_INDEX;
	public String EINVERSTAENDNIS_FEHLT_TEXT;
	public String SORGERECHTSERKLAERUNG_FEHLT_INDEX;
	public String SORGERECHTSERKLAERUNG_FEHLT_TEXT;
	public String NEGATIVATTEST_FEHLT_INDEX;
	public String NEGATIVATTEST_FEHLT_TEXT;
	public String PFLEGSCHAFTSNACHWEIS_FEHLT_INDEX;
	public String PFLEGSCHAFTSNACHWEIS_FEHLT_TEXT;
	public String VORMUNDSCHAFTSERKLAERUNG_FEHLT_INDEX;
	public String VORMUNDSCHAFTSERKLAERUNG_FEHLT_TEXT;
	public String FOTOERLAUBNIS;
	public String DATENSCHUTZERKLAERUNG;
	
	public ConfigurationData() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(Main.OutDir+"config.properties");

			// load  properties into constants
			prop.load(input);

			
			DBHOST = prop.getProperty("dbhost");
			DBNAME = prop.getProperty("dbname");
			DBPORT = prop.getProperty("dbport");
			DBUSER = prop.getProperty("dbuser");
			DBPASSWORD = prop.getProperty("dbpassword");
			
			JAHRGANG = prop.getProperty("jahrgang");
			TAG_ERSTEINSCHULUNG = prop.getProperty("tag_ersteinschulung");
			MONAT_ERSTEINSCHULUNG = prop.getProperty("monat_ersteinschulung");
			JAHR_ERSTEINSCHULUNG = prop.getProperty("jahr_ersteinschulung");
			USER_HAS_PERMISSION = Boolean.valueOf(prop.getProperty("user_has_permission"));
			AKTUELLER_TERM = prop.getProperty("aktueller_term");
			ART_DER_SORGEBERECHTIGUNG = prop.getProperty("art_der_sorgeberechtigung").split(",");
			ART_DER_ZUGANGSVORAUSSETZUNG = prop.getProperty("art_der_zugangsvoraussetzung").split(",");
			ROLLE_ALS_SORGEBERECHTIGTER1 = prop.getProperty("rolle_als_sorgeberechtigter1").split(",");
			ROLLE_ALS_SORGEBERECHTIGTER2 = prop.getProperty("rolle_als_sorgeberechtigter2").split(",");
			BRIEFTEXT1 = prop.getProperty("text1");
			BRIEFTEXT2 = prop.getProperty("text2");
			BRIEFTEXT3 = prop.getProperty("text3");
			BRIEFTEXT4 = prop.getProperty("text4");
			PROBEUNTERRICHT_INDEX = prop.getProperty("probeunterricht_index");
			PROBEUNTERRICHT_TEXT =  prop.getProperty("probeunterricht_text");
			ZEUGNIS_FEHLT_INDEX = prop.getProperty("zeugnis_fehlt_index");
			ZEUGNIS_FEHLT_TEXT =  prop.getProperty("zeugnis_fehlt_text");
			EMPFEHLUNG_FEHLT_INDEX = prop.getProperty("empfehlung_fehlt_index");
			EMPFEHLUNG_FEHLT_TEXT =  prop.getProperty("empfehlung_fehlt_text");
			EINVERSTAENDNIS_FEHLT_INDEX = prop.getProperty("einverstaendnis_fehlt_index");
			EINVERSTAENDNIS_FEHLT_TEXT =  prop.getProperty("einverstaendnis_fehlt_text");
			SORGERECHTSERKLAERUNG_FEHLT_INDEX = prop.getProperty("sorgerechtserklaerung_fehlt_index");
			SORGERECHTSERKLAERUNG_FEHLT_TEXT =  prop.getProperty("sorgerechtserklaerung_fehlt_text");
			NEGATIVATTEST_FEHLT_INDEX = prop.getProperty("negativattest_fehlt_index");
			NEGATIVATTEST_FEHLT_TEXT =  prop.getProperty("negativattest_fehlt_text");
			PFLEGSCHAFTSNACHWEIS_FEHLT_INDEX = prop.getProperty("pflegschaftsnachweis_fehlt_index");
			PFLEGSCHAFTSNACHWEIS_FEHLT_TEXT =  prop.getProperty("pflegschaftsnachweis_fehlt_text");
			VORMUNDSCHAFTSERKLAERUNG_FEHLT_INDEX = prop.getProperty("vormundschaftserklaerung_fehlt_index");
			VORMUNDSCHAFTSERKLAERUNG_FEHLT_TEXT =  prop.getProperty("vormundschaftserklaerung_fehlt_text");
			FOTOERLAUBNIS = prop.getProperty("fotoerlaubnis");
			DATENSCHUTZERKLAERUNG = prop.getProperty("datenschutzerklaerung");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	  }
}