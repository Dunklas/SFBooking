package server.utils.logs;
import java.util.Date;

public class Log {

	public static void put (String err) {
		String error = String.format("%s", err); 
		System.out.println(error); // Or write to txt-file???
	}
}
