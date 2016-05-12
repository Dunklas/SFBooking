package server.utils.storage;

import java.sql.*;
import java.util.Date;

class DBHelper {

    private static DBHelper instance;
    private static Connection c;

    private static String hostname = "db.student.chalmers.se";
    private static String servicename = "kingu.ita.chalmers.se";
    private static String USERNAME = "rickaan";
    private static String PASSWORD = "zDi3zwHN"; // Bad!

    private static String PATH;

    private DBHelper() {
	PATH = "jdbc:oracle:thin:@//" + hostname + ":1521/" + servicename;
	openConnection();
    }

    private static void openConnection() {
	try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    c = DriverManager.getConnection(PATH, USERNAME, PASSWORD);
	} catch (Exception ex) {
	    ex.printStackTrace();
	    System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
	    System.exit(0);
	}
    }

    static DBHelper getInstance() {
	if (instance == null) {
	    instance = new DBHelper();
	}
	return instance;
    }

    ResultSet query(String sql) throws SQLException {
       
	    Statement stmt = c.createStatement();
	    return stmt.executeQuery(sql);
       
    }

    int update(String sql) throws SQLException {
	    Statement stmt = c.createStatement();
	    return stmt.executeUpdate(sql);
	
    }

    int update(String sql, Object ... args) throws SQLException{
	try {
	    PreparedStatement stmt = c.prepareStatement(sql);
	    for (int i = 0; i < args.length; i++) {
		if (args[i] instanceof java.util.Date) {
		    stmt.setDate(i+1, new java.sql.Date(((java.util.Date)args[i]).getTime()));
		}
		if (args[i] instanceof String) {
		    stmt.setString(i+1, (String)args[i]);
		}
		if (args[i] instanceof Integer) {
		    stmt.setInt(i+1, (Integer)args[i]);
		}
		if (args[i] instanceof Double) {
		    stmt.setDouble(i+1, (Double)args[i]);
		}
	    }
	    return stmt.executeUpdate();
	} catch(SQLException ex) {
	    throw  new SQLException(ex);
	}
    }
}
