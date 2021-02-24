import java.util.Scanner;  // Import the Scanner class

public class FrontEndConsole {
	private BackEnd backEnd; // private: for this class only
	private Scanner consoleScanner = new Scanner(System.in);
	private String consoleInput = "";
	private int targetRow;
	private String userName;
	
	private Data[] dataOutput; // Temp Storage for garbageOut (backend.getInputs());
	
	private String columns = "String\tCHAR\tINT\tDOUBLE\tBOOLEAN"; // Table Columns
	private int loop_count; // Loop counter for refresh_table
	
	public FrontEndConsole(BackEnd backEnd) {
		this.backEnd = backEnd; // Store a local copy of backEnd
		
		System.out.println(" YetAnotherLousyIIE12"); // Print this then move to next line
		System.out.println("----------------------"); // Print this then move to next line
		//this.consoleRefreshTable(); // Refresh Table on first load 
		while (this.userName == null || this.userName.isEmpty()) {
			System.out.println("Please enter username:");
			this.userName = this.consoleInput = this.consoleScanner.nextLine();
		}
		
		this.consoleUser(this.userName);
		
		while (!this.consoleInput.equals("exit") || this.consoleInput.equals("add")  || this.consoleInput.equals("refresh") || this.consoleInput.equals("wipe")) {
			System.out.println("\nCommands: user, edit, refresh, exit\n"); // Give me a blank line / Print this then move to next line
			this.consoleInput = this.consoleScanner.nextLine();
			
			if (this.consoleInput.equals("user")) {
				this.consoleUser("");
			}
			
			if (this.consoleInput.equals("refresh")) {
				this.consoleRefreshTable();
			}
			
			if (this.consoleInput.equals("edit")) {
				this.consoleModRecord();
				this.consoleRefreshTable();
				this.backEnd.writeCSV(""); // Save CSV
			}			

		}
	}
	
	public void consoleRefreshTable() {
		// Wipe current table rows
		System.out.println(columns);
		
		this.backEnd.wipeData();
		this.backEnd.loadCSV("");
		
		// Fetch Data from backend
		dataOutput = this.backEnd.getInputs();
		Data currentOBJ = this.dataOutput[this.targetRow];
		System.out.println(currentOBJ.getSeq_chars() + "\t" + 
				   currentOBJ.getSngl_char() + "\t" + 
				   currentOBJ.getWhole_number() + "\t" + 
				   currentOBJ.getDecimal() + "\t" + 
				   currentOBJ.isTF());
	}
	
	public void consoleModRecord() {
		String[] split = new String[3]; // Initialize array with size of 4 (0 - 4)
		
		System.out.println("ROW: Char; Int; Double; Boolean\n");
		this.consoleInput = consoleScanner.nextLine();
		split = this.consoleInput.split(";");
		
		// Make sure we got all 5 inputs
		while (split.length < 3) {
			System.out.println("Error: ROW: Char; Int; Double; Boolean\n");
			this.consoleInput = this.consoleScanner.nextLine();
			split = this.consoleInput.split(";");	
		}
		this.backEnd.modInputs(split);
		
	}
	
	public void consoleUser(String username) {
		int targetRow;
		if (username == null || username.isEmpty()) {
			System.out.println("Enter Username:\n");
			username = this.consoleScanner.nextLine();
		}
		
		targetRow = this.backEnd.findUser(username.toLowerCase());
		this.targetRow = targetRow;
		this.consoleRefreshTable();
	}
}
