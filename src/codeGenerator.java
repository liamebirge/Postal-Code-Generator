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
		String code1, code2 = new String(), code3, code4 = new String(), searchCA = "", search;
		Random r = new Random();
		boolean generatingCA = true, generatingUS = true, generating = true;//make all loop variables true
		
		System.out.println("--Postal Code Generator--");//title
		BREAK_ALL://break for all loops, breaks to end code
		while (generating) {//loops until user decides to quit
			System.out.print("\n----Main Menu----\n(1). Generate US Postal Codes\n(2). Generate Canadian Postal Codes\n(3). Help\n(4). Exit\nEnter choice: ");
			int nationality = scan.nextInt();
			if (nationality == 1) {//US postal codes chosen
				BREAK_LOOP1://break for US codes, loops back to choosing US or Canada
				while (generatingUS) {
					System.out.print("\nHow many codes would you like to generate?: ");
					iterations = scan.nextInt();
					String codesUS[] = new String[iterations];
					System.out.println("Calculating...");
					for (int i = 0; i < iterations; i++) {//loop for chosen amount of times, generating and printing a new code each loop
						/*US postal codes are 5 digits long, as to consistently acquire a number
						 *that is 5 long, each digit is randomly chosen.*/
						number1 = r.nextInt(10-0);
						number2 = r.nextInt(10-0);
						number3 = r.nextInt(10-0);
						number4 = r.nextInt(10-0);
						number5 = r.nextInt(10-0);
						code1 = "" + number1 + number2 + number3 + number4 + number5;
						if ((i+1) >= 10) {//if the current iteration is 10 or above, remove a space between the period and the code
							System.out.println("Code #" + (i+1) + ": " + code1);
						} else {//if # of iterations is less than 10, add a space there, this makes the list of codes easier to read
							System.out.println("Code #" + (i+1) + ":  " + code1);
						}
						codesUS[i] = code1;
					}
					Boolean searching = true;
					while (searching) {
						System.out.print("\nWould you like to:\n(1). Return to main menu\n(2). Search through generated codes\n(3). Exit program\nEnter choice: ");
						int cont = scan.nextInt();
						if (cont == 1) {//generate more codes
							break BREAK_LOOP1;
						} else if (cont == 2) {//search through generated codes
							System.out.print("Enter search query: ");
							search = scan.next();
							System.out.println();
							int digits = (int)(search.length()), results = 0;
							if (digits > 5) {
								System.out.println("There are 5 numbers in a US postal code, enter 5 number or less.");
							} else {
								for (int j = 0; j < codesUS.length; j++) {
									code2 = codesUS[j];
									boolean isPresent = code2.contains(search);
									if (!isPresent) {
										continue;
									} else {
										System.out.println(code2);
										results++;
									}
								}
								if (results == 0) {
									System.out.println("No matches were found.");
								}
								System.out.println("\n" + results + " results found");
							}
						} else if (cont == 3) {
							break BREAK_ALL;
						} else {
							System.out.println("That wasn't a valid option, please try again.");
						}
					}
				}
			} else if (nationality == 2) {//Canada codes
				BREAK_LOOP2://break to exit the Canada section and return to US/Canada menu
				while (generatingCA) {
					System.out.print("\nHow many codes would you like to generate?: ");
					iterations = scan.nextInt();
					String codesCA[] = new String[iterations];
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
						code3 = "" + letter1 + number1 + letter2 + number2 + letter3 + number3;
						if ((i+1) >= 10) {//if the current code number is 10 or above, remove a space after the period
							System.out.println("Code #" + (i+1) + ": " + code3);
						} else {//if the current code number is less than 10, add a space after the period, this again allows for the codes to be read more easily
							System.out.println("Code #" + (i+1) + ":  " + code3);
						}
						codesCA[i] = code3;
					}
					Boolean searching = true;
					while (searching) {
						System.out.print("\nWould you like to:\n(1). Return to main menu\n(2). Search through generated codes\n(3). Exit program\nEnter choice: ");
						int cont = scan.nextInt();
						if (cont == 1) {//generate more codes
							break BREAK_LOOP2;
						} else if (cont == 2) {//search through generated codes
							System.out.print("Enter search query: ");
							searchCA = scan.next();
							int digits = (int)(searchCA.length()), results = 0;
							if (digits > 6) {
								System.out.println("There are 3 numbers and 3 letters in a Canadian postal code (EX: A1B2C3)");
							} else {
								for (int j = 0; j < codesCA.length; j++) {
									code4 = codesCA[j];
									boolean isPresent = code4.contains(searchCA);
									if (!isPresent) {
										continue;
									} else {
										System.out.println(code4);
										results++;
									}
								}
								if (results == 0) {
									System.out.println("No matches were found.");
								}
								System.out.println("\n" + results + " results found");
							}
						} else if (cont == 3) {
							break BREAK_ALL;
						} else {
							System.out.println("That wasn't a valid option, please try again.");
						}
					}
				}	
			} else if (nationality == 3) {
				System.out.println("\n\n---------Program-Help---------");
				System.out.println("How to use the program: \n"
						+ "--Menu Advice--\n"
						+ "Menu options are given as numbers in perenthesis EX:'(1). Option'.\n"
						+ "To select an option in the menus, enter the number of your desired selection and press enter.\n"
						+ "Entering a letter or symbol will result in a crash, so stick to numbers.\n"
						+ "\n--Search Advice--\n"
						+ "You may search through the latest generated codes as many times as needed,"
						+ "\n	however if new codes are generated or the main menu is accessed, the previous codes are deleted.\n"
						+ "US postal codes come in groups of five numbers with no spaces or letters, "
						+ "\n	so when entering in a search query for US codes, do not put in any spaces or lettering.\n"
						+ "Canadian postal codes come in groups of 6 characters with alternating numbers and letters (EX: A1B2C3), "
						+ "\n	so do not enter any spaces, and use the postal code's format when entering a search query.\n"
						+ "You may search for as many or as little digets of the codes as you'd like, "
						+ "\n	the search engine will search for any code containing the search group.\n"
						+ "You may generate as many codes as you would like, just remember that larger numbers of codes"
						+ "\n	mean longer calculation times and longer search times.\n");
				wait4Enter();
			} else if (nationality == 4) {
				break BREAK_ALL;
			}else {
				System.out.println("\nThat was not a valid option, please try again.\n");
			}
		}
		System.out.print("\nShutting down...");
	}
	public static void wait4Enter() {//new method
		Scanner s = new Scanner(System.in);//initialize scanner
		System.out.println("Press enter to exit back to main menu.");//prompt user
		s.nextLine();//read for any input including enter key
	}
}
