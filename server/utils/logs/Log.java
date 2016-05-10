package server.utils.logs;

public class Log {

	public static void put (String error) {
		String error = String.format("%t: %s", new Date(), error); 
		System.out.println(error); // Or write to txt-file???
	}
}
