import java.util.Random; // I want this to select an option for the user if no input is supplied

public class YetAnotherIIE03 {
	public static void main(String[] args) {
		GTerm gt = new GTerm(600, 400);
		// Declare & Initializing variables
		String seq_chars = null; //Sequence of Characters
		char sngl_char = 0; // Single Character 
		int whole_number = 0; // Whole Number
		double decimal = 0; // Number with decimals
		boolean TF = false; // Boolean (True or False)
		
		gt.println("YetAnotherIIE03"); // Print this then move to next line
		gt.println("---------------"); // Print this then move to next line
		gt.println(""); // Give me a blank line / Print this then move to next line
		String input_count = gt.getInputString("How many runs: (numbers only)");  // Ask the User how many times they want to play :)
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
			// GTerm Input Requests //
			// Input 1 - Sequence of Characters
			String seq_chars_input = gt.getInputString("Please Enter Your Full Name:");  // Fetch User input and stuff it into a variable  
			if (!seq_chars_input.isEmpty() && seq_chars_input.length() > 1) { // Check if returned data is empty or null
				// User supplied input 
				seq_chars = seq_chars_input; // Set Variable to content of this variable 
			} else {
				int count = 0;
				while (count != 3) { // Loop 3 times MAX requesting correct input
						count++; // Increment counter
						seq_chars_input = gt.getInputString("INVALID INPUT:: Please Enter Your Full Name:");  // Fetch User input and stuff it into a variable
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
			String sngl_char_input = gt.getInputString("Pick a letter from A - D:"); // Fetch User input and stuff it into a variable
			sngl_char_input = sngl_char_input.toLowerCase(); // Convert input to lower-case
			
			if (sngl_char_input.matches("a|b|c|d")) { // Check for match between a - d
				sngl_char = sngl_char_input.charAt(0); // Set Variable to the char at position 0 of this variable (Conversion: String to char)
			} else {
				int count = 0;
				while (count !=3) { // Loop 3 times MAX requesting correct input
					count++; // Increment counter
					// Invalid Input
					sngl_char_input = gt.getInputString("INVALID INPUT:: Pick a letter from A - D:"); // Fetch User input and stuff it into a variable
					sngl_char_input = sngl_char_input.toLowerCase(); // Convert input to lower-case
					
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
			String whole_number_input = gt.getInputString("Pick a Number between 1 - 4");  // Fetch User input and stuff it into a variable
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
			String decimal_input = gt.getInputString("Enter any number with 2 decimal places:");  // Fetch User input and stuff it into a variable
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
			String TF_input = gt.getInputString("Did this IIE Suck? (Yes/No)");  // Fetch User input and stuff it into a variable
			TF_input = TF_input.toLowerCase(); // Convert input to lower-case
			if (TF_input.matches("yes|true|y|t")) {
				TF = true;
			} else {
				// Consider all other options as a false
				TF = false;
			}
			
			// Dump the data provided to user to screen
			gt.println("User Provided Information"); // Print this then move to next line
			gt.println("-------------------------"); // Print this then move to next line
			gt.println("Sequence of Charecters [String] :: " + seq_chars); // Print this + variable then move to next line
			gt.println("        Single Charecter [char] :: " + sngl_char); // Print this + variable then move to next line
			gt.println("             Whole Number [int] :: " + whole_number);  // Print this + variable then move to next line
			gt.println("   Number with Decimal [double] :: " + decimal);  // Print this + variable then move to next line
			gt.println("           True/False [boolean] :: " + TF);  // Print this + variable then move to next line
			gt.println(""); // Give me a blank line / Print this then move to next line
		}
		gt.println(""); // Give me a blank line / Print this then move to next line
		gt.println("Thanks For Playing!"); // Print this then move to next line
	}
}
