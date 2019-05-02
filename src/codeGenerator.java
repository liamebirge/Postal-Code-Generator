/********************************************************/
//	     	  Generate Random Postal Codes	    		//
//	 Author: Liam English-Birge		Date: 05/01/2019	//
/********************************************************/

import java.util.*;

public class codeGenerator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//make array of alphabet
		char alphabet[] = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		int number1, number2, number3, number4, number5, iterations;
		char letter1, letter2, letter3;
		Random r = new Random();
		boolean generatingCA = true, generatingUS = true, generating = true;//make all loop variables true
		
		System.out.println("--Postal Code Generator--");//title
		BREAK_ALL://break for all loops, breaks to end code
		while (generating) {//loops until user decides to quit
			System.out.print("Would you like to generate codes for the (1).USA or (2).Canada?: ");
			int nationality = scan.nextInt();
			if (nationality == 1) {//US postal codes chosen
				BREAK_LOOP1://break for US codes, loops back to choosing US or Canada
				while (generatingUS) {
					System.out.print("How many codes would you like to generate?: ");
					iterations = scan.nextInt();
					System.out.println("Calculating...");
					for (int i = 0; i < iterations; i++) {//loop for chosen amount of times, generating and printing a new code each loop
						/*US postal codes are 5 digits long, as to consistently acquire a number
						 *that is 5 long, each digit is randomly chosen.*/
						number1 = r.nextInt(10-0);
						number2 = r.nextInt(10-0);
						number3 = r.nextInt(10-0);
						number4 = r.nextInt(10-0);
						number5 = r.nextInt(10-0);
						if ((i+1) >= 10) {//if the current iteration is 10 or above, remove a space between the period and the code
							System.out.println("Code #" + (i+1) + ": " + number1 + number2 + number3 + number4 + number5);
						} else {//if # of iterations is less than 10, add a space there, this makes the list of codes easier to read
							System.out.println("Code #" + (i+1) + ":  " + number1 + number2 + number3 + number4 + number5);
						}
					}
					System.out.print("Would you like to generate more postal codes? <y/n>: ");
					char cont = scan.next().charAt(0);
					if (cont != 'y' && cont != 'Y') {//if user's response is anything other than y, break from all loops
						generatingCA = false;
						break BREAK_ALL;
					} else {//otherwise just loop back to US/Canada selection menu
						break BREAK_LOOP1;
					}
				}
			} else if (nationality == 2) {//Canada codes
				BREAK_LOOP2://break to exit the Canada section and return to US/Canada menu
				while (generatingCA) {
					System.out.print("How many codes would you like to generate?: ");
					iterations = scan.nextInt();
					System.out.println("Calculating...");
					for (int i = 0; i < iterations; i++) {//loops for given number of times
						/*Since Canada's postal code system involves both 3 numbers and letters,
						 *each number is calculated individually and each letter is chosen randomly from the
						 *alphabet array*/
						number1 = r.nextInt(10-0);
						number2 = r.nextInt(10-0);
						number3 = r.nextInt(10-0);
						letter1 = alphabet[r.nextInt(26-0)];
						letter2 = alphabet[r.nextInt(26-0)];
						letter3 = alphabet[r.nextInt(26-0)];
						if ((i+1) >= 10) {//if the current code number is 10 or above, remove a space after the period
							System.out.println("Code #" + (i+1) + ": " + letter1 + number1 + letter2 + " " + number2 + letter3 + number3);
						} else {//if the current code number is less than 10, add a space after the period, this again allows for the codes to be read more easily
							System.out.println("Code #" + (i+1) + ":  " + letter1 + number1 + letter2 + " " + number2 + letter3 + number3);
						}
					}
					System.out.print("Would you like to generate more postal codes? <y/n>: ");
					char cont = scan.next().charAt(0);
					if (cont != 'y' && cont != 'Y') {//if user's response is anything other than y, break from all loops
						generatingCA = false;
						break BREAK_ALL;
					} else {//otherwise just loop back to US/Canada selection menu
						break BREAK_LOOP2;
					}
				}	
			} else {
				System.out.println("That was not a valid option, please try again.\n");
			}
		}
		System.out.print("Shutting down...");
	}
}
