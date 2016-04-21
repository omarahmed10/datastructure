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
		if (omar[omar.length - 1] == "-" || omar[omar.length - 1] == "*"
				|| omar[omar.length - 1] == "/"
				|| omar[omar.length - 1] == "+") {
			throw new RuntimeException();
		}
		StringBuilder infix = new StringBuilder();
		short i = 0;
		for (int j = 0; j < omar.length; j++) {
			boolean flag = false;
			if (omar[0] == "") {
				continue;
			}
			try {
				infix.append(Integer.parseInt(omar[j]));
				i = 0;
				flag = true;
			} catch (Exception e) {
				char p = omar[j].charAt(0);
				if (p == '-' || p == '+' && i < 2) {
					i++;
					while (exp.size() > 0 && !exp.peek().equals('(')) {
						infix.append(exp.pop() + " ");
					}
					exp.push(p);
				} else if ((p == '*' || p == '/') && i < 2) {
					i++;
					while (exp.size() > 0 && (exp.peek().equals('*')
							|| exp.peek().equals('/'))) {
						infix.append(exp.pop() + " ");
					}
					exp.push(p);
				} else if (p == '(') {
					i = 0;
					exp.push(p);
				} else if (p == ')') {
					i = 0;
					while (exp.size() > 0 && !exp.peek().equals('(')) {
						infix.append(exp.pop() + " ");
					}
					if (exp.size() > 0 && exp.peek().equals('(')) {
						exp.pop();
					} else { // there isn't an opening bracket wrong expression
						throw new RuntimeException();
					}
				} else {
					i = 0;
					flag = true;
					infix.append(p);
				}
			}
			if (flag) {
				infix.append(" ");
			}
			if (i >= 2) { // there is two operation like (* -) and thats
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
		System.out.println(infix);
		return infix.toString();
	}

	@Override
	public final int evaluate(final String expression) {
		String ali = expression.replaceAll("\\s+", "");
		if (ali.length() == 0) {
			throw new RuntimeException();
		}
		Scanner omar = new Scanner(expression).useDelimiter("\\s");
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
		// System.out.println(answer);
		return (int) answer;
	}

	/**
	 * 
	 * @param args
	 * 
	 */
	public static void main(final String[] args) {
		Evaluator i = new Evaluator();
		// i.evaluate("5 5 * 9 + +");
		i.infixToPostfix("9 * 8 * 2 -");
	}

}
