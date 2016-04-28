package eg.edu.alexu.csd.datastructure.stack.cs47;

import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedList.cs47.PolynomialSolver;
import eg.edu.alexu.csd.datastructure.linkedList.cs47.SinglyLinkedList;

public class StackMain {

	public static void main(String[] args) {
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Push in the stack");
		System.out.println("2- pop from the stack");
		System.out.println("3- Peek from the stack");
		System.out.println("4- Get size of the stack");
		System.out.println("5- Check if Stack is empty");
		System.out.println("6- to finish");
		System.out.println("==============================="
				+ "=====================================");
		MyStack omar = new MyStack();
		Scanner input = new Scanner(System.in);
		Boolean flag = true;
		int action;
		while (flag) {
			while (true) {
				try {
					action = input.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Enter a Valid action");
					action = input.nextInt();
				}
			}
			switch (action) {
			case 1:
				System.out
						.println("What do you to be pushed in the stack");
				input.nextLine(); // clear buffer
				omar.push(input.nextLine());
				System.out.println(omar);
				break;
			case 2:
				omar.pop();
				System.out.println(omar);
				break;
			case 3:
				System.out.println(omar.peek());
				break;
			case 4:
				System.out.println(omar.size());
				break;
			case 5:
				System.out.println(omar.isEmpty());
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Choose a valid action");
				break;
			}
			if (flag == true) {
				System.out.println(
						"====================================================================");
				System.out.println("Please choose an action");
				System.out.println("1- Push in the stack, .........etc");
				System.out.println("6- to finsh");
				System.out.println(
						"====================================================================");
			}
		}
	}
}
