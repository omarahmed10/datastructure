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
		Scanner omar = new Scanner(expression).useDelimiter("\\s*");
		StringBuilder infix = new StringBuilder();
		while (omar.hasNext()) {
			if (omar.hasNextInt()) {
				System.out.println("done1");
				infix.append(omar.nextInt());
				System.out.println(infix);
			}
			String c = omar.next();
			System.out.println(c.charAt(0));
			if (c.charAt(0) == '(' || c.charAt(0) == '*' || c.charAt(0) == '-'
					|| c.charAt(0) == '+' || c.charAt(0) == '/') {
				System.out.println("done");
				exp.push(c);
//				System.out.println(omar.next());
			} else if (c.charAt(0) == ')') {
				while (exp.size() > 0 && !exp.peek().equals('(')) {
					infix.append(exp.pop());
				}
				if (exp.peek().equals('(')) {
					infix.append(exp.pop());
				} else {
					throw new RuntimeException();
				}
			}
		}
		return null;
	}

	@Override
	public final int evaluate(final String expression) {
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
		float answer = (float) exp.pop();
		return (int) answer;
	}

	/**
	 * 
	 * @param args
	 *            *************
	 */
	public static void main(final String[] args) {
		Evaluator i = new Evaluator();
		i.evaluate("66 22 / 33 - 44 22 * +");
		i.infixToPostfix("(2+4)/(3*2)*(2-1)");
	}

}
