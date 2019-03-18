package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class database {
	Connection con;
	public void getConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
		con=DriverManager.getConnection("jdbc:sqlite:Login.db");
	}
	public boolean verify(String usr,String pass) throws Exception {
		if(con==null) {
			getConnection();
		}
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT username, password FROM Login WHERE username='"+usr+"';");
		while(res.next()) {
			if((res.getString("username").matches(usr))&&(res.getString("password").matches(pass))){
				System.out.println("Done");
				//con.close();
				return true;
			}
			else {
				System.out.println(res.getString("username"));
				//con.close();
			}
		}
		return false;
	}
}
