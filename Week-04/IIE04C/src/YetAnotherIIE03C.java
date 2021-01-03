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
			
			// Loop Requesting Correct Input FOREVER
			while (seq_chars_input.isEmpty() && seq_chars_input.length() < 2) {
				System.out.println("INVALID INPUT:: Please Enter Your Full Name:");  // Print This Text  
				seq_chars_input = scanner.nextLine(); // Grab the user input
			}
			seq_chars = seq_chars_input; // Set Variable to content of this variable
			
			// Input 2 - Single Character 
			System.out.println("Pick a letter from A - D:");  // Print This Text  
			String sngl_char_input = scanner.nextLine(); // Grab the user input
			sngl_char_input = sngl_char_input.toLowerCase(); // Convert input to lower-case
			
			// Loop Requesting Correct Input FOREVER
			while (!sngl_char_input.matches("a|b|c|d")) {
				System.out.println("INVALID INPUT:: Pick a letter from A - D:");  // Print This Text
				sngl_char_input = scanner.nextLine(); // Grab the user input
				sngl_char_input = sngl_char_input.toLowerCase(); // Convert input to lower-case
			}
			sngl_char = sngl_char_input.charAt(0); // Set Variable to the char at position 0 of this variable (Conversion: String to char)
			
			// Input 3 - Whole Number
			System.out.println("Pick a Number between 1 - 4");  // Print This Text  
			String whole_number_input = scanner.nextLine(); // Grab the user input
			
			// Loop Requesting Correct Input FOREVER
			while (!whole_number_input.matches("^[0-9]+$") || !whole_number_input.matches("1|2|3|4")) { // Check to ensure numeric values only (REGEX) AND Matches 1 - 4
				System.out.println("INVALID INPUT:: Pick a Number between 1 - 4");  // Print This Text  
				whole_number_input = scanner.nextLine(); // Grab the user input			
			}
			whole_number = Integer.parseInt(whole_number_input); // Set Variable to contents of this variable with conversion (Interger.parseInt)
						
			// Input 4 - Number with a decimal point
			System.out.println("Enter any number with 2 decimal places:");  // Print This Text  
			String decimal_input = scanner.nextLine(); // Grab the user input

			// Loop Requesting Correct Input FOREVER
			while (!decimal_input.matches("^\\d+\\.\\d+")) { // Check if input string is decimal (REGEX)
				System.out.println("INVALID INPUT:: Enter any number with 2 decimal places:");  // Print This Text  
				decimal_input = scanner.nextLine(); // Grab the user input
			}
			decimal =  Double.parseDouble(decimal_input);
			
			
			// Input 5 - Boolean Question
			System.out.println("Did this IIE Suck? (Yes/No)");  // Print This Text  
			String TF_input = scanner.nextLine(); // Grab the user input
			
			while (!TF_input.matches("yes|true|y|t|no|false|f|n")) {
				System.out.println("INVALID INPUT:: Did this IIE Suck? (Yes/No)");  // Print This Text  
				TF_input = scanner.nextLine(); // Grab the user input
				TF_input = TF_input.toLowerCase(); // Convert input to lower-case
			}
			
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
