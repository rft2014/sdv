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
			USER_HAS_PERMISSION = Boolean.valueOf(prop.getProperty("user_has_permission"));
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