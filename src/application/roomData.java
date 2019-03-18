package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class roomData {
	Connection con;
	public void getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection("jdbc:sqlite:Login.db");
			System.out.println("New connection");
	}
	public ResultSet showAvailable() throws SQLException, ClassNotFoundException {
		if(con==null) {
			getConnection();
		}
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT roomNumber,roomType,bedType,price FROM Hotel WHERE avalability=1;");
		//con.close();
		return res;
	}
	public boolean isExisit(String rn) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
		Statement  s=con.createStatement();
		ResultSet r=s.executeQuery("SELECT * FROM Hotel WHERE roomNumber='"+rn+"';");
		while(r.next()) {
			return false;
		}
		return true;
	}
	public boolean isAvailable(String rn) {
		try {
		if(con==null) {
			getConnection();
		}
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("SELECT roomNumber,avalability FROM Hotel WHERE roomNumber ='"+rn+"';");
		while(rs.next()) {
			if(rs.getInt("avalability")==1) {
				System.out.println(rs.getString("roomNumber"));
				return true;
			}
		}
		}catch(Exception e) {
			e.getMessage();
		}
		return false;
	}
	public int addfname(int rn,String fname) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
	Statement s=con.createStatement();
	int c=s.executeUpdate("UPDATE Hotel SET cfname='"+fname+"' WHERE roomNumber='"+Integer.toString(rn)+"';");
	return c;
	}
	public int addlname(int rn,String lname) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
	Statement s=con.createStatement();
	int c=s.executeUpdate("UPDATE Hotel SET clname='"+lname+"' WHERE roomNumber='"+Integer.toString(rn)+"';");
	return c;
	}
	public int addcity(int rn,String city) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
	Statement s=con.createStatement();
	int c=s.executeUpdate("UPDATE Hotel SET ccity='"+city+"' WHERE roomNumber='"+Integer.toString(rn)+"';");
	return c;
	}
	public int addphone(int rn,String phone) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
	Statement s=con.createStatement();
	int c=s.executeUpdate("UPDATE Hotel SET cphone='"+phone+"' WHERE roomNumber='"+Integer.toString(rn)+"';");
	return c;
	}
	public int addaddhar(int rn,String addhar) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
	Statement s=con.createStatement();
	int c=s.executeUpdate("UPDATE Hotel SET caddhar='"+addhar+"' WHERE roomNumber='"+Integer.toString(rn)+"';");
	return c;
	}
	public int addadd(int rn,String add) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
	Statement s=con.createStatement();
	int c=s.executeUpdate("UPDATE Hotel SET cAdd='"+add+"' WHERE roomNumber='"+Integer.toString(rn)+"';");
	return c;
	}
	public ResultSet getPrice(String rn) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery("SELECT price FROM Hotel WHERE roomNumber="+rn+";");
		return r;
	}
	public int setAva(boolean v,String rn) throws ClassNotFoundException, SQLException {
		int c;
		if(con==null) {
			getConnection();
		}
		Statement s=con.createStatement();
		if(v) {
			c=s.executeUpdate("UPDATE Hotel SET avalability=1 WHERE roomNumber="+rn+";");
			System.out.println("AVA=1");
		}
		else{
			c=s.executeUpdate("UPDATE Hotel SET avalability=0 WHERE roomNumber="+rn+";");
			System.out.println("AVA=0");
		}
		return c;
	}
	public void setDays(String rn,int days) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
		else {
			Statement s=con.createStatement();
			int i=s.executeUpdate("UPDATE Hotel SET days="+Integer.toString(days)+" WHERE roomNumber="+rn+";");
			System.out.println("Days updated for roomnumber "+rn+"to "+Integer.toString(days));
		}
	}
	public int getDays(String rn) throws ClassNotFoundException, SQLException {
		ResultSet r = null;
		int days=0;
		if(con==null) {
			getConnection();
		}
		else {
			Statement s=con.createStatement();
			r=s.executeQuery("SELECT days FROM Hotel WHERE roomNumber="+rn+";");
		}
		while(r.next()) {
			days=r.getInt("days");
		}
		return days;
	}
	public boolean isAva(String rn) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
		else {
			Statement s=con.createStatement();
			ResultSet res=s.executeQuery("SELECT avalability FROM Hotel WHERE roomNumber='"+rn+"';");
			while(res.next()) {
				if(res.getInt("avalability")==1) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	public void addRoom(String rn,String rt,String bt,String p) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
		Statement s=con.createStatement();
		int c=s.executeUpdate("INSERT INTO Hotel (roomNumber,roomType,bedType,price,avalability) VALUES('"+rn+"','"+rt+"','"+bt+"','"+p+"','1')");
		System.out.println((c==1)?("Room added"):("Room not added"));
	}
	public void delRoom(String rn) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
		Statement s=con.createStatement();
		int c=s.executeUpdate("DELETE FROM Hotel WHERE roomNumber='"+rn+"'");
		System.out.println((c==1)?("Room deleted"):("Room not deleted"));
	}
	public ResultSet search(String rn) throws ClassNotFoundException, SQLException {
		if(con==null) {
			getConnection();
		}
		Statement s=con.createStatement();
		ResultSet res=s.executeQuery("SELECT *FROM Hotel WHERE roomNumber='"+rn+"'");
		return res;
	}
	public int update(String rn,String rt,String bt,String p) throws ClassNotFoundException, SQLException {
		int c;
		if(con==null) {
			getConnection();
		}
		Statement s=con.createStatement();
		c=s.executeUpdate("UPDATE Hotel SET roomtype='"+rt+"',bedType='"+bt+"',price='"+p+"' WHERE roomNumber='"+rn+"';");
		System.out.println((c==1)?("Updated sucessfully"):("Update unsuccessful"));
		return c;
	}
	public int delete(String rn) throws ClassNotFoundException, SQLException {
		int c;
		if(con==null) {
			getConnection();
		}
		Statement s=con.createStatement();
		c=s.executeUpdate("DELETE FROM Hotel WHERE roomNumber='"+rn+"'");
		System.out.println((c==1)?("Deleted sucessfully"):("Deletion unsuccessful"));
		return c;
	}
	
}
