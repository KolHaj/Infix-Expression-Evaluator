package InfixEE;

/**
* File: MethodActions.java
* Author: Kolger Hajati
* Date: January 20, 2019
* Purpose: The file holds methods and action listener
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import javax.swing.JOptionPane;

//Action event which takes in input and string input
public class MethodActions implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		
		try {
			//Inputs the string text from the GUI
			String textID = GUIDisplay.inputText.getText();
			int result = Infix_Evaluation.evaluate(textID);
			
			//Returns the results and sets in the GUI text
			String resultExit = String.valueOf(result);
			GUIDisplay.resultText.setText(resultExit);
		}
		catch (EmptyStackException ex) {
			JOptionPane.showMessageDialog(null, "Please enter a integer!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch (ArithmeticException ex) {
			JOptionPane.showMessageDialog(null, "You cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//Method to handle precedence
	public static boolean operatorOrder(char operatorA, char operatorB)  {
		if (operatorB == '(' || operatorB == ')')
			return false;
		else if ((operatorA == '*' || operatorA == '/') && (operatorB == '+' || operatorB == '-'))
			return false;
		else
			return true;
	}
	//Method to calculate the operators calculation with operand
	public static int calculation(char operator, int b, int a) throws ArithmeticException{
		
			if (operator == '+') {
				return a + b;
			}
			else if (operator == '-') {
				return a - b;
			}
			else if (operator == '*') {
				return a * b;
			}
			else if (operator == '/') {
				return a / b;
			}
			return a;
			}
	//Checks the string if it is an operator
	public static boolean operatorCheck (String operatorInput) {
		if (operatorInput.matches("[\\+\\-\\*\\/]")) {
			return true;
		} else {
			return false;
		}
	}
	//The method parses a string to an integer
	public static boolean operandCheck(String operandInput) {
		try {
			Integer.parseInt(operandInput);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
}