import java.util.Scanner;  // Import the Scanner class
import java.util.Random; // I want this to select an option for the user if no input is supplied

public class YetAnotherIIE03C {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Declare & Initializing variables
		String seq_chars = null; //Sequence of Characters
		char sngl_char = 0; // Single Character 
		int whole_number = 0; // Whole Number
		double decimal = 0; // Number with decimals
		boolean TF = false; // Boolean (True or False)
		
		System.out.println("YetAnotherIIE03"); // Print this then move to next line
		System.out.println("---------------"); // Print this then move to next line
		System.out.println(""); // Give me a blank line / Print this then move to next line

		System.out.println("How many runs: (numbers only)"); // Print This Text
		String input_count = scanner.nextLine(); // Grab the user input
		
		int round_count;
		if (input_count.matches("^[0-9]+$")) {
			round_count = Integer.parseInt(input_count);
		} else {
			// Bad Input, run once
			round_count = 1;
		}
		
		int run_count = 0;
		while (run_count != round_count) {
			run_count++;
			// Input Requests //
			// Input 1 - Sequence of Characters
			System.out.println("Please Enter Your Full Name:");  // Print This Text  
			String seq_chars_input = scanner.nextLine(); // Grab the user input
			
			if (!seq_chars_input.isEmpty() && seq_chars_input.length() > 1) { // Check if returned data is empty or null
				// User supplied input 
				seq_chars = seq_chars_input; // Set Variable to content of this variable 
			} else {
				int count = 0;
				while (count != 3) { // Loop 3 times MAX requesting correct input
						count++; // Increment counter
						System.out.println("INVALID INPUT:: Please Enter Your Full Name:");  // Print This Text  
						seq_chars_input = scanner.nextLine(); // Grab the user input
						
					if (!seq_chars_input.isEmpty() && seq_chars_input.length() > 1) {
						// User supplied input 
						seq_chars = seq_chars_input; // Set Variable to content of this variable
						break; //Break away from the loop
					} else {
						// User did not give us a name after 3 attempts
						seq_chars = "John Citizen"; // Set Variable to this
					}
				}
			}
	
			// Input 2 - Single Character 
			System.out.println("Pick a letter from A - D:");  // Print This Text  
			String sngl_char_input = scanner.nextLine(); // Grab the user input
			
			sngl_char_input = sngl_char_input.toLowerCase(); // Convert input to lower-case
			
			if (sngl_char_input.matches("a|b|c|d")) { // Check for match between a - d
				sngl_char = sngl_char_input.charAt(0); // Set Variable to the char at position 0 of this variable (Conversion: String to char)
			} else {
				int count = 0;
				while (count !=3) { // Loop 3 times MAX requesting correct input
					count++; // Increment counter
					// Invalid Input
					System.out.println("INVALID INPUT:: Pick a letter from A - D:");  // Print This Text  
					sngl_char_input = scanner.nextLine(); // Grab the user input
					
					if (sngl_char_input.matches("a|b|c|d")) { // Check for match between a - d
						sngl_char = sngl_char_input.charAt(0); // Set Variable to the char at position 0 of this variable (Conversion: String to char)
						break; //Break away from the loop
					} else {
						// User did not give us the expected input A,B,C or D after 3 attempts 
						// Pick Random Value
						String options = "abcd"; // Options we have available
						Random rand = new Random(); //Initialize Class Object Random
						sngl_char = options.charAt(rand.nextInt(options.length()));
					}
				}
			}
			
			// Input 3 - Whole Number
			System.out.println("Pick a Number between 1 - 4");  // Print This Text  
			String whole_number_input = scanner.nextLine(); // Grab the user input
			
			if (whole_number_input.matches("^[0-9]+$") && whole_number_input.matches("1|2|3|4")) { // Check to ensure numeric values only (REGEX) AND Matches 1 - 4
				// User Supplied Numeric input
				whole_number = Integer.parseInt(whole_number_input); // Set Variable to contents of this variable with conversion (Interger.parseInt) 
			} else {
				// Bad User input - probably got a non numerical value or nothing at all
				// Pick Random Value
				Random rand = new Random(); //Initialize Class Object Random
				int intBoundary = 6; // Random Int Boundary (Cannot be hit this number or higher) 
				whole_number = rand.nextInt(intBoundary); // Select Random int taking into account boundary and set variable
			}
			
			// Input 4 - Number with a decimal point
			System.out.println("Enter any number with 2 decimal places:");  // Print This Text  
			String decimal_input = scanner.nextLine(); // Grab the user input
			
			if (decimal_input.matches("^\\d+\\.\\d+")) { // Check if input string is decimal (REGEX)
				// User Supplied Decimal input
				decimal =  Double.parseDouble(decimal_input);
			} else {
				// Bad User input
				// Pick Random Value
				Random rand = new Random(); //Initialize Class Object Random 
				decimal = rand.nextDouble() * 100; // Select Random Double then multiply that by 100
			}
			
			// Input 5 - Boolean Question
			System.out.println("Did this IIE Suck? (Yes/No)");  // Print This Text  
			String TF_input = scanner.nextLine(); // Grab the user input
			
			TF_input = TF_input.toLowerCase(); // Convert input to lower-case
			if (TF_input.matches("yes|true|y|t")) {
				TF = true;
			} else {
				// Consider all other options as a false
				TF = false;
			}
			
			// Dump the data provided to user to screen
			System.out.println("User Provided Information"); // Print this then move to next line
			System.out.println("-------------------------"); // Print this then move to next line
			System.out.println("Sequence of Charecters [String] :: " + seq_chars); // Print this + variable then move to next line
			System.out.println("        Single Charecter [char] :: " + sngl_char); // Print this + variable then move to next line
			System.out.println("             Whole Number [int] :: " + whole_number);  // Print this + variable then move to next line
			System.out.println("   Number with Decimal [double] :: " + decimal);  // Print this + variable then move to next line
			System.out.println("           True/False [boolean] :: " + TF);  // Print this + variable then move to next line
			System.out.println(""); // Give me a blank line / Print this then move to next line
		}
		System.out.println(""); // Give me a blank line / Print this then move to next line
		System.out.println("Thanks For Playing!"); // Print this then move to next line
	}
}
