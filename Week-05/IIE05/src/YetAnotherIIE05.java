public class YetAnotherIIE05 {
	public static void main(String[] args) {
		GTerm gt = new GTerm(710, 400);
		
		gt.println("YetAnotherIIE05"); // Print this then move to next line
		gt.println("---------------"); // Print this then move to next line
		gt.println(""); // Give me a blank line / Print this then move to next line
		gt.addTable(700, 200, "String\tCHAR\tINT\tDOUBLE\tBOOLEAN"); // Create Table and Column Names
		
		String input_count = gt.getInputString("How many runs: (numbers only)");  // Ask the User how many times they want to play :)
		int round_count;
		if (input_count.matches("^[0-9]+$")) {
			round_count = Integer.parseInt(input_count);
		} else {
			// Bad Input, run once
			round_count = 1;
		}
		
		// Declare & Initializing variables

		String[] seq_chars; //Sequence of Characters 
		char[] sngl_char; // Single Character 
		int[] whole_number; // Whole Number
		double[] decimal; // Number with decimals
		boolean[] TF; // Boolean (True or False)

		// Here I am using 'round_count' specified by the user to create the array sizes
		seq_chars = new String[round_count];
		sngl_char = new char[round_count];
		whole_number = new int[round_count];
		decimal = new double[round_count];
		TF = new boolean[round_count];
		
		
		int run_count = 0;
		while (run_count != round_count) {
			// GTerm Input Requests //
			// Input 1 - Sequence of Characters
			String seq_chars_input = gt.getInputString("Please Enter Your Full Name:");  // Fetch User input and stuff it into a variable  

			// Loop Requesting Correct Input FOREVER
			while (seq_chars_input.isEmpty() && seq_chars_input.length() < 2) { 
				seq_chars_input = gt.getInputString("INVALID INPUT:: Please Enter Your Full Name:");  // Fetch User input and stuff it into a variable
			}
			
			seq_chars[run_count] = seq_chars_input; // Set Variable to content of this variable
	
			// Input 2 - Single Character 
			String sngl_char_input = gt.getInputString("Pick a letter from A - D:"); // Fetch User input and stuff it into a variable
			sngl_char_input = sngl_char_input.toLowerCase(); // Convert input to lower-case
			
			// Loop Requesting Correct Input FOREVER			
			while (!sngl_char_input.matches("a|b|c|d")) {
				sngl_char_input = gt.getInputString("INVALID INPUT:: Pick a letter from A - D:"); // Fetch User input and stuff it into a variable
				sngl_char_input = sngl_char_input.toLowerCase(); // Convert input to lower-case
			}
			sngl_char[run_count] = sngl_char_input.charAt(0); // Set Variable to the char at position 0 of this variable (Conversion: String to char)
	
			
			// Input 3 - Whole Number
			String whole_number_input = gt.getInputString("Pick a Number between 1 - 4");  // Fetch User input and stuff it into a variable

			// Loop Requesting Correct Input FOREVER
			while (!whole_number_input.matches("^[0-9]+$") || !whole_number_input.matches("1|2|3|4")) { // Check to ensure numeric values only (REGEX) AND Matches 1 - 4
				whole_number_input = gt.getInputString("INVALID INPUT:: Pick a Number between 1 - 4");  // Fetch User input and stuff it into a variable
			}
			// User Supplied Numeric input
			whole_number[run_count] = Integer.parseInt(whole_number_input); // Set Variable to contents of this variable with conversion (Interger.parseInt)			

			// Input 4 - Number with a decimal point
			String decimal_input = gt.getInputString("Enter any number with 2 decimal places:");  // Fetch User input and stuff it into a variable

			// Loop Requesting Correct Input FOREVER
			while (!decimal_input.matches("^\\d+\\.\\d+")) { // Check if input string is decimal (REGEX)
				decimal_input = gt.getInputString("INVALID INPUT:: Enter any number with 2 decimal places:");  // Fetch User input and stuff it into a variable
			} 
			// User Supplied Decimal input
			decimal[run_count] =  Double.parseDouble(decimal_input);			
			
			// Input 5 - Boolean Question
			String TF_input = gt.getInputString("Did this IIE Suck? (Yes/No)");  // Fetch User input and stuff it into a variable
			TF_input = TF_input.toLowerCase(); // Convert input to lower-case
			
			while (!TF_input.matches("yes|true|y|t|no|false|f|n")) {
				TF_input = gt.getInputString("INVALID INPUT:: Did this IIE Suck? (Yes/No)");  // Fetch User input and stuff it into a variable
				TF_input = TF_input.toLowerCase(); // Convert input to lower-case
			}
			
			if (TF_input.matches("yes|true|y|t")) {
				TF[run_count] = true;
			} else {
				// Consider all other options as a false
				TF[run_count] = false;
			}
			run_count++;
		}

		// Dump the data arrays provided to table
		int loop_count = 0;
		while (round_count > loop_count) {
			gt.addRowToTable(0, seq_chars[loop_count] + "\t" + sngl_char[loop_count] + "\t" + whole_number[loop_count] + "\t" + decimal[loop_count] + "\t" + TF[loop_count]);
			loop_count++;
		}
		
		gt.println(""); // Give me a blank line / Print this then move to next line
		gt.println("Thanks For Playing!"); // Print this then move to next line
	}
}
