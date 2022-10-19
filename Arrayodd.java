package Corejava;

	import java.util.Scanner;

	public class Arrayodd {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the input");
		int a = sc.nextInt();
		// declaring the array
		int arr[] = new int[a];
		System.out.println("enter the element");
		for(int i=0; i<a; i++) {
			arr[i] = sc.nextInt();
		}
		// traversing the array
		System.out.println("even numbers");
				for(int i=0;i<a;i++) {
					if(arr[i]%2 != 0) 
					System.out.println(arr[i]+" ");
				}
	             }
				}

