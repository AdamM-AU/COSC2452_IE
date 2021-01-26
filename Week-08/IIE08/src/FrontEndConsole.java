import java.util.Scanner;  // Import the Scanner class

public class FrontEndConsole {
	private BackEnd backEnd; // private: for this class only
	private Scanner consoleScanner = new Scanner(System.in);
	private String consoleInput = "";
	
	private String[] seq_chars; //Sequence of Characters 
	private char[] sngl_char; // Single Character 
	private int[] whole_number; // Whole Number
	private double[] decimal; // Number with this.decimals
	private boolean[] TF; // Boolean (True or False)
	
	private String columns = "String\tCHAR\tINT\tDOUBLE\tBOOLEAN"; // Table Columns
	private int loop_count; // Loop counter for refresh_table
	
	public FrontEndConsole(BackEnd backEnd) {
		this.backEnd = backEnd; // Store a local copy of backEnd
		
		System.out.println("YetAnotherLameIIE06"); // Print this then move to next line
		System.out.println("---------------"); // Print this then move to next line
		
		while (!this.consoleInput.equals("exit") || this.consoleInput.equals("add")  || this.consoleInput.equals("refresh") || this.consoleInput.equals("wipe")) {
			System.out.println("\nCommands: refresh, wipe, add, exit\n"); // Give me a blank line / Print this then move to next line
			this.consoleInput = this.consoleScanner.nextLine();
			
			if (this.consoleInput.equals("add")) {
				this.consoleAddRecord();
				this.consoleRefreshTable();
			}
			
			if (this.consoleInput.equals("refresh")) {
				this.consoleRefreshTable();
			}
			
			if (this.consoleInput.equals("wipe")) {
				this.backEnd.wipeData();
				this.consoleRefreshTable();
			}
		}
	}
	
	public void consoleRefreshTable() {
		// Wipe current table rows
		System.out.println(columns);
		
		// Fetch Data from backend
		Object[] tempInputs = new Object[5][];
		tempInputs = this.backEnd.getInputs(); // Returns a multidimensional array
		// To Explain: inputs[A][B] A = First Dimension, B = Second Dimension

		// Process Data
		seq_chars = (String[]) tempInputs[0]; // Type Cast as string array and store in string array seq_chars
		sngl_char = (char[]) tempInputs[1]; // Type Cast as char array and store in string array sngl_char
		whole_number = (int[]) tempInputs[2]; // Type Cast as int array and store in string array whole_number
		decimal = (double[]) tempInputs[3]; // Type Cast as double array and store in string array decimal
		TF = (boolean[]) tempInputs[4]; // Type Cast as boolean array and store in string array TF		
		
		// Dump the data arrays provided to table
		this.loop_count=0;
		while (this.seq_chars.length > this.loop_count) {
			System.out.println(this.seq_chars[this.loop_count] + "\t" + 
							   this.sngl_char[this.loop_count] + "\t" + 
							   this.whole_number[this.loop_count] + "\t" + 
							   this.decimal[this.loop_count] + "\t" + 
							   this.TF[this.loop_count]+"");
			this.loop_count++;
		}
	}
	
	public void consoleAddRecord() {
		String[] split = new String[4]; // Initialize array with size of 4 (0 - 4)
		
		System.out.println("ROW: String; Char; Int; Double; Boolean\n");
		this.consoleInput = consoleScanner.nextLine();
		split = this.consoleInput.split(";");
		
		// Make sure we got all 5 inputs
		while (split.length < 4) {
			System.out.println("Error: ROW: String; Char; Int; Double; Boolean\n");
			this.consoleInput = this.consoleScanner.nextLine();
			split = this.consoleInput.split(";");	
		}
		this.backEnd.addInputs(split);
		
	}
}
