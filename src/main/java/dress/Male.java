package dress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Male {
	
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String url="jdbc:mysql://localhost:3306/project1";
		String username="root";
		String password="kgcas@123";
		
		Class.forName(driver);
		
		Connection  con=DriverManager.getConnection(url, username, password);
		
		return con;
		
	}
	
	public static void wedding() throws ClassNotFoundException, SQLException {
		
		System.out.println("Choose the dress you want: ");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Kurta");
		list.add("Pajama");
		list.add("Dhoti");
		list.add("Turban");
		Iterator i = list.iterator();
		while(i.hasNext()) {
			Object e = i.next();
			System.out.println(e);
		}
		String dress = "";
		String size = "";
		String color = "";
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter your dress: ");
		dress = s1.nextLine();
		if(dress.equals("Kurta") || dress.equals("Pajama") || dress.equals("Dhoti") || dress.equals("Turban")) 
		{
			System.out.println("Enter your Size: ");
			ArrayList<String> arr1 = new ArrayList<String>();
			arr1.add("XS");
			arr1.add("S");
			arr1.add("L");
			arr1.add("M");
			Iterator i1 = arr1.iterator();
			while(i1.hasNext()) {
				Object e1 = i1.next();
				System.out.println(e1);
			}
			size = s1.nextLine();
		    System.out.println("Choose the color you want: ");
			ArrayList<String> arr2 = new ArrayList<String>();
				arr2.add("Red");
				arr2.add("Green");
				arr2.add("Blue");
				arr2.add("Sandal");
				Iterator ii = arr2.iterator();
				while(ii.hasNext()) {
					Object e4 = ii.next();
					System.out.println(e4);
				}
		        color = s1.nextLine();
		        System.out.println("How many Days you want:   (Maximum 3 days");
		        System.out.println("One day rent is : 2000");
		        int d = s1.nextInt();
		        int finalrent = 0;
		        if(d > finalrent) {
		        	finalrent = (d * 2000);
		        	System.out.println(finalrent);
		        }
		        else
		        {
		        	System.out.println("Max 3 days");
		        }
		        
		        System.out.println("Your Choosed Dress is:  " + dress);
		        System.out.println("Your Choosed Size is:  " + size);
		        System.out.println("Your Choosed Color is:  " + color);
		        System.out.println("Total Rent of your Dress is:  " + finalrent);
		        bill(dress, size, color, finalrent);
		}
		        				
}
	
	public static void reception() throws ClassNotFoundException, SQLException {
		
		System.out.println("Choose the dress you want: ");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Coatsuit");
		list.add("Pathani");
		list.add("Westernsuit");
		list.add("Velvet");
		Iterator i = list.iterator();
		while(i.hasNext()) {
			Object e = i.next();
			System.out.println(e);
		}
		String dress = "";
		String size = "";
		String color = "";
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter your dress: ");
		dress = s1.nextLine();
		if(dress.equals("Coatsuit") || dress.equals("Pathani") || dress.equals("Westernsuit") || dress.equals("Velvet")) 
		{
			System.out.println("Enter your Size: ");
			ArrayList<String> arr1 = new ArrayList<String>();
			arr1.add("XS");
			arr1.add("S");
			arr1.add("L");
			arr1.add("M");
			Iterator i1 = arr1.iterator();
			while(i1.hasNext()) {
				Object e1 = i1.next();
				System.out.println(e1);
			}
			size = s1.nextLine();
		    System.out.println("Choose the color you want: ");
			ArrayList<String> arr2 = new ArrayList<String>();
				arr2.add("Red");
				arr2.add("Green");
				arr2.add("Blue");
				arr2.add("Sandal");
				Iterator ii = arr2.iterator();
				while(ii.hasNext()) {
					Object e4 = ii.next();
					System.out.println(e4);
				}
		        color = s1.nextLine();
		        System.out.println("How many Days you want:   (Maximum 3 days");
		        System.out.println("One day rent is : 2000");
		        int d = s1.nextInt();
		        int finalrent = 0;
		        if(d > finalrent) {
		        	finalrent = (d * 2000);
		        	System.out.println(finalrent);
		        }
		        else
		        {
		        	System.out.println("Max 3 days");
		        }
		        
		        System.out.println("Your Choosed Dress is:  " + dress);
		        System.out.println("Your Choosed Size is:  " + size);
		        System.out.println("Your Choosed Color is:  " + color);
		        System.out.println("Total Rent of your Dress is:  " + finalrent);
		        bill(dress, size, color, finalrent);
		}
		        				
}
	public static void bill(String dress, String size, String color, int finalrent) throws ClassNotFoundException, SQLException {
		
		Connection con1 = getCon();
		String query = "insert into male (dress, size, color, finalrent) values(?, ?, ?, ?)";
		PreparedStatement ps = con1.prepareStatement(query);
		ps.setString(1, dress);
		ps.setString(2, size);
		ps.setString(3, color);
		ps.setInt(4, finalrent);
		ps.executeUpdate();
		System.out.println("Registered Successfully !!");
		
	}
		
	    
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println("Welcome to Men Section");
		System.out.println("**********************");
		
		HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
		 map.put(1,"Wedding");  //Put elements in Map  
		 map.put(2,"Reception");    
	
		 for(Map.Entry m : map.entrySet()){    
		 System.out.println(m.getKey()+" "+m.getValue());
		 }
		 System.out.println("Choose Your Occasion");
		 Scanner s = new Scanner(System.in);
		 int A = s.nextInt();
		 switch(A) {
		 case 1:
			 wedding();
			 break;
		 case 2:
			reception();
			 break;
		default:
			System.out.println("Choose your occasion");
		 }
		 
		 }
		
	}

