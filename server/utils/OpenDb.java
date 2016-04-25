package server.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class OpenDb {

    Connection c;
    private String hostname = "db.student.chalmers.se";
    private String servicename = "kingu.ita.chalmers.se";
    private String PATH;
    private String USERNAME = "rickaan";
    private String PASSWORD = "zDi3zwHN"; //Bad!

    public OpenDb() {
	PATH = "jdbc:oracle:thin:@//" + hostname + ":1521/" + servicename; 
	openConnection();
    }

    private void openConnection() {
	try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    c = DriverManager.getConnection(PATH, USERNAME, PASSWORD);
	} catch (Exception e) {
	    e.printStackTrace();
	    System.err.println(e.getClass().getName()+": "+e.getMessage());
	    System.exit(0);
	}
	System.out.println("OK!");
    }

    Connection getConnection() {
	if (c != null) {
	    return c;
	}
	else {
	    return null;
	}
    }
}
