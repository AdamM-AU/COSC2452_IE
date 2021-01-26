
public class BackEnd {
	private String[] seq_chars; //Sequence of Characters 
	private char[] sngl_char; // Single Character 
	private int[] whole_number; // Whole Number
	private double[] decimal; // Number with this.decimals
	private boolean[] TF; // Boolean (True or False)
	
	private int arraySize; // Size of arrays
	private int counter; // How many time have we added content
	
	public BackEnd() {
		// Initialize arrays
		this.arraySize = 0;
		this.seq_chars = new String[this.arraySize];
		this.sngl_char = new char[this.arraySize];
		this.whole_number = new int[this.arraySize];
		this.decimal = new double[this.arraySize];
		this.TF = new boolean[this.arraySize];
		
	}
	
	public void growArray() {
		this.arraySize = this.seq_chars.length; // Increment ArraySize
		
		// Temp Arrays
		String[] temp_seq_chars = new String[this.arraySize + 1]; //Sequence of Characters 
		char[] temp_sngl_char = new char[this.arraySize + 1]; // Single Character 
		int[] temp_whole_number = new int[this.arraySize + 1]; // Whole Number
		double[] temp_decimal = new double[this.arraySize + 1];// Number with this.decimals
		boolean[] temp_TF = new boolean[this.arraySize + 1]; // Boolean (True or False)		
		
		this.counter = 0;
		while (this.counter < this.arraySize) {
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
	}
	
	// Return an Object array containing all input arrays 
	// this allows us to keep all array data types intact
	public Object[] getInputs() {
		Object[] inputs = new Object[5]; // An array with size of 5 as we have 5 storage arrays

		// Now we make a Multidimensional Object array
		// To Explain: inputs[A][B] A = First Dimension, B = Second Dimension
		// Populate Second Dimension arrays with all our data arrays
		inputs[0] = this.seq_chars;
		inputs[1] = this.sngl_char;
		inputs[2] = this.whole_number;
		inputs[3] = this.decimal;
		inputs[4] = this.TF;
		
		return inputs; // Return Multidimensional array
	}
	
	public void addInputs(String[] inputs) {
		growArray(); // Increase storage array size and set this.counter and increment this.arraySize
		
		// Copy and type convert inputs[]
		this.seq_chars[this.counter] = inputs[0];
		this.sngl_char[this.counter] = inputs[1].charAt(0);
		this.whole_number[this.counter] = Integer.parseInt(inputs[2]);
		this.decimal[this.counter] = Double.parseDouble(inputs[3]);
		this.TF[this.counter] = Boolean.parseBoolean(inputs[4]);
		
	}
	
	// Wipe Datas
	public void wipeData() {
		// Wipe all arrays
		this.seq_chars = new String[0];
		this.sngl_char = new char[0];
		this.whole_number = new int[0];
		this.decimal = new double[0];
		this.TF = new boolean[0];
		
		// reset variables
		this.counter = 0;
		this.arraySize = 0;
	}
}
