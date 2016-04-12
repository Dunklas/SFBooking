import java.sql.Connection;
import java.sql.DriverManager;

public class OpenDb {

    Connection c;
    private String ip = "127.0.0.1";
    private String PATH;
    private String USERNAME = "postgres";
    private String PASSWORD = "tig059";

    public OpenDb() {
	PATH = "jdbc:postgresql://" + ip + ":5432/sftest";
	openConnection();
    }

    private void openConnection() {
	try {
	    Class.forName("org.postgresql.Driver");
	    c = DriverManager.getConnection(PATH, USERNAME, PASSWORD);
	} catch (Exception e) {
	    e.printStackTrace();
	    System.err.println(e.getClass().getName()+": "+e.getMessage());
	    System.exit(0);
	}
	System.out.println("OK!");
    }
}
