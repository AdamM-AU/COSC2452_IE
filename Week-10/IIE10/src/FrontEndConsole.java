import java.util.Scanner;  // Import the Scanner class

public class FrontEndConsole {
	private BackEnd backEnd; // private: for this class only
	private Scanner consoleScanner = new Scanner(System.in);
	private String consoleInput = "";
	
	private Data[] dataOutput; // Temp Storage for garbageOut (backend.getInputs());
	
	private String columns = "String\tCHAR\tINT\tDOUBLE\tBOOLEAN"; // Table Columns
	private int loop_count; // Loop counter for refresh_table
	
	public FrontEndConsole(BackEnd backEnd) {
		this.backEnd = backEnd; // Store a local copy of backEnd
		
		System.out.println(" YetAnotherLousyIIE10"); // Print this then move to next line
		System.out.println("----------------------"); // Print this then move to next line
		this.consoleRefreshTable(); // Refresh Table on first load 
		
		while (!this.consoleInput.equals("exit") || this.consoleInput.equals("add")  || this.consoleInput.equals("refresh") || this.consoleInput.equals("wipe")) {
			System.out.println("\nCommands: refresh, wipe, add, import, exit\n"); // Give me a blank line / Print this then move to next line
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
			
			if (this.consoleInput.equals("import")) {
				this.consoleImportCSV();
				this.consoleRefreshTable();			}
		}
	}
	
	// Import a CSV File
	public void consoleImportCSV() {
		System.out.println("Please Enter Filepath to CSV: [usertest.csv]\n");
		this.consoleInput = consoleScanner.nextLine();
		while (this.consoleInput.isEmpty()) {
			System.out.println("Error: Please Enter Filepath to CSV: [usertest.csv]\n");
			this.consoleInput = consoleScanner.nextLine();
		}
		this.backEnd.loadCSV(this.consoleInput);
	}

	public void consoleRefreshTable() {
		// Wipe current table rows
		System.out.println(columns);
		
		// Fetch Data from backend
		dataOutput = this.backEnd.getInputs();
		
		// Dump the data arrays provided to table
		this.loop_count=0;
		while (this.dataOutput.length > this.loop_count) {
			Data currentOBJ = this.dataOutput[this.loop_count];
			System.out.println(currentOBJ.getSeq_chars() + "\t" + 
							   currentOBJ.getSngl_char() + "\t" + 
							   currentOBJ.getWhole_number() + "\t" + 
							   currentOBJ.getDecimal() + "\t" + 
							   currentOBJ.isTF());
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
