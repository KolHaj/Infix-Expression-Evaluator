package InfixEE;

/**
* File: Infix_Evaluation.java
* Author: Kolger Hajati
* Date: January 20, 2019
* Purpose: holds infix expression evaluation
*/

import java.util.Stack;

public class Infix_Evaluation {
	public static int evaluate(String valueInput) {

		//Removes the whitespace using trim
		String valueInputT = valueInput.trim() ;

		//Stack values and Stack operators separately
		Stack<Integer> operand = new Stack<>();
		Stack<Character> operator = new Stack<>();

		//Tokenize the string
		char[] inputTok = valueInputT.toCharArray();

		//While loop checking token length
		int index = 0;
		while (index < inputTok.length) {

			//Values are pushed to operator
			if (MethodActions.operandCheck(String.valueOf(inputTok[index])) == true ) {
				StringBuffer combineInt = new StringBuffer();

				//There may be more than one digits in number
				while (index < inputTok.length && MethodActions.operandCheck(String.valueOf(inputTok[index])) == true)
					combineInt.append(inputTok[index++]);
				index--;
				operand.push((int) Integer.parseInt(combineInt.toString()));
			}
			//Operand is pushed
			else if (inputTok[index] == '(')
				operator.push(inputTok[index]);

			//Handles closing brace and pops the operators and operand to calculation method
			else if (inputTok[index] == ')') {
				while (operator.peek() != '(')
					operand.push(MethodActions.calculation(operator.pop(), operand.pop(), operand.pop()));
				operator.pop();
			}
			//Handles operators if the token is operator
			else if (MethodActions.operatorCheck(String.valueOf(inputTok[index])) == true) {
				while (!operator.empty() && MethodActions.operatorOrder(inputTok[index], operator.peek()))
					operand.push(MethodActions.calculation(operator.pop(), operand.pop(), operand.pop()));

				//The token is pushed to operator stack.
				operator.push(inputTok[index]);
			}
			index++;
		}
		//Pushes towards the method calculation when operator is empty
		while (!operator.empty())
			operand.push(MethodActions.calculation(operator.pop(), operand.pop(), operand.pop()));
		return operand.pop();
	}
}
