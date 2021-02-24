
public class FrontEndGTerm {
	private BackEnd backEnd; // private: for this class only
	private GTerm guiGT;
	private String guiInput;
	private int targetRow;
	
	private Data[] dataOutput; // Temp Storage for garbageOut (backend.getInputs());
	
	private String columns = "String\tCHAR\tINT\tDOUBLE\tBOOLEAN"; // Table Columns
	private int tableIndex; // Table Index Tracking
	private int loop_count; // Loop counter for refresh_table
	
	public FrontEndGTerm(BackEnd backEnd) {
		this.backEnd = backEnd; // Store a local copy of backEnd
		
		this.guiGT = new GTerm(710, 400);
		this.guiGT.println(" YetAnotherLousyIIE12"); // Print this then move to next line
		this.guiGT.println("----------------------"); // Print this then move to next line
		this.guiGT.println(""); // Give me a blank line / Print this then move to next line
		
		this.tableIndex = this.guiGT.addTable(700, 200, columns); // Create Table and Column Names
		this.guiGT.println(""); // Give me a blank line / Print this then move to next line
		this.guiGT.addButton("Change User", this, "guiUserSelection");
		this.guiGT.addButton("Edit", this, "guiModRecord");
		this.guiGT.addButton("Refresh", this, "guiRefreshTable");
		this.guiGT.addButton("Save", this, "guiSave");

		this.guiUserSelection(); // Set current user
	}	
	
	public void guiUserSelection() {
		this.guiInput = this.guiGT.getInputString("Username:");
		
		while (this.guiInput == null || this.guiInput.isEmpty()) { 
			this.guiInput = this.guiGT.getInputString("ERROR: Username:");
		}
		targetRow = this.backEnd.findUser(this.guiInput.toLowerCase());
		this.targetRow = targetRow;
		
		this.guiRefreshTable(); // Refresh Table with new data
	}
	
	public void guiRefreshTable() {
		// Wipe current table rows
		this.guiGT.clearRowsOfTable(this.tableIndex);
		
		// Delete Data from backend
		this.backEnd.wipeData();
		
		// Reload CSV database
		this.backEnd.loadCSV("");
		
		// Fetch Data from backend
		dataOutput = this.backEnd.getInputs();

		// Dump the data arrays provided to table
		Data currentOBJ = this.dataOutput[this.targetRow];
		this.guiGT.addRowToTable(this.tableIndex, 
							  currentOBJ.getSeq_chars() + "\t" + 
							  currentOBJ.getSngl_char() + "\t" + 
							  currentOBJ.getWhole_number() + "\t" + 
							  currentOBJ.getDecimal() + "\t" + 
							  currentOBJ.isTF());
	}
	
	public void guiModRecord() {
		String[] split = new String[4]; // Initialize array with size of 4 (0 - 4)
		this.guiInput = this.guiGT.getInputString("ROW: Char; Int; Double; Boolean");
		split = this.guiInput.split(";");
		
		// Make sure we got all 4 inputs
		while (split.length < 3) {
			this.guiInput = this.guiGT.getInputString("Error: ROW: Char; Int; Double; Boolean");
			split = this.guiInput.split(";");
		}
		
		// Send to backEnd
		this.backEnd.modInputs(split);
		this.guiRefreshTable();
	}
	
	public void guiSave() {
		this.backEnd.writeCSV("");
		this.guiRefreshTable();
	}
}
