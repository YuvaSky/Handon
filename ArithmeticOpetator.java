package Corejava;

import java.util.Scanner;

public class ArithmeticOpetator {
	
	public static void main(String[]args) {
		//creating scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		//getting input value form user
		System.out.println("enter fist value");
		int num1 =sc.nextInt();
		System.out.println("enter second value");
		int num2 =sc.nextInt();
		System.out.println("enter third value");
		int num3 =sc.nextInt();
		//writting operator
		int add,sub,mul,div,mod;
		add= num1+num2+num3;
		sub= num1-num2-num3;
		mul= num1*num2*num3;
		div= num1/num2/num3;
		mod= num1%num2%num3;
		//getting result
		System.out.println("Addition is :"+ add);
		System.out.println("Subtration is :"+ sub);
		System.out.println("Multipliaction is :"+ mul);
		System.out.println("division is :"+ div);
		System.out.println("Module is :"+ mod);
		}

}
