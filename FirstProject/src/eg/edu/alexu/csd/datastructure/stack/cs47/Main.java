package eg.edu.alexu.csd.datastructure.stack.cs47;

import java.util.Scanner;
/**
 * Main class for testing Evaluator
 * @author omarahmed
 *
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String expression = new String();
		Scanner omar = new Scanner(System.in);
		Evaluator myClass = new Evaluator();
		System.out.println("enter a infix expression");
		expression = omar.nextLine();
		while (true) {
			try {
				String postfix = myClass.infixToPostfix(expression);
				int answer = myClass.evaluate(postfix);
				System.out.println(answer);
				break;
			} catch (Exception e) {
				System.out.println("Error : Wrong expression");
			}
		}

	}

}
