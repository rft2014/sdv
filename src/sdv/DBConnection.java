package sdv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static Connection con = null;
	
	private static String dbHost = Main.configData.DBHOST; // Hostname
	private static String dbPort = Main.configData.DBPORT; // Port -- Standard: 3306
	private static String dbName = Main.configData.DBNAME; // Datenbankname
	private static String dbUser = Main.configData.DBUSER; // Datenbankuser
	private static String dbPass = Main.configData.DBPASSWORD; // Datenbankpasswort


	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC
													// Schnittstellen laden.

			// Verbindung zur JDBC-Datenbank herstellen.
			con = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
					+ dbPort + "/" + dbName + "?" + "user=" + dbUser + "&"
					+ "password=" + dbPass);
		} catch (ClassNotFoundException e) {
			System.out.println("Treiber nicht gefunden");
		} catch (SQLException e) {
			System.out.println("Verbindung leider nicht möglich");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}

	private static Connection getInstance() {
		if (con == null)
			new DBConnection();
		return con;
	}

	public static void createTables() {

	con = getInstance();
	if (con != null) {

			
			try {
			Statement anlegen = con.createStatement();
				//String dropTable = "DROP TABLE  schuelerdaten";
				String createSQL = "CREATE TABLE IF NOT EXISTS schuelerdaten "+
						"(uid INT AUTO_INCREMENT ,"+
						"kvorname VARCHAR(50),"+
						"kbeiname VARCHAR(50),"+
						"kname VARCHAR(50),"+
						"kgeburtstag VARCHAR(50),"+
						"kgeburtsort VARCHAR(50)," +
						"kreligion VARCHAR(50)," +
						"kstrasse VARCHAR(50)," +
						"kplz VARCHAR(5)," +
						"kwohnort VARCHAR(50)," +
						"kOT VARCHAR(50)," +
						"kstaat VARCHAR(20)," +
						"kkrankenkasse VARCHAR(100)," +
						"khausarzt VARCHAR(100)," +
						"rolle_als_sorgeberechtigter1 VARCHAR(50)," +
						"mname VARCHAR(50)," +
						"mvorname VARCHAR(50)," +
						"mstrasse VARCHAR(50)," +
						"mplz VARCHAR(5)," +
						"mwohnort VARCHAR(50)," +
						"mtelpriv VARCHAR(50)," +
						"mteldienst VARCHAR(50)," +
						"memail VARCHAR(50)," +
						"rolle_als_sorgeberechtigter2 VARCHAR(50)," +
						"vname VARCHAR(50)," +
						"vvorname VARCHAR(50)," +
						"vstrasse VARCHAR(50)," +
						"vplz VARCHAR(5)," +
						"vwohnort VARCHAR(50)," +
						"vtelpriv VARCHAR(50)," +
						"vteldienst VARCHAR(50)," +
						"vemail VARCHAR(50)," +
						"oname VARCHAR(50)," +
						"ovorname VARCHAR(50)," +
						"otel VARCHAR(50)," +
						"oplz VARCHAR(5)," +
						"owohnort VARCHAR(50)," +
						"ostrasse VARCHAR(50)," +
						"kstammschule VARCHAR(100)," +
						"geschwistername VARCHAR(50)," +
						"bemerkungen VARCHAR(500)," +
						"zugangsvoraussetzung VARCHAR(100)," +
						"sorgeberechtigung VARCHAR(100)," +
						"ausklasse VARCHAR(2)," +
						"inklasse VARCHAR(2)," +
						"maennlich BOOLEAN," +
						"weiblich BOOLEAN," +
						"geschwister_ja BOOLEAN," +
						"geschwister_nein BOOLEAN," +
						"landkreis_ja BOOLEAN," +
						"landkreis_nein BOOLEAN," +
						"religion BOOLEAN," +
						"ethik BOOLEAN," +
						"oga_ja BOOLEAN," +
						"oga_nein BOOLEAN," +
						"doppel_ja BOOLEAN," +
						"doppel_nein BOOLEAN," +
						"klasse VARCHAR(3)," +
						"zweiteFremdsprache VARCHAR(20)," +
						"tag_ersteinschulung VARCHAR(2)," +
						"monat_ersteinschulung VARCHAR(2),"+
						"jahr_ersteinschulung VARCHAR(4),"+
						"anzahl_geschwister VARCHAR(2),"+
						"term VARCHAR(2)," +
						"PRIMARY KEY (uid)," +
						"UNIQUE INDEX(kvorname, kbeiname, kname, kgeburtstag))";
				//anlegen.executeUpdate(dropTable);
				anlegen.executeUpdate(createSQL);
				
			} catch (SQLException e) {
				System.out.println("nach execute"+e);
			}
			;
			
		}
	}

	public static void printNameList() {
		con = getInstance();

		if (con != null) {
			// Abfrage-Statement erzeugen.
			Statement query;
			try {
				query = con.createStatement();

				// Tabelle anzeigen
				String sql = "SELECT uid, name, vorname FROM test_table";
				ResultSet result = query.executeQuery(sql);

				// Ergebnisstabelle durchforsten
				while (result.next()) {
					String uid = result.getString("uid");
					String name = result.getString("name");
					String vorname = result.getString("vorname");
					String info = uid + ", " + name + ", " + vorname;

					System.out.println(info);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	 
}

