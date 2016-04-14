package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(final String[] args) throws IOException {
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial variable");
		System.out.println(
				"====================================================================");
		PolynomialSolver omar = new PolynomialSolver();
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
				flag = true;
				System.out
						.println("Insert the variable name " + ": A , B or C");
				input.nextLine(); // clear buffer
				char poly1 = input.next(".").charAt(0); // reading char
				while (true) {
					try {
						omar.test(poly1, 'A');
						break;
					} catch (Exception e) {
						System.out.println("Enter a Valid Ploynomial");
						poly1 = input.next(".").charAt(0); // reading char
					}
				}

				System.out.println(
						"Insert the polynomial " + "terms in the form :");
				System.out.println("( coeff1 , exponent1 ) "
						+ ", ( coeff2 , exponent2 ) , ..");
				SinglyLinkedList terms = new SinglyLinkedList();
				input.nextLine(); // clear buffer
				String line = new String();
				line = input.nextLine();
				Scanner ali = new Scanner(line).useDelimiter("\\(|,|\\)|\\s");
				while (ali.hasNext()) {
					if (ali.hasNextInt()) {
						terms.add(ali.nextInt());
					} else {
						ali.next();
					}
				}
				/*
				 * coff and exp are in diff. node
				 */
				int[][] termsArray = new int[(terms.size() / 2)][2];
				int j = 0;
				for (int i = 0; i < termsArray.length; i++) {
					termsArray[i][0] = (int) terms.get(j);
					termsArray[i][1] = (int) terms.get(++j);
					++j;
				}
				omar.setPolynomial(poly1, termsArray);
				System.out.println("Polynomial " + poly1 + " is set");
				break;
			case 2:
				flag = true;
				System.out.println("Insert the variable name : A , B , C or R");
				input.nextLine(); // clear buffer

				char poly2 = input.next(".").charAt(0); // reading char
				while (true) {
					try {
						if( poly2 == 'R' ){
							break;
						}
						omar.test(poly2, 'A');
						break;
					} catch (Exception e) {
						System.out.println("Enter a Valid Ploynomial");
						poly2 = input.next(".").charAt(0); // reading char
					}
				}

				try {
					if (omar.print(poly2) == null) {
						System.out.println("Variable not set");
					} else {
						if (poly2 == 'R') {
							flag = false;
							System.out.println(
									"Value in R : " + omar.print(poly2));
						} else {
							System.out.println(omar.print(poly2));
						}
					}
				} catch (Exception e) {
					System.out.println("not valid polynomial");
				}
				break;
			case 3:
				char poly3;
				Boolean flag1 = true;
				do {
					System.out.println(
							"Insert first operand variable name : A , B or C");
					poly3 = input.next(".").charAt(0);
					while (true) {
						try {
							omar.test(poly3, 'A');
							break;
						} catch (Exception e) {
							System.out.println("Enter a Valid Ploynomial");
							poly3 = input.next(".").charAt(0); // reading char
						}
					}

					try { // checking first input validation
						if (omar.print(poly3) == null)
							System.out.println("Variable not set");
						else
							flag1 = false;
					} catch (Exception e) {
						System.out.println("not valid polynomial");
					}
				} while (flag1);

				System.out.println(
						"Insert second operand variable name : A , B or C");
				char poly4 = input.next(".").charAt(0);
				while (true) {
					try {
						omar.test(poly4, 'A');
						break;
					} catch (Exception e) {
						System.out.println("Enter a Valid Ploynomial");
						poly4 = input.next(".").charAt(0); // reading char
					}
				}
				try {
					int[][] r = omar.add(poly3, poly4);
					String o = new String("");
					for (int i = 0; i < r.length; i++) {
						o += "(" + r[i][0] + "," + r[i][1] + ")";
						if (i != r.length - 1) {
							o += ",";
						}
					}
					System.out.println("Result set in R : " + o);
				} catch (Exception e) {
					System.out.println("not valid polynomial");
				}
				break;
			case 4:
				char poly5;
				boolean flag2 = true;
				do {
					System.out.println(
							"Insert first operand variable name : A , B or C");
					poly5 = input.next(".").charAt(0);
					while (true) {
						try {
							omar.test(poly5, 'A');
							break;
						} catch (Exception e) {
							System.out.println("Enter a Valid Ploynomial");
							poly5 = input.next(".").charAt(0); // reading char
						}
					}
					try { // checking first input validation
						if (omar.print(poly5) == null)
							System.out.println("Variable not set");
						else
							flag2 = false;
					} catch (Exception e) {
						System.out.println("not valid polynomial");
					}
				} while (flag2);

				System.out.println(
						"Insert second operand variable name : A , B or C");
				char poly6 = input.next(".").charAt(0);
				while (true) {
					try {
						omar.test(poly6, 'A');
						break;
					} catch (Exception e) {
						System.out.println("Enter a Valid Ploynomial");
						poly6 = input.next(".").charAt(0); // reading char
					}
				}
				try {
					omar.subtract(poly5, poly6);
					System.out.println("Result set in R : " + omar.print('R'));
				} catch (Exception e) {
					System.out.println("not valid polynomial");
				}
				break;
			case 5:
				Boolean flag3 = true;
				char poly7;
				do {
					System.out.println(
							"Insert first operand variable name : A , B or C");
					poly7 = input.next(".").charAt(0);
					while (true) {
						try {
							omar.test(poly7, 'A');
							break;
						} catch (Exception e) {
							System.out.println("Enter a Valid Ploynomial");
							poly7 = input.next(".").charAt(0); // reading char
						}
					}
					try { // checking first input validation
						if (omar.print(poly7) == null)
							System.out.println("Variable not set");
						else
							flag3 = false;
					} catch (Exception e) {
						System.out.println("not valid polynomial");
					}
				} while (flag3);

				System.out.println(
						"Insert second operand variable name : A , B or C");
				char poly8 = input.next(".").charAt(0);
				while (true) {
					try {
						omar.test(poly8, 'A');
						break;
					} catch (Exception e) {
						System.out.println("Enter a Valid Ploynomial");
						poly8 = input.next(".").charAt(0); // reading char
					}
				}
				try {
					omar.multiply(poly7, poly8);
					System.out.println("Result set in R : " + omar.print('R'));
				} catch (Exception e) {
					System.out.println("not valid polynomial");
				}
				break;
			case 6:
				System.out.println("Insert the variable name : A , B , C or R");
				char poly9 = input.next(".").charAt(0);
				while (true) {
					try {
						omar.test(poly9, 'A');
						break;
					} catch (Exception e) {
						System.out.println("Enter a Valid Ploynomial");
						poly9 = input.next(".").charAt(0); // reading char
					}
				}
				System.out.println("Enter a value");
				float value;
				while (true) {
					try {
						value = input.nextFloat();
						break;
					} catch (Exception exception) {
						System.out.println("not a Valid value");
						input.nextLine();
					}
				}
				try {
					System.out.println(omar.evaluatePolynomial(poly9, value));
				} catch (Exception e) {
					System.out.println("Polynomial is not set");
				}
				break;
			case 7:
				System.out.println("Insert the variable name : A , B , C or R");
				char poly10 = input.next(".").charAt(0);
				while (true) {
					try {
						omar.clearPolynomial(poly10);
						break;
					} catch (Exception e) {
						System.out.println("not valid polynomial");
						poly10 = input.next(".").charAt(0);
					}
				}
				
				break;
			default:
				break;
			}
			if (flag == true) {
				System.out.println(
						"====================================================================");
				System.out.println("Please choose an action");
				System.out.println("1 - Set a polynomial variable , ... etc");
				System.out.println(
						"====================================================================");
			}
		}
	}

}
