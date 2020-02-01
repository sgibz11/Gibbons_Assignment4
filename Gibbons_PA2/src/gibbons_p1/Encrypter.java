package gibbons_p1;

import java.util.Scanner;

public class Encrypter{
	public static String encrypt(String number) {
		int arr[] = new int [4];
		for(int i=0;i<4;i++) {
			char ch= number.charAt(i);
			arr[i] = Character.getNumericValue(ch);
		}
		for(int i=0;i<4;i++) {
			int temp = arr[i];
			temp +=7;
			temp = temp%10;
			arr[i]= temp;
		}
		int temp = arr[0];
		arr[0]=arr[2];
		arr[2]=temp;
		temp = arr[1];
		arr[1] = arr[3];
		arr[3] = temp;
		int newNumber =0; 
		for(int i=0;i<4;i++)
			newNumber= newNumber*10 + arr[i];
		String output = Integer.toString(newNumber);
		if(arr[0]==0)
			output = "0"+output;
		return output;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a 4-Digit number: ");
		String number = sc.nextLine();
		String encryptedNumber = encrypt(number);
		System.out.println("The encrypted number is: " +encryptedNumber);
	}
}