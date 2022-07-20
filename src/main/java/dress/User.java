package dress;

import java.sql.SQLException;
import java.util.Scanner;

public class User {
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		System.out.println("Choose Your Gender");
		System.out.println("1. Male");
		System.out.println("2. Female");
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		switch(A) {
		case 1:
		   Male.main(null);
		case 2:
			Female.main(null);
		}
		
	}

		
}
