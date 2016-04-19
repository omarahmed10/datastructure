package eg.edu.alexu.csd.datastructure.stack.cs47;

import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * 
 * @author omar_ahmed
 *
 */
public class Evaluator implements IExpressionEvaluator {
	private MyStack exp = new MyStack();

	@Override
	public final String infixToPostfix(final String expression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final int evaluate(final String expression) {
		Scanner omar = new Scanner(expression).useDelimiter("\\s");
		while (omar.hasNext()) {
			if (omar.hasNextInt()) {
				exp.push(omar.nextInt());
			} else {
				System.out.println(exp.peek());
				float x = (int) exp.pop();
				System.out.println(exp.peek());
				float y = (int) exp.pop();
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
				omar.next();
			}
		}
		return (int)exp.pop();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Evaluator i = new Evaluator();
		i.evaluate("66 22 / 33 - 44 22 * +");
	}

}
