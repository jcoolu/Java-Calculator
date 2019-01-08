import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class KeypadListeners {

	private KeypadListeners() {
	}

	// ********************************************************************
	// Represents the action listener for the numeric keys.
	// ********************************************************************

	// -----------------------------------------------------------------
	// Appends the key value to the display.
	// -----------------------------------------------------------------
	public static void addKeyListener(ActionEvent event) {
		JButton source = (JButton) event.getSource();// gets source of
														// button clicked
		// calls getText() to display text of button and
		CalculatorKeypadPanel.getDisplayLabel()
				.setText(CalculatorKeypadPanel.getDisplayLabel().getText() + source.getText());
	}

	// ********************************************************************
	// Represents the action listener for the clear button.
	// ********************************************************************
	public static void clearListener(ActionEvent event) {
		// -----------------------------------------------------------------
		// Clears the display.
		// -----------------------------------------------------------------
		CalculatorKeypadPanel.getDisplayLabel().setText("");// sets text of
															// displayLabel to
															// ""
		CalculatorKeypadPanel.setFirstNum(0);
	}

	public static void signListener(ActionEvent event) {
		double number = Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText());
		number = number - (number * 2);
		CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(number));
	}

	public static void addListener(ActionEvent event) {
		CalculatorKeypadPanel.setState("add");
		CalculatorKeypadPanel.setFirstNum(Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText()));
		CalculatorKeypadPanel.getDisplayLabel().setText("");
		System.out.println("First Num:" + CalculatorKeypadPanel.getFirstNum());
	}

	public static void subtractListener(ActionEvent event) {
		CalculatorKeypadPanel.setState("subtract");
		CalculatorKeypadPanel.setFirstNum(Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText()));
		CalculatorKeypadPanel.getDisplayLabel().setText("");
	}

	public static void multiplyListener(ActionEvent event) {
		CalculatorKeypadPanel.setState("multiply");
		CalculatorKeypadPanel.setFirstNum(Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText()));
		CalculatorKeypadPanel.getDisplayLabel().setText("");
	}

	public static void divideListener(ActionEvent event) {
		CalculatorKeypadPanel.setState("divide");
		CalculatorKeypadPanel.setFirstNum(Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText()));
		CalculatorKeypadPanel.getDisplayLabel().setText("");
	}

	public static void percentListener(ActionEvent event) {
		CalculatorKeypadPanel.setFirstNum(Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText()) / 100);
		CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(CalculatorKeypadPanel.getFirstNum()));
	}

	public static void rootListener(ActionEvent event) {
		CalculatorKeypadPanel
				.setFirstNum(Math.sqrt(Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText())));
		CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(CalculatorKeypadPanel.getFirstNum()));
	}

	public static void squareListener(ActionEvent event) {
		CalculatorKeypadPanel
				.setFirstNum(Math.pow(Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText()), 2.0));
		CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(CalculatorKeypadPanel.getFirstNum()));
	}

	public static void reciprocalListener(ActionEvent event) {
		CalculatorKeypadPanel.setFirstNum(1 / Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText()));
		CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(CalculatorKeypadPanel.getFirstNum()));
	}

	public static void piListener(ActionEvent event) {
		CalculatorKeypadPanel.setFirstNum(Math.PI);
		CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(CalculatorKeypadPanel.getFirstNum()));
	}

	public static void decimalListener() {
		String number = CalculatorKeypadPanel.getDisplayLabel().getText().concat(".");
		CalculatorKeypadPanel.getDisplayLabel().setText(number);
		CalculatorKeypadPanel.setFirstNum(Double.parseDouble(number));
	}

	public static void deleteListener(ActionEvent event) {

		if (CalculatorKeypadPanel.getDisplayLabel().getText().length() == 1) {
			CalculatorKeypadPanel.setFirstNum(0);
			CalculatorKeypadPanel.getDisplayLabel().setText("");
		} else if (CalculatorKeypadPanel.getDisplayLabel().getText().length() > 1) {
			String number = CalculatorKeypadPanel.getDisplayLabel().getText().substring(0,
					CalculatorKeypadPanel.getDisplayLabel().getText().length() - 1);
			int intnumber = (int) Double.parseDouble(number);
			CalculatorKeypadPanel.setFirstNum(intnumber);
			CalculatorKeypadPanel.getDisplayLabel().setText(Integer.toString(intnumber));
		} else {
			CalculatorKeypadPanel.getDisplayLabel().setText("");
		}

	}

	public static void modListener(ActionEvent event) {
		CalculatorKeypadPanel.setState("mod");
		CalculatorKeypadPanel.setFirstNum(Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText()));
		CalculatorKeypadPanel.getDisplayLabel().setText("");
	}

	public static void equalListener(ActionEvent event) {
		double finalAnswer;
		if (CalculatorKeypadPanel.getState().equals("add")) {
			finalAnswer = CalculatorKeypadPanel.getFirstNum()
					+ Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText());
			CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(finalAnswer));
			CalculatorKeypadPanel.setFirstNum(finalAnswer);
		}
		if (CalculatorKeypadPanel.getState().equals("subtract")) {
			finalAnswer = CalculatorKeypadPanel.getFirstNum()
					- Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText());
			CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(finalAnswer));
			CalculatorKeypadPanel.setFirstNum(finalAnswer);
		}
		if (CalculatorKeypadPanel.getState().equals("multiply")) {
			finalAnswer = CalculatorKeypadPanel.getFirstNum()
					* Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText());
			CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(finalAnswer));
			CalculatorKeypadPanel.setFirstNum(finalAnswer);
		}
		if (CalculatorKeypadPanel.getState().equals("divide")) {
			finalAnswer = CalculatorKeypadPanel.getFirstNum()
					/ Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText());
			CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(finalAnswer));
			CalculatorKeypadPanel.setFirstNum(finalAnswer);
		}

		if (CalculatorKeypadPanel.getState().equals("mod")) {
			finalAnswer = CalculatorKeypadPanel.getFirstNum()
					% Double.parseDouble(CalculatorKeypadPanel.getDisplayLabel().getText());
			CalculatorKeypadPanel.getDisplayLabel().setText(Double.toString(finalAnswer));
			CalculatorKeypadPanel.setFirstNum(finalAnswer);
		}
		CalculatorKeypadPanel.setState("");
	}
}
