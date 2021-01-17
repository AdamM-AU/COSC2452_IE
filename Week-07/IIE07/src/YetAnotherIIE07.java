import java.util.Scanner;  // Import the Scanner class

public class YetAnotherIIE07 {
	// GUI Only
	private GTerm guiGT;
	private String guiInput;
	
	// Console Only 
	private Scanner consoleScanner = new Scanner(System.in);
	private String consoleInput = "";
	
	// Commonly Shared.
	private int interfaceMode; // Store interface mode for joint functions
	
	private String[] seq_chars; //Sequence of Characters 
	private char[] sngl_char; // Single Character 
	private int[] whole_number; // Whole Number
	private double[] decimal; // Number with this.decimals
	private boolean[] TF; // Boolean (True or False)
	
	private int arraySize; // arraySize of array
	private int counter; // How many time have we added content
	private int loop_count; // Loop counter for refresh_table
	
	private String columns = "String\tCHAR\tINT\tDOUBLE\tBOOLEAN"; // Table Columns
	private int tableIndex; // Table Index Tracking
	
	
	public YetAnotherIIE07(int userInterfaceMode) {
		// Initialize arrays
		this.arraySize = 0;
		this.seq_chars = new String[this.arraySize];
		this.sngl_char = new char[this.arraySize];
		this.whole_number = new int[this.arraySize];
		this.decimal = new double[this.arraySize];
		this.TF = new boolean[this.arraySize];
		
		if (userInterfaceMode == 1) { // 1 = Do GTerm Stuff
			this.interfaceMode = 1; // Set Class Global to GUI Mode
			
			this.guiGT = new GTerm(710, 400);
			this.guiGT.println("YetAnotherLameIIE07"); // Print this then move to next line
			this.guiGT.println("---------------"); // Print this then move to next line
			this.guiGT.println(""); // Give me a blank line / Print this then move to next line
			
			this.tableIndex = this.guiGT.addTable(700, 200, columns); // Create Table and Column Names
			this.guiGT.println(""); // Give me a blank line / Print this then move to next line
			this.guiGT.addButton("Add", this, "addRecord");
			
		} else if (userInterfaceMode == 0) { // 0 = Do Console Stuff
			this.interfaceMode = 0; // Set Class Global to Console Mode
			
			System.out.println("YetAnotherLameIIE06"); // Print this then move to next line
			System.out.println("---------------"); // Print this then move to next line
			
			while (!this.consoleInput.equals("exit") || this.consoleInput.equals("add") ) {
				System.out.println("\nCommands: add, exit\n"); // Give me a blank line / Print this then move to next line
				this.consoleInput = this.consoleScanner.nextLine();
				
				if (this.consoleInput.equals("add")) {
					addRecord();
				}
			}
		} else {
			// Error Invalid InterfaceMode
		    // We will just end the program now...
		}
	}
	
	// Joint method
	public void refreshTable() {
		if (this.interfaceMode == 1) { // InterfaceMode is GUI
			// Wipe current table rows
			this.guiGT.clearRowsOfTable(this.tableIndex);
			
			// Dump the data arrays provided to table
			this.loop_count=0;
			while (this.seq_chars.length > this.loop_count) {
				this.guiGT.addRowToTable(this.tableIndex, 
									  this.seq_chars[this.loop_count] + "\t" + 
									  this.sngl_char[this.loop_count] + "\t" + 
									  this.whole_number[this.loop_count] + "\t" + 
									  this.decimal[this.loop_count] + "\t" + 
									  this.TF[this.loop_count]);
				this.loop_count++;
			}
		} else if (this.interfaceMode == 0) { // InterfaceMode is Console
			// Wipe current table rows
			System.out.println(columns);
			
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
		} else {
			// Error Should never get here... 
		}
	}
	
	// Joint Method
	public void addRecord() {
		// Temp Arrays
		String[] temp_seq_chars = new String[this.seq_chars.length + 1]; //Sequence of Characters 
		char[] temp_sngl_char = new char[this.sngl_char.length + 1]; // Single Character 
		int[] temp_whole_number = new int[this.whole_number.length + 1]; // Whole Number
		double[] temp_decimal = new double[this.decimal.length + 1];// Number with this.decimals
		boolean[] temp_TF = new boolean[this.TF.length + 1]; // Boolean (True or False)		
		
		this.counter = 0;
		while (this.counter < this.seq_chars.length) {
			// Copy old arrays to temp arrays
			temp_seq_chars[this.counter] = this.seq_chars[this.counter]; // Copy old array to temp array
			temp_sngl_char[this.counter] = this.sngl_char[this.counter]; // Copy old array to temp array
			temp_whole_number[this.counter] = this.whole_number[this.counter]; // Copy old array to temp array
			temp_decimal[this.counter] = this.decimal[this.counter]; // Copy old array to temp array
			temp_TF[this.counter] = this.TF[this.counter]; // Copy old array to temp array
			this.counter++;
		}
		
		this.seq_chars = temp_seq_chars; // replace old array with new array
		this.sngl_char = temp_sngl_char; // replace old array with new array
		this.whole_number = temp_whole_number; // replace old array with new array
		this.decimal = temp_decimal; // replace old array with new array
		this.TF = temp_TF; // replace old array with new array
		
		String[] split = new String[4]; // Initialize array with size of 4 (0 - 4)
		
		if (this.interfaceMode == 1) {  // InterfaceMode is GUI
			this.guiInput = this.guiGT.getInputString("ROW: String; Char; Int; Double; Boolean");
			split = this.guiInput.split(";");
			
			// Make sure we got all 5 inputs
			while (split.length < 4) {
				this.guiInput = this.guiGT.getInputString("Error: ROW: String; Char; Int; Double; Boolean");
				split = this.guiInput.split(";");			
			}
			
		} else if (this.interfaceMode == 0) {  // InterfaceMode is GUI
			System.out.println("ROW: String; Char; Int; Double; Boolean\n");
			this.consoleInput = consoleScanner.nextLine();
			split = this.consoleInput.split(";");
			
			// Make sure we got all 5 inputs
			while (split.length < 4) {
				System.out.println("Error: ROW: String; Char; Int; Double; Boolean\n");
				this.consoleInput = this.consoleScanner.nextLine();
				split = this.consoleInput.split(";");	
			}
		} else {
			// Error Should never get here...
		}

		this.seq_chars[counter] = split[0];
		this.sngl_char[counter] = split[1].charAt(0);
		this.whole_number[counter] = Integer.parseInt(split[2]);
		this.decimal[counter] = Double.parseDouble(split[3]);
		this.TF[counter] = Boolean.parseBoolean(split[4]);
		
		this.arraySize++;
		refreshTable(); // Run this method
	}	
	
	public static void main(String[] args) {
		YetAnotherIIE07 prmObj=new YetAnotherIIE07(1); // 0 = Console, 1 = GTerm/GUI
		 
	}
}
