public class Data {
	private String seq_chars; //Sequence of Characters 
	private char sngl_char; // Single Character 
	private int whole_number; // Whole Number
	private double decimal; // Number with this.decimals
	private boolean TF; // Boolean (True or False)

	// Bulk Garbage In
	public Data(String seq_chars, char sngl_char, int whole_number, double decimal, boolean TF) {
		// Lousy Attempt at a lousy idea for a class
		this.setSeq_chars(seq_chars);
		this.setSngl_char(sngl_char);
		this.setWhole_number(whole_number);
		this.setDecimal(decimal);
		this.setTF(TF);
	}

	/** Generated Setters and Getters **/
	public String getSeq_chars() {
		return this.seq_chars;
	}

	public void setSeq_chars(String seq_chars) {
		this.seq_chars = seq_chars;
	}

	public char getSngl_char() {
		return this.sngl_char;
	}

	public void setSngl_char(char sngl_char) {
		this.sngl_char = sngl_char;
	}

	public int getWhole_number() {
		return this.whole_number;
	}

	public void setWhole_number(int whole_number) {
		this.whole_number = whole_number;
	}

	public double getDecimal() {
		return this.decimal;
	}

	public void setDecimal(double decimal) {
		this.decimal = decimal;
	}

	public boolean isTF() {
		return this.TF;
	}

	public void setTF(boolean tF) {
		this.TF = tF;
	}
}
