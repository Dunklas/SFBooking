package server.utils.logs;
import java.time.LocalDateTime;

public class Log {

	public static void put (String err) {
		String error = String.format("%s: %s", LocalDateTime.now().toString(), err); 
		System.out.println(error); // Or write to txt-file???
	}
}
