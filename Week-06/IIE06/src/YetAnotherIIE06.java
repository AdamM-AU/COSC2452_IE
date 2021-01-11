public class YetAnotherIIE06 {
	private GTerm gt;
	private String[] seq_chars; //Sequence of Characters 
	private char[] sngl_char; // Single Character 
	private int[] whole_number; // Whole Number
	private double[] decimal; // Number with this.decimals
	private boolean[] TF; // Boolean (True or False)
	
	private int arraySize; // arraySize of array
	private int counter; // How many time have we added content
	private int loop_count; // Loop counter for refresh_table
	
	private String columns = "String\tCHAR\tINT\tDOUBLE\tBOOLEAN";
	private int tableIndex;
	
	public YetAnotherIIE06() {
		this.gt = new GTerm(710, 400);
		this.gt.println("YetAnotherIIE06"); // Print this then move to next line
		this.gt.println("---------------"); // Print this then move to next line
		this.gt.println(""); // Give me a blank line / Print this then move to next line
		
		this.tableIndex = this.gt.addTable(700, 200, columns); // Create Table and Column Names
		this.gt.println(""); // Give me a blank line / Print this then move to next line
		this.gt.addButton("Add", this, "addRecord");


		this.arraySize = 0;
		this.seq_chars = new String[arraySize];
		this.sngl_char = new char[arraySize];
		this.whole_number = new int[arraySize];
		this.decimal = new double[arraySize];
		this.TF = new boolean[arraySize];
	}

	public void refreshTable() {
		// Wipe current table rows
		this.gt.clearRowsOfTable(this.tableIndex);
		
		// Dump the data arrays provided to table
		while (this.counter > this.loop_count) {
			this.gt.addRowToTable(this.tableIndex, 
								  this.seq_chars[this.loop_count] + "\t" + 
								  this.sngl_char[this.loop_count] + "\t" + 
								  this.whole_number[this.loop_count] + "\t" + 
								  this.decimal[this.loop_count] + "\t" + 
								  this.TF[this.loop_count]);
			this.loop_count++;
		}
	}

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
			counter++;
		}
		this.seq_chars = temp_seq_chars; // replace old array with new array
		this.sngl_char = temp_sngl_char; // replace old array with new array
		this.whole_number = temp_whole_number; // replace old array with new array
		this.decimal = temp_decimal; // replace old array with new array
		this.TF = temp_TF; // replace old array with new array
		
		String user_input = this.gt.getInputString("ROW: String; Char; Int; Double; Boolean");
		String[] split = user_input.split(";");
		
		// Make sure we got all 5 inputs
		while (split.length < 4) {
			user_input = this.gt.getInputString("Error: ROW: String; Char; Int; Double; Boolean");	
		}
		
		this.seq_chars[counter] = split[0];
		this.sngl_char[counter] = split[1].charAt(0);
		this.whole_number[counter] = Integer.parseInt(split[2]);
		this.decimal[counter] = Double.parseDouble(split[3]);
		this.TF[counter] = Boolean.parseBoolean(split[4]);
		
		arraySize++;
		refreshTable(); // Run this method
	}
	
	public static void main(String[] args) {
		YetAnotherIIE06 prmObj=new YetAnotherIIE06();
	}
}
