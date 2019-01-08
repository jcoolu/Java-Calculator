import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Creates a panel that showcases numeric values when user clicks corresponding
 * button
 *
 * @author Jamie C
 * @version 1/6/2019
 */
@SuppressWarnings("serial")
public class CalculatorKeypadPanel extends JPanel {
	private static JPanel keyPanel;// creates JPanels for buttons
	private JPanel clearPanel;
	private static JTextArea displayLabel; // creates JLabel to display text
	private static String state = "";
	private static double firstNum = 0; // first number
	private static Font keypadText = new Font("Dialog Input", Font.PLAIN, 18);

	public CalculatorKeypadPanel() {
		// sets Border Layout for Panel
		setLayout(new BorderLayout());
		// sets color of background
		setBackground(Color.LIGHT_GRAY);
		// creates label that displays text at top
		displayLabel = new JTextArea(4, 10);
		displayLabel.setEditable(false);

		Font text = new Font("Dialog Input", Font.PLAIN, 30);
		displayLabel.setFont(text);

		// creates grid layout for keys
		keyPanel = new JPanel(new GridLayout(6, 4));

		// creates border layout for clear button
		clearPanel = new JPanel(new BorderLayout());

		// adding buttons
		setUpButton("%", new PercentListener());
		setUpButton("root", new RootListener());
		setUpButton("x^2", new SquareListener());
		setUpButton("1/x", new ReciprocalListener());
		setUpButton("7", new KeyListener());
		setUpButton("8", new KeyListener());
		setUpButton("9", new KeyListener());
		setUpButton("*", new MultiplyListener());
		setUpButton("4", new KeyListener());
		setUpButton("5", new KeyListener());
		setUpButton("6", new KeyListener());
		setUpButton("/", new DivideListener());
		setUpButton("1", new KeyListener());
		setUpButton("2", new KeyListener());
		setUpButton("3", new KeyListener());
		setUpButton("+", new AddListener());
		setUpButton(".", new DecimalListener());
		setUpButton("0", new KeyListener());
		setUpButton("+-", new SignListener());
		setUpButton("-", new SubtractListener());
		setUpButton("Clear", new ClearListener());
		setUpButton("<--", new DeleteListener());
		setUpButton("Pi", new PiListener());
		setUpButton("mod", new ModListener());

		JButton equal = new JButton("=");
		equal.setFont(keypadText);
		equal.addActionListener(new EqualListener());
		clearPanel.add(equal);

		// adds displayLabel to north of Border Layout
		add(displayLabel, BorderLayout.NORTH);
		// adds keyPanel to center of Border Layout
		add(keyPanel, BorderLayout.CENTER);
		// adds clearPanel to south of Border Layout
		add(clearPanel, BorderLayout.SOUTH);
	}

	/**
	 * This method sets up each button on keyPad of calc
	 * 
	 * @param sign
	 *            String symbol represented on each button
	 * @param obj
	 *            ActionListener
	 */
	public static void setUpButton(String sign, ActionListener obj) {
		JButton button = new JButton(sign);
		button.setFont(keypadText);
		button.addActionListener(obj);
		keyPanel.add(button);
	}

	// ********************************************************************
	// Represents the action listener for the numeric keys.
	// ********************************************************************
	private class KeyListener implements ActionListener {
		// -----------------------------------------------------------------
		// Appends the key value to the display.
		// -----------------------------------------------------------------
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.addKeyListener(event);
		}
	}

	// ********************************************************************
	// Represents the action listener for the clear button.
	// ********************************************************************
	private class ClearListener implements ActionListener {
		// -----------------------------------------------------------------
		// Clears the display.
		// -----------------------------------------------------------------
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.clearListener(event);
		}
	}

	private class SignListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			KeypadListeners.signListener(event);
		}
	}

	private class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.addListener(event);

		}
	}

	private class SubtractListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.subtractListener(event);
		}
	}

	private class MultiplyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.multiplyListener(event);
		}
	}

	private class DivideListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.divideListener(event);
		}
	}

	private class PercentListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.percentListener(event);
		}
	}

	private class RootListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.rootListener(event);
		}
	}

	private class SquareListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.squareListener(event);
		}
	}

	private class ReciprocalListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.reciprocalListener(event);
		}
	}

	private class PiListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.piListener(event);
		}
	}

	private class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.deleteListener(event);
		}
	}

	private class ModListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.modListener(event);
		}
	}

	private class DecimalListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.decimalListener();
		}
	}

	private class EqualListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			KeypadListeners.equalListener(event);
		}
	}

	public static JTextArea getDisplayLabel() {
		return displayLabel;
	}

	public static void setState(String st) {
		state = st;
	}

	public static String getState() {
		return state;
	}

	public static double getFirstNum() {
		return firstNum;
	}

	public static void setFirstNum(double finalAnswer) {
		CalculatorKeypadPanel.firstNum = finalAnswer;
	}
}
