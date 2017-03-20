package sdv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	
	/**
	 * null-sichere Schließmethode
	 */
	public static void safeCloseStatement(Statement statement){
		
		if (statement != null)
		{
			try
			{
				statement.close();
			}
			catch(final SQLException ex){}
		}
	}
public static void safeCloseConnection(final Connection connection){
		
		if (connection != null)
		{
			try
			{
				connection.close();
			}
			catch(final SQLException ex){}
		}
	}
	
public static void safeCloseResultset(final ResultSet resultset){
	
	if (resultset != null)
	{
		try
		{
			resultset.close();
		}
		catch(final SQLException ex){}
	}
}
}
