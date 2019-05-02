/********************************************************/
//	     	  Generate Random Postal Codes	    		//
//	 Author: Liam English-Birge		Date: 05/01/2019	//
/********************************************************/

import java.util.*;

public class codeGenerator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char alphabet[] = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		int number1, number2, number3, number4, number5, iterations;
		char letter1, letter2, letter3;
		Random r = new Random();
		boolean generatingCA = true, generatingUS = true, generating = true;
		
		System.out.println("--Postal Code Generator--");
		BREAK_ALL:
		while (generating) {
			System.out.print("Would you like to generate codes for the (1).USA or (2).Canada?: ");
			int nationality = scan.nextInt();
			if (nationality == 1) {
				BREAK_LOOP1:
				while (generatingUS) {
					System.out.print("How many codes would you like to generate?: ");
					iterations = scan.nextInt();
					System.out.println("Calculating...");
					for (int i = 0; i < iterations; i++) {
						number1 = r.nextInt(10-0);
						number2 = r.nextInt(10-0);
						number3 = r.nextInt(10-0);
						number4 = r.nextInt(10-0);
						number5 = r.nextInt(10-0);
						if ((i+1) >= 10) {
							System.out.println("Code #" + (i+1) + ": " + number1 + number2 + number3 + number4 + number5);
						} else {
							System.out.println("Code #" + (i+1) + ":  " + number1 + number2 + number3 + number4 + number5);
						}
					}
					System.out.print("Would you like to generate more postal codes? <y/n>: ");
					char cont = scan.next().charAt(0);
					if (cont != 'y' && cont != 'Y') {
						generatingCA = false;
						break BREAK_ALL;
					} else {
						break BREAK_LOOP1;
					}
				}
			} else if (nationality == 2) {
				BREAK_LOOP2:
				while (generatingCA) {
					System.out.print("How many codes would you like to generate?: ");
					iterations = scan.nextInt();
					System.out.println("Calculating...");
					for (int i = 0; i < iterations; i++) {
						number1 = r.nextInt(10-0);
						number2 = r.nextInt(10-0);
						number3 = r.nextInt(10-0);
						letter1 = alphabet[r.nextInt(26-0)];
						letter2 = alphabet[r.nextInt(26-0)];
						letter3 = alphabet[r.nextInt(26-0)];
						if ((i+1) >= 10) {
							System.out.println("Code #" + (i+1) + ": " + letter1 + number1 + letter2 + " " + number2 + letter3 + number3);
						} else {
							System.out.println("Code #" + (i+1) + ":  " + letter1 + number1 + letter2 + " " + number2 + letter3 + number3);
						}
					}
					System.out.print("Would you like to generate more postal codes? <y/n>: ");
					char cont = scan.next().charAt(0);
					if (cont != 'y' && cont != 'Y') {
						generatingCA = false;
						break BREAK_ALL;
					} else {
						break BREAK_LOOP2;
					}
				}	
			}
		}
		System.out.print("Shutting down...");
	}
}
