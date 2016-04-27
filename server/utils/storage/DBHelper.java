package server.utils.storage;

import java.sql.*;

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

    ResultSet query(String sql) {
	try {
	    Statement stmt = c.createStatement();
	    return stmt.executeQuery(sql);
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    int update(String sql) {
	try {
	    Statement stmt = c.createStatement();
	    return stmt.executeUpdate(sql);
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    return -1;
	}
    }
}
