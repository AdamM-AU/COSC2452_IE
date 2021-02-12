
public class Application {
	private BackEnd backEnd;
	private FrontEndGTerm uiGT;
	private FrontEndConsole uiConsole;
	
	public Application(String onStartCSV) {
		this.backEnd = new BackEnd(onStartCSV);
		this.uiGT = new FrontEndGTerm(this.backEnd);
		this.uiConsole = new FrontEndConsole(this.backEnd);
	}

	public static void main(String[] args) {
		String onStartCSV;
		
		// Process Run Time Arguments, if none supplied set default
		if (args != null && args.length > 0) {
			onStartCSV = args[0];
		} else {
			onStartCSV = "onstart.csv";
		}
		Application app = new Application(onStartCSV);
	}
}