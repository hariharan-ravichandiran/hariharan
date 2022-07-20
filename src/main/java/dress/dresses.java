package dress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class dresses {
	
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String url="jdbc:mysql://localhost:3306/project1";
		String username="root";
		String password="kgcas@123";
		
		Class.forName(driver);
		
		Connection  con=DriverManager.getConnection(url, username, password);
		
		return con;
		
	}
	
//	public static void admin() throws ClassNotFoundException, SQLException {
//		Scanner sss = new Scanner(System.in);
//		System.out.println("Enter the name: ");
//		String name3 = sss.nextLine();
//		System.out.println("Enter the password");
//		String pass3 = sss.nextLine();
//		Connection con = getCon();
//		String s= "select * from admin where username=? and password=?";
//		
//		PreparedStatement ps=con.prepareStatement(s);
//		ps.setString(1, name3);
//		ps.setString(2, pass3);
//		
//		ResultSet rs = ps.executeQuery();
//		System.out.println(ps);
//		
//		if(rs.next()) 
//		{
//			String str = "password";
//			while (rs.next()) 
//			{
//			String compareTo = rs.getString("pass3");
//			if(str.equals(compareTo ))
//			break;
//			}
//			System.out.println();
//			System.out.println("Login Successful");
//			Admin.admin1();
//		}
//			else
//			{
//			System.out.println("Login Unsuccessful");
//		}
//}
	public static void user() throws ClassNotFoundException, SQLException 
	{
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("Enter your choice: ");
		Scanner sca = new Scanner(System.in);
		int aa = sca.nextInt();
		switch(aa) {
		case 1:
			register();
		case 2:
			login();
		}
	}
	public static void register() throws ClassNotFoundException, SQLException {
			
			System.out.println("Register");
			System.out.println("*****************");
			Scanner ss = new Scanner(System.in);
			System.out.println("Enter your name");
			String name2 = ss.nextLine();
			System.out.println("Create your password: ");
			String pass2 = ss.nextLine();
			 
			Connection con1 = getCon();
			String query = "insert into user values(?, ?)";
			PreparedStatement ps = con1.prepareStatement(query);
			ps.setString(1, name2);
			ps.setString(2, pass2);
			ps.executeUpdate();
			System.out.println("Registered Successfully !!");
			
		}
	public static void login() throws ClassNotFoundException, SQLException {
		Scanner sca1 = new Scanner(System.in);
		System.out.println("Login");
		System.out.println("******");
		System.out.println("Enter your name: ");
		String sa = sca1.nextLine();
		System.out.println("Enter your Password: ");
		String pass4 = sca1.nextLine();
		Connection con2 = getCon();
        String s= "select * from user where username=? and password=?";
		
		PreparedStatement ps=con2.prepareStatement(s);
		ps.setString(1, sa);
		ps.setString(2, pass4);
		
		ResultSet rs = ps.executeQuery();
		System.out.println(ps);
		
		if(rs.next()) 
		{
			String str = "username";
			String str1 = "password";
			while (rs.next()) 
			{
			String compareTo = rs.getString("sa");
			String compareTo1 = rs.getString("pass3");
			if(str.equals(compareTo) && str1.equals(compareTo1))
			break;
			}
			System.out.println();
			System.out.println("Login Successful");
			User.main(null);
		}
		else {
			System.out.println("Invalid Username or Password");
		}
	}
		
	public static void main(String args[]) throws ClassNotFoundException, SQLException 
	{
		dresses dd = new dresses();
		System.out.println("We have the perfect dresses");
		System.out.println("***************************");
		//System.out.println("Enter 1 to ");
		//System.out.println("2.Login");
		//System.out.println("Enter the value: ");
		dd.user();
	}
}

