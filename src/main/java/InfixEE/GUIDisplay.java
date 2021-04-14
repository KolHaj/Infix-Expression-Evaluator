package InfixEE;

/**
* File: GUIDisplay.java
* Author: Kolger Hajati
* Date: January 20, 2019
* Purpose:This file holds GUI details for user menu
*/

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIDisplay extends JFrame {

	//Variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField inputText;
	public static JTextField resultText;
	private JButton inputButton;
	private JLabel inputLabel;
	private JLabel resultLabel;

	//Main and runs GUI
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDisplay frame = new GUIDisplay();
					frame.setVisible(true);
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "You cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public GUIDisplay() throws ArithmeticException{
		
		//Content Bounds
		setTitle("Infix Expression Evaluator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Evaluate Button
		inputButton = new JButton("Evaluate");
		inputButton.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		inputButton.setBounds(180, 60, 90, 30);
		contentPane.add(inputButton);
		
		//Input ID label
		inputLabel = new JLabel("Enter Infix Expression");
		inputLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		inputLabel.setBounds(30, 10, 150, 20);
		contentPane.add(inputLabel);
		
		//Result ID label
		resultLabel = new JLabel("Result");
		resultLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		resultLabel.setBounds(95, 110, 50, 20);
		contentPane.add(resultLabel);
		
		//Name text field
		inputText = new JTextField();
		inputText.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		inputText.setBounds(185, 10, 200, 20);
		contentPane.add(inputText);
		inputText.setColumns(10);
		
		//Result text field
		resultText = new JTextField();
		resultText.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		resultText.setBounds(145, 110, 200, 20);
		contentPane.add(resultText);
		resultText.setColumns(10);
		resultText.setEditable(false);
		
		//Action listener sent to MethodActions
		inputButton.addActionListener(new MethodActions());
		inputText.addActionListener(new MethodActions());
		resultText.addActionListener(new MethodActions());
	}
}
