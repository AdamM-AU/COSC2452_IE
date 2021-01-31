
public class BackEnd {
	private Data[] data; // Data Array using Data Class 
	
	private int arraySize; // Size of arrays
	private int counter; // How many time have we added content
	
	public BackEnd() {
		// Initialize arrays
		this.arraySize = 0;
		this.data = new Data[this.arraySize];
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
