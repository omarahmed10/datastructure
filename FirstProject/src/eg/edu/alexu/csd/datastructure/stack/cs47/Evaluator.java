package eg.edu.alexu.csd.datastructure.stack.cs47;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 *
 * @author omar_ahmed
 *
 */
public class Evaluator implements IExpressionEvaluator {
	/**
	 * 
	 */
	private MyStack exp = new MyStack();

	@Override
	public final String infixToPostfix(final String expression) {
		if (expression.length() == 0 || expression == null) {
			throw new RuntimeException();
		}
		StringBuilder infix = new StringBuilder();
		int noOperator = 0;
		int noOperand = 0;
		for (int j = 0; j < expression.length(); j++) {
			boolean printSpace = false;
			char p = expression.charAt(j);
			if (p == ' ') {
				continue;
			} else if (Character.isDigit(p)) {
				int number = 0;
				number = Character.getNumericValue(p);
				while (j < expression.length() - 1
						&& Character.isDigit(expression.charAt(j + 1))) {
					number = number * 10 + Character
							.getNumericValue(expression.charAt(j + 1));
					j++;
				}
				infix.append(Character.getNumericValue(p));
				noOperand++;
				printSpace = true;
			}

			else if (p == '-' || p == '+') {
				if (infix.length() == 0) {
					throw new RuntimeException();
				}
				noOperator++;
				while (exp.size() > 0 && !exp.peek().equals('(')) {
					infix.append(exp.pop() + " ");
				}
				exp.push(p);
			} else if (p == '*' || p == '/') {
				if (infix.length() == 0) {
					throw new RuntimeException();
				}
				noOperator++;
				while (exp.size() > 0
						&& (exp.peek().equals('*') || exp.peek().equals('/'))) {
					infix.append(exp.pop() + " ");
				}
				exp.push(p);
			} else if (p == '(') {
				exp.push(p);
			} else if (p == ')') {
				while (exp.size() > 0 && !exp.peek().equals('(')) {
					infix.append(exp.pop() + " ");
				}
				if (exp.size() > 0 && exp.peek().equals('(')) {
					exp.pop();
				} else { // there isn't an opening bracket wrong expression
					throw new RuntimeException();
				}
			} else {
				noOperand++;
				printSpace = true;
				infix.append(p);
			}
			if (printSpace) {
				infix.append(" ");
			}
		}
		if (noOperand != noOperator + 1) {
			while (exp.size() > 0) { // clearing stack
				exp.pop();
			}
			throw new RuntimeException();
		}
		while (exp.size() > 0 && !exp.peek().equals('(')) {
			infix.append(exp.pop());
			if (exp.size() != 0) {
				infix.append(" ");
			}
		}
		if (exp.size() > 0) {
			throw new RuntimeException();
		}
//		 System.out.println(infix);
		return infix.toString();
	}

	@Override
	public final int evaluate(final String expression) {
		if (expression.length() == 0) {
			throw new RuntimeException();
		}
		for (int i = 0; i < expression.length(); i++) {
			char p = expression.charAt(i);
			if (p == ' ') {
				continue;
			} else if (Character.isDigit(p)) {
				int number = 0;
				number = Character.getNumericValue(p);
				while (i < expression.length() - 1
						&& Character.isDigit(expression.charAt(i + 1))) {
					number = number * 10 + Character
							.getNumericValue(expression.charAt(i + 1));
					i++;
				}
				exp.push((float) number);
			} else {
				if (i < expression.length() - 1
						&& Character.isDigit(expression.charAt(i + 1))) {
					throw new RuntimeException();
				}
				float x = (float) exp.pop();
				float y = (float) exp.pop();
				switch (p) {
				case '/':
					exp.push(y / x);
					break;
				case '*':
					exp.push(x * y);
					break;
				case '+':
					exp.push(x + y);
					break;
				case '-':
					exp.push(y - x);
					break;
				default:
					throw new RuntimeException();
				}
			}
		}
		if (exp.size() > 1) {
			throw new RuntimeException();
		}
		float answer = (float) exp.pop();
//		 System.out.println(answer);
		return (int) answer;
	}

	/**
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
//		IExpressionEvaluator testMe = new Evaluator();
//		StringBuilder string = new StringBuilder();
//		testMe.evaluate("100 33 - 111 +");
//		testMe.infixToPostfix("(a / (b - c + d)) * (e - a) * c");
//		testMe.infixToPostfix("a/b-c+d*e-a*c");
//		for (int i = 0; i < 1000000; i++) {
//			string = string.append("1+");
//		}
//		string = string.append("1");
//		long start = System.currentTimeMillis();
//		String ev = testMe.infixToPostfix(string.toString());
//		long first = System.currentTimeMillis();
//		testMe.evaluate(ev);
//		long second = System.currentTimeMillis();
//		System.out.println(first - start);
//		System.out.println(second - first);
//		System.out.println(second - start);
	}

}
