package server.utils;

import java.sql.*;




public class Update{

    public void updateGuide(String location, String newGuide) throws SQLException {
	Connection c = new OpenDb().getConnection();
	if (c != null) {
	    PreparedStatement stmt = c.prepareStatement("UPDATE safaridestination SET guide = ? WHERE location = ?");
	    stmt.setString(1, newGuide);
	    stmt.setString(2, location);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();
	}
    }
    







}
