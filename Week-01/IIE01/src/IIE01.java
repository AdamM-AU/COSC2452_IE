public class IIE01 {
	public static void main(String[] args) {
		GTerm gt = new GTerm(650, 500); // Windows Dimensions 650 x 500
		// GTerm Settings
		gt.setXY(10, 10); // Change Placement of output within window
		gt.setFontSize(15); // Set output text font size
		gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
		gt.setBackgroundColor(0, 0, 0); // Set Background Color (RGB Value) (Black)
		// End - GTerm Settings

		gt.print("G'Day "); // print to current line
		String userInput = gt.getInputString("What is your name?"); // Input
		gt.println(userInput + "!");
		gt.println("Hope your having a good day."); // Print to current line and move to next line
		gt.println(""); // Adding a empty line in the output

		gt.print("I am "); // Print to current line
		gt.setFontColor(74, 246, 38); // Set Front Color (RGB) (Terminal Green)
		// print to current line
		gt.println("GTerm");
		gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)

		gt.println("------------------------------------------------"); // Just a simple divider to make things look
																		// better
		gt.showHelp();
		gt.setXY(420, 30); // //Change Placement of output within window
		gt.addImageIcon("src/hall.jpg"); // Print this image to window

		gt.setXY(10, 180); // //Change Placement of output within window
		gt.showMessageDialog("Can you share an image with me?"); // Show message in Dialog
		gt.addImageIcon(gt.getFilePath()); // Open File Open dialog for user to select image file, then print image to
											// screen
	}
}
