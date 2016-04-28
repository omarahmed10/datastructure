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
		String ali = expression.replaceAll("\\s+", "");
		if (ali.length() == 0) {
			throw new RuntimeException();
		}
		String regex = "(?<=[-+*/()])|(?=[-+*/()])";
		String[] omar = ali.split(regex);
		StringBuilder infix = new StringBuilder();
		int noOperator = 0;
		int noOperand = 0;
		for (int j = 0; j < omar.length; j++) {
			boolean printSpace = false;
			if (omar[j] == null || omar[j].isEmpty()) { // ignore it
				continue;
			}
			try {
				infix.append(Integer.parseInt(omar[j]));
				noOperand++;
				printSpace = true;
			} catch (Exception e) {
				char p = omar[j].charAt(0);

				if (p == '-' || p == '+') {
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
					while (exp.size() > 0 && (exp.peek().equals('*')
							|| exp.peek().equals('/'))) {
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
		String regex = "\\s";
		String[] omar = expression.split(regex);
		for (int i = 0; i < omar.length; i++) {
			try {
				/*
				 * checking unary
				 */
				Integer.parseInt(omar[i]);
				if (i != omar.length - 1 && (omar[i].charAt(0) == '-'
						|| omar[i].charAt(0) == '+')) {
					throw new RuntimeException();
				} else {
					exp.push(Float.parseFloat(omar[i]));
				}
			} catch (Exception e) {
				float x = (float) exp.pop();
				float y = (float) exp.pop();
				switch (omar[i]) {
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
	public static void main(String[] args) {
//	    IExpressionEvaluator testMe = new Evaluator();
//	    StringBuilder string = new StringBuilder();
//	 
//	    for (int i = 0; i < 10000000; i++) {
//	        string = string.append("1+");
//	    }
//	    string = string.append("1");
//	    long start = System.currentTimeMillis();
//	    String ev = testMe.infixToPostfix(string.toString());
//	    long first = System.currentTimeMillis();
//	    testMe.evaluate(ev);
//	    long second = System.currentTimeMillis();
//	    System.out.println(first-start);
//	    System.out.println(second-first);
//	    System.out.println(second-start);
	    }

}
