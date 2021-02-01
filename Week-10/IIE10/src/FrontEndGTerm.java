
public class FrontEndGTerm {
	private BackEnd backEnd; // private: for this class only
	private GTerm guiGT;
	private String guiInput;
	
	private Data[] dataOutput; // Temp Storage for garbageOut (backend.getInputs());
	
	private String columns = "String\tCHAR\tINT\tDOUBLE\tBOOLEAN"; // Table Columns
	private int tableIndex; // Table Index Tracking
	private int loop_count; // Loop counter for refresh_table
	
	public FrontEndGTerm(BackEnd backEnd) {
		this.backEnd = backEnd; // Store a local copy of backEnd
		
		this.guiGT = new GTerm(710, 400);
		this.guiGT.println(" YetAnotherLousyIIE10"); // Print this then move to next line
		this.guiGT.println("----------------------"); // Print this then move to next line
		this.guiGT.println(""); // Give me a blank line / Print this then move to next line
		
		this.tableIndex = this.guiGT.addTable(700, 200, columns); // Create Table and Column Names
		this.guiGT.println(""); // Give me a blank line / Print this then move to next line
		this.guiGT.addButton("Add", this, "guiAddRecord");
		this.guiGT.addButton("Refresh", this, "guiRefreshTable");
		this.guiGT.addButton("Wipe Data", this, "guiWipe");
		this.guiGT.addButton("Import CSV", this, "guiImportCSV");
		this.guiRefreshTable(); // Refresh Table on window load
	}
	
	public void guiImportCSV() {
		String filepath = this.guiGT.getFilePath(); // Open File Dialog and store selected files path
		this.backEnd.loadCSV(filepath);
		this.guiRefreshTable(); // Refresh the table
	}
	
	public void guiRefreshTable() {
		// Wipe current table rows
		this.guiGT.clearRowsOfTable(this.tableIndex);
		
		// Fetch Data from backend
		dataOutput = this.backEnd.getInputs();

		// Dump the data arrays provided to table
		this.loop_count=0;
		while (this.dataOutput.length > this.loop_count) {
			Data currentOBJ = this.dataOutput[this.loop_count];
			this.guiGT.addRowToTable(this.tableIndex, 
								  currentOBJ.getSeq_chars() + "\t" + 
								  currentOBJ.getSngl_char() + "\t" + 
								  currentOBJ.getWhole_number() + "\t" + 
								  currentOBJ.getDecimal() + "\t" + 
								  currentOBJ.isTF());
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
