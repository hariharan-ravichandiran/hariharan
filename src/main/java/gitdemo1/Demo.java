package gitdemo1;

import java.util.Scanner;

public class Demo {
	
	static void AAA(int a,int b) {
		System.out.println("Result is :"  + (a+b));
	}

	public static void main(String[] args) {
		Demo dd  =new Demo();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the first value: ");
		int AA = s.nextInt();
		System.out.println("Enter the second value: ");
		int BB = s.nextInt();
		dd.AAA(AA,BB);
		
	}

}
