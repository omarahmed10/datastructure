package eg.edu.alexu.csd.datastructure.stack.cs47;

import java.util.Scanner;

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
		String ali = expression.replaceAll("\\s+", "");
		if (ali.length() == 0) {
			throw new RuntimeException();
		}
		String regex = "(?<=[-+*/()])|(?=[-+*/()])";
		String[] omar = ali.split(regex);
		StringBuilder infix = new StringBuilder();
		short noOperation = 0;
		for (int j = 0; j < omar.length; j++) {
			boolean printSpace = false;
			if (omar[j] == null || omar[j].isEmpty()) { // ignore it
				continue;
			}
			try {
				infix.append(Integer.parseInt(omar[j]));
				noOperation = 0;
				printSpace = true;
			} catch (Exception e) {
				char p = omar[j].charAt(0);
				if ((p == '-' || p == '+') && noOperation < 2) {
					if (infix.length() == 0) {
						throw new RuntimeException();
					}
					noOperation++;
					while (exp.size() > 0 && !exp.peek().equals('(')) {
						infix.append(exp.pop() + " ");
					}
					exp.push(p);
				} else if ((p == '*' || p == '/') && noOperation < 2) {
					if (infix.length() == 0) {
						throw new RuntimeException();
					}
					noOperation++;
					while (exp.size() > 0 && (exp.peek().equals('*')
							|| exp.peek().equals('/'))) {
						infix.append(exp.pop() + " ");
					}
					exp.push(p);
				} else if (p == '(') {
					noOperation = 0;
					exp.push(p);
				} else if (p == ')') {
					noOperation = 0;
					while (exp.size() > 0 && !exp.peek().equals('(')) {
						infix.append(exp.pop() + " ");
					}
					if (exp.size() > 0 && exp.peek().equals('(')) {
						exp.pop();
					} else { // there isn't an opening bracket wrong expression
						throw new RuntimeException();
					}
				} else {
					noOperation = 0;
					printSpace = true;
					infix.append(p);
				}
			}
			if (printSpace) {
				infix.append(" ");
			}
			if (noOperation >= 2) { // there is two operation like (* -) and
									// thats
				// wrong
				while (exp.size() > 0) { // clearing stack
					exp.pop();
				}
				throw new RuntimeException();
			}
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
		return infix.toString();
	}

	@Override
	public final int evaluate(final String expression) {
		if (expression.length() == 0) {
			throw new RuntimeException();
		}
		Scanner omar = new Scanner(expression)
				.useDelimiter("(?<=[-+*/()])|(?=[-+*/()])");
		while (omar.hasNext()) {
			if (omar.hasNextInt()) {
				exp.push((float) omar.nextInt());
			} else {
				float x = (float) exp.pop();
				float y = (float) exp.pop();
				switch (omar.next()) {
				case "/":
					exp.push(y / x);
					break;
				case "*":
					exp.push(x * y);
					break;
				case "+":
					exp.push(x + y);
					break;
				case "-":
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
		return (int) answer;
	}

	/**
	 * 
	 * @param args
	 * 
	 */
	public static void main(final String[] args) {
		Evaluator i = new Evaluator();
//		i.evaluate("80 -3 +");
//		 i.infixToPostfix("(8 - 1 + 3) * -6 - ((3 + 7) * 2 +)");
		// i.infixToPostfix("a + b * ( d - e ) + 58 / 30");
	}

}
