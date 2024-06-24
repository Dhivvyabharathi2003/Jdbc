package javapackage;
import java.util.*;
public class program 
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);		
		
		int []arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
			
		try{
			System.out.print(arr[7]);
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}

}
