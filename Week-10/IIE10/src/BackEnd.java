import java.util.Scanner;  // Import the Scanner class
import java.io.File; // Import the File Class
import java.io.FileNotFoundException;

public class BackEnd {
	private Data[] data; // Data Array using Data Class 
	
	private int arraySize; // Size of arrays
	private int counter; // How many time have we added content
	
	private String onStartCSV; // Variable to hold the onStart CSV File
	
	public BackEnd(String onStartCSV) {
		// Initialize arrays
		this.arraySize = 0;
		this.data = new Data[this.arraySize];
		this.onStartCSV = onStartCSV; // Copy local variable to class global
		this.loadCSV(this.onStartCSV); // This method handles CSV's
		
	}
	
	/* This method handles CSV files containing data we wish to load into our data array
	 * I am using Scanner because the IIE doesn't specify and its honestly the most simplistic way,
	 * and as this unit is all about the basics it make sense Scanner would be preferred.
	 * 
	 * Alternatives: OpenCSV, Apache Commons CSV, etc are java class library dedicated to this task 
	 * and would be much more effective. 
	 */
	
	public void loadCSV(String filepath) {
	
		try {
			Scanner csv = new Scanner(new File(filepath)); // Read in file
			
			while (csv.hasNext()) { // Process the CSV line by line in a loop
				String csvRow = csv.next();
				String[] split = csvRow.split(",");
				this.addInputs(split);
				
			}
			csv.close(); // Close IO on filepath
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void growArray() {
		this.arraySize = this.data.length; // Increment ArraySize
		
		// Temp Arrays
		Data[] temp_data = new Data[this.arraySize + 1]; // Temp Data array +1 in size of data array 
		
		this.counter = 0;
		while (this.counter < this.arraySize) {
			// Copy old arrays to temp arrays
			temp_data[this.counter] = this.data[this.counter]; // Copy old array to temp array
			this.counter++;
		}
		
		this.data = temp_data; // replace old array with new array
	}
	
	// Return an Object array containing all input arrays 
	// this allows us to keep all array data types intact
	public Data[] getInputs() {
	
		return this.data; // Return Multidimensional array
	}
	
	public void addInputs(String[] inputs) {
		this.growArray(); // Increase storage array size and set this.counter and increment this.arraySize
		// Copy and type convert inputs[]
		this.data[this.counter] = new Data(inputs[0], 
										   inputs[1].charAt(0), 
										   Integer.parseInt(inputs[2]), 
										   Double.parseDouble(inputs[3]), 
										   Boolean.parseBoolean(inputs[4])); 
	}
	
	// Wipe Datas
	public void wipeData() {
		// Wipe all arrays
		this.data = new Data[0];
		
		// reset variables
		this.counter = 0;
		this.arraySize = 0;
	}
}

