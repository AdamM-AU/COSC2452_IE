
public class FrontEndGTerm {
	private BackEnd backEnd; // private: for this class only
	private GTerm guiGT;
	private String guiInput;
	
	private String[] seq_chars; //Sequence of Characters 
	private char[] sngl_char; // Single Character 
	private int[] whole_number; // Whole Number
	private double[] decimal; // Number with this.decimals
	private boolean[] TF; // Boolean (True or False)
	
	private String columns = "String\tCHAR\tINT\tDOUBLE\tBOOLEAN"; // Table Columns
	private int tableIndex; // Table Index Tracking
	private int loop_count; // Loop counter for refresh_table
	
	public FrontEndGTerm(BackEnd backEnd) {
		this.backEnd = backEnd; // Store a local copy of backEnd
		
		this.guiGT = new GTerm(710, 400);
		this.guiGT.println(" YetAnotherLameIIE08"); // Print this then move to next line
		this.guiGT.println("---------------------"); // Print this then move to next line
		this.guiGT.println(""); // Give me a blank line / Print this then move to next line
		
		this.tableIndex = this.guiGT.addTable(700, 200, columns); // Create Table and Column Names
		this.guiGT.println(""); // Give me a blank line / Print this then move to next line
		this.guiGT.addButton("Add", this, "guiAddRecord");
		this.guiGT.addButton("Refresh", this, "guiRefreshTable");
		this.guiGT.addButton("Wipe Data", this, "guiWipe");
	}
	
	public void guiRefreshTable() {
		// Wipe current table rows
		this.guiGT.clearRowsOfTable(this.tableIndex);
		
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
			this.guiGT.addRowToTable(this.tableIndex, 
								  this.seq_chars[this.loop_count] + "\t" + 
								  this.sngl_char[this.loop_count] + "\t" + 
								  this.whole_number[this.loop_count] + "\t" + 
								  this.decimal[this.loop_count] + "\t" + 
								  this.TF[this.loop_count]);
			this.loop_count++;
		}
	}
	
	public void guiAddRecord() {
		String[] split = new String[5]; // Initialize array with size of 5 (0 - 4)
		this.guiInput = this.guiGT.getInputString("ROW: String; Char; Int; Double; Boolean");
		split = this.guiInput.split(";");
		
		// Make sure we got all 5 inputs
		while (split.length < 4) {
			this.guiInput = this.guiGT.getInputString("Error: ROW: String; Char; Int; Double; Boolean");
			split = this.guiInput.split(";");			
		}
		
		// Send to backEnd
		this.backEnd.addInputs(split);
		this.guiRefreshTable();
	}
	
	public void guiWipe() {
		this.backEnd.wipeData();
		this.guiRefreshTable();
	}
}
