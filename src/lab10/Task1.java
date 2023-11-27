package lab10;

import java.util.Arrays;
import java.util.Stack;

public class Task1 {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> stack = new Stack<>();
		for (E e : array) {
			stack.push(e);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}
	// This method checks the correctness of the

	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (char ch : input.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (ch == ')' || ch == ']' || ch == '}') {
				if (stack.isEmpty() || !check(stack.peek(), ch)) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();

	}

	private static boolean check(char a, char b) {
		if (a == '(' && b == ')')
			return true;
		else if (a == '{' && b == '}')
			return true;
		else if (a == '[' && b == ']')
			return true;
		else
			return false;
	}

	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			// Ignore whitespace
			if (ch == ' ') {
				continue;
			}

			if (Character.isDigit(ch)) {
				// Extract the operand
				int operand = 0;
				while (i < expression.length() && Character.isDigit(ch)) {
					operand = operand * 10 + (ch - '0');
					i++;
					if (i < expression.length()) {
						ch = expression.charAt(i);
					}
				}
				i--;

				operandStack.push(operand);
			} else if (ch == '(') {
				// Push the open parenthesis onto the operator stack
				operatorStack.push(ch);
			} else if (ch == ')') {
				// Evaluate the expression within the parentheses
				while (operatorStack.peek() != '(') {
					int result = applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop());
					operandStack.push(result);
				}
				operatorStack.pop(); // Pop the open parenthesis
			} else if (isOperator(ch)) {
				// Process operators
				while (!operatorStack.empty() && operatorPrecedence(operatorStack.peek()) >= operatorPrecedence(ch)) {
					int result = applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop());
					operandStack.push(result);
				}
				operatorStack.push(ch);
			}
		}

		while (!operatorStack.empty()) {
			int result = applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop());
			operandStack.push(result);
		}

		return operandStack.pop();
	}

	private static int operatorPrecedence(char operator) {
		if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		}
		return 0;
	}

	private static int applyOperator(char operator, int operand2, int operand1) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		}
		throw new IllegalArgumentException("Invalid operator: " + operator);
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

}
