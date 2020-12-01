public class PleaseRenameMe {
	public static void main(String[] args) {
		GTerm gt = new GTerm(600, 400);
		gt.print("Hello ");
		String userInput = gt.getInputString("Who are you?");
		gt.println(userInput + "!");
		gt.showHelp();
	}
}
