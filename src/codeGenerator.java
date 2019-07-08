/********************************************************/
//	     	  Generate Random Postal Codes	    		//
//	 Author: Liam English-Birge		Date: 05/02/2019	//
/********************************************************/


import java.util.*;

public class codeGenerator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//make array of alphabet
		char alphabet[] = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		int number1, number2, number3, number4, number5, iterations;//variables for individual numbers in both code types
		char letter1, letter2, letter3;//letter variables for CA codes
		String genCodesUS, searchCodesUS = new String(), genCodesCA, searchCodesCA = new String(), searchCA = "", search;//storage variables for codes in loops as well as searches
		Random r = new Random();//random number generator
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
					String codesUS[] = new String[iterations];//declare US code array size based on how many codes will be generated
					System.out.println("Calculating...");
					for (int i = 0; i < iterations; i++) {//loop for chosen amount of times, generating and printing a new code each loop
						/*US postal codes are 5 digits long, as to consistently acquire a number
						 *that is 5 long, each digit is randomly chosen.*/
						number1 = r.nextInt(10-0);
						number2 = r.nextInt(10-0);
						number3 = r.nextInt(10-0);
						number4 = r.nextInt(10-0);
						number5 = r.nextInt(10-0);
						genCodesUS = "" + number1 + number2 + number3 + number4 + number5;
						if ((i+1) >= 10) {//if the current iteration is 10 or above, remove a space between the period and the code
							System.out.println("Code #" + (i+1) + ": " + genCodesUS);
						} else {//if # of iterations is less than 10, add a space there, this makes the list of codes easier to read
							System.out.println("Code #" + (i+1) + ":  " + genCodesUS);
						}
						codesUS[i] = genCodesUS;//store generated code in the code array
					}
					Boolean searching = true;//keeps the search looping until user exits
					while (searching) {
						System.out.print("\nWould you like to:\n(1). Return to main menu\n(2). Search through generated codes\n(3). Exit program\nEnter choice: ");
						int cont = scan.nextInt();
						if (cont == 1) {//go back to main menu and generate more codes
							break BREAK_LOOP1;
						} else if (cont == 2) {//search through generated codes
							System.out.print("Enter search query: ");
							search = scan.next();
							System.out.println();
							int digits = (int)(search.length());//counts how many characters have been entered by the user
							int results = 0;//set number of results to start at 0
							if (digits > 5) {//if the user enters more than 5 digits, don't let them search but loop back to entering their query
								System.out.println("There are 5 numbers in a US postal code, enter 5 number or less.");//tell them why
							} else {//if the user enters an appropriate number of characters:
								for (int j = 0; j < codesUS.length; j++) {//search engine loops through all generated codes and compares to the search key entered by user
									searchCodesUS = codesUS[j];//storage variable for current code
									boolean isPresent = searchCodesUS.contains(search);//returns true if the current code contains the user specified search key
									if (!isPresent) {//if the code doesn't contain the search key, move to the next code
										continue;
									} else {//otherwise print the code and increment the result counter
										System.out.println(searchCodesUS);
										results++;
									}
								}
								if (results == 0) {//if the search engine didn't find any matches
									System.out.println("No matches were found.");//tell the user
								} else {//otherwise display how many results were found
									System.out.println("\n" + results + " results found");
								}
							}
						} else if (cont == 3) {//shut program down
							break BREAK_ALL;
						} else {//error catch
							System.out.println("\nThat wasn't a valid option, please try again.");
						}
					}
				}
			} else if (nationality == 2) {//Canada codes
				BREAK_LOOP2://break to exit the Canada section and return to main menu
				while (generatingCA) {
					System.out.print("\nHow many codes would you like to generate?: ");
					iterations = scan.nextInt();
					String codesCA[] = new String[iterations];//declare Canada code array size based on how many codes will be generated
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
						genCodesCA = "" + letter1 + number1 + letter2 + number2 + letter3 + number3;
						if ((i+1) >= 10) {//if the current code number is 10 or above, remove a space after the period
							System.out.println("Code #" + (i+1) + ": " + genCodesCA);
						} else {//if the current code number is less than 10, add a space after the period, this again allows for the codes to be read more easily
							System.out.println("Code #" + (i+1) + ":  " + genCodesCA);
						}
						codesCA[i] = genCodesCA;//store generated code in code array
					}
					Boolean searching = true;//keeps the search loop looping
					while (searching) {
						System.out.print("\nWould you like to:\n(1). Return to main menu\n(2). Search through generated codes\n(3). Exit program\nEnter choice: ");
						int cont = scan.nextInt();
						if (cont == 1) {//return to main menu to generate more codes
							break BREAK_LOOP2;
						} else if (cont == 2) {//search through generated codes
							System.out.print("Enter search query: ");
							searchCA = scan.next();
							int digits = (int)(searchCA.length());//calculated the number of characters entered by user
							int results = 0;//start result counter at 0
							if (digits > 6) {//if the user enters more than 6 characters don't let the search proceed and tell them why, then loop back to search prompt
								System.out.println("There are 3 numbers and 3 letters in a Canadian postal code (EX: A1B2C3)");
							} else {//otherwise perform a search
								for (int j = 0; j < codesCA.length; j++) {//loop through entire code array
									searchCodesCA = codesCA[j];//storage variable for current code
									boolean isPresent = searchCodesCA.contains(searchCA);//returns true if the current code contains the search key
									if (!isPresent) {//if the code doesn't contain the search key, move on to next code
										continue;
									} else {//otherwise, print out the code and increment the number of results
										System.out.println(searchCodesCA);
										results++;
									}
								}
								if (results == 0) {//if no results were found
									System.out.println("No results were found.");
								} else {//otherwise display how many results were found
									System.out.println("\n" + results + " results found");
								}
							}
						} else if (cont == 3) {//quit program
							break BREAK_ALL;
						} else {//error catch
							System.out.println("/nThat wasn't a valid option, please try again.");
						}
					}
				}	
			} else if (nationality == 3) {//help menu
				System.out.println("\n\n---------Program-Help---------");
				System.out.println("How to use the program: \n"
						+ "--Menu Advice--\n"
						+ "* Menu options are given as numbers in perenthesis EX:'(1). Option'.\n"
						+ "* To select an option in the menus, enter the number of your desired selection and press enter.\n"
						+ "* Entering a letter or symbol will result in a crash, so stick to numbers.\n"
						+ "\n--Search Advice--\n"
						+ "* The search is case sensitive, so use all caps when searching for Canadian codes.\n"
						+ "* You may search through the latest generated codes as many times as needed,"
						+ "\n	however if new codes are generated or the main menu is accessed, the previous codes are deleted.\n"
						+ "* US postal codes come in groups of five numbers with no spaces or letters, "
						+ "\n	so when entering in a search query for US codes, do not put in any spaces or lettering.\n"
						+ "* Canadian postal codes come in groups of 6 characters with alternating numbers and letters (EX: A1B2C3), "
						+ "\n	so do not enter any spaces, and use the postal code's format when entering a search query.\n"
						+ "* You may search for as many or as little digets of the codes as you'd like, "
						+ "\n	the search engine will search for any code containing the search group.\n"
						+ "* You may generate as many codes as you would like, just remember that larger numbers of codes"
						+ "\n	mean longer calculation times and longer search times.\n"
						+ "* Any duplicate searched items will show up as seperate results\n");
				wait4Enter();//exits to main menu on enter press
			} else if (nationality == 4) {//quit program
				break BREAK_ALL;
			}else {//error catch
				System.out.println("\nThat was not a valid option, please try again.\n");
			}
		}
		System.out.print("\nShutting down...");//inform user that program is successfully shutting down
	}
	
	@SuppressWarnings("resource")
	public static void wait4Enter() {//new method
		Scanner s = new Scanner(System.in);//initialize scanner
		System.out.println("Press enter to exit back to main menu.");//prompt user
		s.nextLine();//read for any input including enter key
	}
}