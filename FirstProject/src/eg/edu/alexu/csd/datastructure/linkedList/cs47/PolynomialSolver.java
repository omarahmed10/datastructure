/**
* Domain classes used to produce .....
* <p>
* These classes contain the ......
* </p>
*
* @since 1.0
* @author Omar Ahmed Mohamed
* @version 1.0
*/
package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 *
 * @author Ali-Metawea
 *
 */
public class PolynomialSolver implements IPolynomialSolver {
	/**
	 *
	 */
	private SinglyLinkedList multiVar = new SinglyLinkedList();
	/**
	 *
	 */
	private SinglyLinkedList a = new SinglyLinkedList();
	/**
	 *
	 */
	private SinglyLinkedList b = new SinglyLinkedList();
	/**
	 *
	 */
	private SinglyLinkedList c = new SinglyLinkedList();
	/**
	 *
	 */
	private SinglyLinkedList r = new SinglyLinkedList();
	private SinglyLinkedList l = new SinglyLinkedList();

	/**
	 * . Set polynomial terms (coefficients & exponents)
	 *
	 * @param poly
	 *            name of the polynomial
	 * @param terms
	 *            array of [coefficients][exponents]
	 */
	public final void setPolynomial(final char poly, final int[][] terms) {
		// String str="";
		// for (int i = 0; i < terms.length; i++) {
		// str+=terms[i][0]+" "+terms[i][1]+'\n';
		// }
		// throw new RuntimeException(str);
		for (int i = 0; i < terms.length - 1; i++) {
			if (terms[i][1] <= terms[i + 1][1]) {
				throw new RuntimeException();
			}
		}
		switch (poly) {
		case 'A':
			for (int i = 0; i < terms.length; i++) {
				if (terms[i][1] < 0) {
					throw new RuntimeException();
				}
				a.add(terms[i]);
			}

			break;

		case 'B':
			for (int i = 0; i < terms.length; i++) {
				if (terms[i][1] < 0) {
					throw new RuntimeException();
				}
				b.add(terms[i]);
			}
			break;

		case 'C':
			for (int i = 0; i < terms.length; i++) {
				if (terms[i][1] < 0) {
					throw new RuntimeException();
				}
				c.add(terms[i]);
			}
			break;
		case 'R':
			for (int i = 0; i < terms.length; i++) {
				if (terms[i][1] < 0) {
					throw new RuntimeException();
				}
				r.add(terms[i]);
			}
			break;

		default:
			throw new RuntimeException();
		}

	}

	/**
	 * . Print the polynomial in human readable representation
	 * 
	 * @param poly
	 *            name of the polynomial
	 * @return polynomial in the form like 27x^2+x-1
	 */
	public final String print(final char poly) {
		switch (poly) {
		case 'A':
			if (a.size() == 0) {
				return null;
			} else {
				return myPrintStyle(a);
			}
		case 'B':
			if (b.size() == 0) {
				return null;
			} else {
				return myPrintStyle(b);
			}
		case 'C':
			if (c.size() == 0)
				return null;
			else {
				return myPrintStyle(c);
			}
		case 'R':
			if (r.size() == 0)
				return null;
			else
				return myPrintStyle(r);
		default:
			throw new RuntimeException();
		}
	}

	public final String myPrintStyle(SinglyLinkedList z) {
		String tempStr = new String("");

		for (int i = 0; i < z.size(); i++) {
			int[] temp = (int[]) z.get(i);
			if (i == 0) {
				if (temp[0] == 0) {
					tempStr += 0;
				} else if (temp[0] == 1) {
					if (temp[1] == 1) {
						tempStr += "x";
					} else if (temp[1] == 0) {
						tempStr += "1";
					} // ex (1,0) = +1
					else {
						tempStr += "x^" + temp[1];
					} // ex (1,-5) = +x^-5
				} else if (temp[0] == -1) {
					if (temp[1] == 1)
						tempStr += "-x"; // ex (-1,1) = -x
					else if (temp[1] == 0)
						tempStr += "-1"; // ex (-1,0) = -1
					else
						tempStr += "-x^" + temp[1]; // ex (-1,5) = -x^5
				} else if (temp[1] == 0) {
					tempStr += temp[0]; // ex (5,0) = +5
				} else if (temp[1] == 1) {
					tempStr += temp[0] + "x"; // ex (-9,1) = -9x
				} else {
					tempStr += temp[0] + "x^" + temp[1];
				}
			} else {
				if (temp[0] == 0) {
					continue;
				} else if (temp[0] == 1) {
					if (temp[1] == 1) {
						tempStr += "+x";
					} // ex (1,1)=x
					else if (temp[1] == 0) {
						tempStr += "+1";
					} // ex (1,0) = +1
					else {
						tempStr += "+x^" + temp[1];
					} // ex (1,-5) = +x^-5
				} else if (temp[0] == -1) {
					if (temp[1] == 1) {
						tempStr += "-x";
					} // ex (-1,1) = -x
					else if (temp[1] == 0) {
						tempStr += "-1";
					} // ex (-1,0) = -1
					else
						tempStr += "-x^" + temp[1]; // ex (-1,5) = -x^5
				} else if (temp[1] == 0) {
					if (temp[0] > 0)
						tempStr += "+" + temp[0]; // ex (5,0) = +5
					else
						tempStr += temp[0]; // ex (-5,0) = -5
				} else if (temp[1] == 1) {
					if (temp[0] > 0)
						tempStr += "+" + temp[0] + "x"; // ex (8,1) = +8x
					else
						tempStr += temp[0] + "x"; // ex (-9,1) = -9x
				} else {
					if (temp[0] > 1)
						tempStr += "+" + temp[0] + "x^" + temp[1];
					else
						tempStr += temp[0] + "x^" + temp[1];
				}
			}
		}
		return tempStr;

	}

	/**
	 * . Clear the polynomial
	 * 
	 * @param poly
	 *            name of the polynomial
	 */
	public final void clearPolynomial(final char poly) {
		switch (poly) {
		case 'A':
			a.clear();
			break;
		case 'B':
			b.clear();
			break;
		case 'C':
			c.clear();
			break;
		case 'R':
			r.clear();
			break;

		default:
			throw new RuntimeException();
		}
	}

	/**
	 * . Evaluate the polynomial
	 * 
	 * @param poly
	 *            name of the polynomial
	 * @param value
	 *            polynomial constant value
	 * @return the value of the polynomial
	 */
	public final float evaluatePolynomial(final char poly, final float value) {

		float v = 0;
		switch (poly) {
		case 'A':
			if (a.size() == 0) {
				throw new RuntimeException();
			}
			for (int i = 0; i < a.size(); i++) {
				int[] term = (int[]) a.get(i);
				v += term[0] * Math.pow(value, term[1]);
			}
			return v;

		case 'B':
			if (b.size() == 0) {
				throw new RuntimeException();
			}
			for (int i = 0; i < b.size(); i++) {
				int[] term = (int[]) b.get(i);
				v += term[0] * Math.pow(value, term[1]);
			}
			return v;

		case 'C':
			if (c.size() == 0) {
				throw new RuntimeException();
			}
			for (int i = 0; i < c.size(); i++) {
				int[] term = (int[]) c.get(i);
				v += term[0] * Math.pow(value, term[1]);
			}
			return v;

		case 'R':
			if (r.size() == 0) {
				throw new RuntimeException();
			}
			for (int i = 0; i < r.size(); i++) {
				int[] term = (int[]) r.get(i);
				v += term[0] * Math.pow(value, term[1]);
			}
			return v;

		default:
			throw new RuntimeException();
		}

	}

	/**
	 * . Add two polynomials
	 * 
	 * @param poly1
	 *            first polynomial
	 * @param poly2
	 *            second polynomial
	 * @return the result polynomial
	 */
	public int[][] add(char poly1, char poly2) {
		boolean x = a.size() == 0 && b.size() == 0;
		boolean y = a.size() == 0 && c.size() == 0;
		boolean z = b.size() == 0 && c.size() == 0;
		if (x || y || z && (poly1 != poly2)) {
			throw new RuntimeException();
		}
		test(poly1, poly2);
		r.clear();
		if (poly1 == 'A' && poly2 == 'A' && a.size() != 0) {
			myAddStyle(a, a);
		} else if (poly1 == 'B' && poly2 == 'B' && b.size() != 0) {
			myAddStyle(b, b);
		} else if (poly1 == 'C' && poly2 == 'C' && c.size() != 0) {
			myAddStyle(c, c);
		}

		else if ((poly1 == 'A' || poly2 == 'A') && a.size() != 0) {
			if ((poly1 == 'B' || poly2 == 'B') && b.size() != 0) {
				myAddStyle(a, b);
			} else if ((poly1 == 'C' || poly2 == 'C') && c.size() != 0) {
				myAddStyle(a, c);
			}
		}

		else if ((poly1 == 'B' || poly2 == 'B') && b.size() != 0) {
			if ((poly1 == 'C' || poly2 == 'C') && c.size() != 0) {
				myAddStyle(b, c);
			}
		}

		int[][] R = new int[r.size()][2];
		for (int i = 0; i < r.size(); i++) {
			R[i] = (int[]) r.get(i);
		}
		return R;
	}

	public void myAddStyle(SinglyLinkedList x, SinglyLinkedList y) {

		int i = 0, j = 0;
		while (i < x.size() && j < y.size()) {
			int[] t1 = (int[]) x.get(i), t2 = (int[]) y.get(j);
			if (t1[1] > t2[1]) {
				i++;
				r.add(t1);
			} else if (t2[1] > t1[1]) {
				j++;
				r.add(t2);
			} else {
				int[] t3 = new int[2]; // b7ot al exp.
				t3[0] = t1[0] + t2[0];
				t3[1] = t1[1];
				if (t3[0] != 0) {
					r.add(t3);
				}
				i++;
				j++;
			}
		}
		while (i < x.size()) {
			int[] t1 = (int[]) x.get(i);
			i++;
			r.add(t1);
		}
		while (j < y.size()) {
			int[] t2 = (int[]) y.get(j);
			j++;
			r.add(t2);
		}

	}

	/**
	 * . Multiply two polynomials
	 * 
	 * @param poly1
	 *            first polynomial
	 * @param poly2
	 *            second polynomial
	 * @return the result polynomial
	 */
	public final int[][] subtract(final char poly1, final char poly2) {
		/*
		 * Because A - B != B - A
		 */
		r.clear();
		int[][] temp = { { 0, 0 } };
		boolean x = a.size() == 0 && b.size() == 0;
		boolean y = a.size() == 0 && c.size() == 0;
		boolean z = b.size() == 0 && c.size() == 0;

		test(poly1, poly2);

		if (x || y || z && (poly1 != poly2)) {
			throw new RuntimeException();
		} else if (poly1 == 'A' && poly2 == 'B') {
			mySubtractStyle(a, b);
		} else if (poly1 == 'A' && poly2 == 'C') {
			mySubtractStyle(a, c);
		} else if (poly1 == 'B' && poly2 == 'C') {
			mySubtractStyle(b, c);
		} else if (poly1 == 'B' && poly2 == 'A') {
			mySubtractStyle(b, a);
		} else if (poly1 == 'C' && poly2 == 'A') {
			mySubtractStyle(c, a);
		} else if (poly1 == 'C' && poly2 == 'B') {
			mySubtractStyle(c, b);
		} else if (poly1 == poly2) {
			return temp;
		}

		int[][] R = new int[r.size()][];
		for (int i = 0; i < r.size(); i++) {
			R[i] = (int[]) r.get(i);
		}
		return R;
	}

	public void mySubtractStyle(SinglyLinkedList x, SinglyLinkedList y) {
		int i = 0, j = 0;
		while (i < x.size() && j < y.size()) {
			int[] t1 = (int[]) x.get(i), t2 = (int[]) y.get(j);
			if (t1[1] > t2[1]) {
				i++;
				r.add(t1);
			} else if (t2[1] > t1[1]) {
				j++;
				t2[0] = -t2[0];
				r.add(t2);
			} else {
				int[] t3 = new int[2];
				t3[0] = t1[0] - t2[0];
				t3[1] = t1[1];
				if (t3[0] != 0) {
					r.add(t3);
				}
				i++;
				j++;
			}
		}
		while (i < x.size()) {
			int[] t1 = (int[]) x.get(i);
			i++;
			r.add(t1);
		}
		while (j < y.size()) {
			int[] t2 = (int[]) y.get(j);
			j++;
			t2[0] = -t2[0];
			r.add(t2);
		}

	}

	/**
	 * . Multiply two polynomials
	 * 
	 * @param poly1
	 *            first polynomial
	 * @param poly2
	 *            second polynomial
	 * @return the result polynomial
	 */
	public final int[][] multiply(final char poly1, final char poly2) {
		r.clear();
		boolean x = a.size() == 0 && b.size() == 0;
		boolean y = a.size() == 0 && c.size() == 0;
		boolean z = b.size() == 0 && c.size() == 0;
		test(poly1, poly2);
		if (x || y || z && (poly1 != poly2)) {
			throw new RuntimeException();
		} else if (poly1 == 'A' && poly2 == 'A' && a.size() != 0) {
			myMultiplyStyle(a, a);
		}

		else if (poly1 == 'B' && poly2 == 'B' && b.size() != 0) {
			myMultiplyStyle(b, b);
		}

		else if (poly1 == 'C' && poly2 == 'C' && c.size() != 0) {
			myMultiplyStyle(c, c);
		}

		if (poly1 == 'A' || poly2 == 'A' && a.size() != 0) {
			if (poly1 == 'B' || poly2 == 'B' && b.size() != 0) {
				myMultiplyStyle(a, b);
			} else if (poly1 == 'C' || poly2 == 'C' && c.size() != 0) {
				myMultiplyStyle(a, c);
			}
		} else if (poly1 == 'B' || poly2 == 'B' && b.size() != 0) {
			if (poly1 == 'C' || poly2 == 'C' && c.size() != 0) {
				myMultiplyStyle(b, c);
			}
		}
		int[][] v = new int[r.size()][];
		for (int i = 0; i < r.size(); i++) {
			v[i] = (int[]) r.get(i);
		}

		return v;
	}

	/**
	 * @param x
	 *            1st Polynomial
	 * @param y
	 *            2nd polynomial
	 */
	public final void myMultiplyStyle(final SinglyLinkedList x,
			final SinglyLinkedList y) {
		for (int i = 0; i < x.size(); i++) {
			int[] termX = (int[]) x.get(i);
			multiVar.clear();
			for (int j = 0; j < y.size(); j++) {
				int[] termY = (int[]) y.get(j);
				int[] z = new int[2];
				z[0] = termX[0] * termY[0];
				z[1] = termX[1] + termY[1];
				multiVar.add(z);
			}
			l.clear();
			for (int j = 0; j < r.size(); j++) {
				int[] m = (int[]) r.get(j);
				l.add(m);
			}
			r.clear();
			myAddStyle(l, multiVar);

		}
	}

	/**
	 *
	 * @param q
	 *            1st char
	 * @param w
	 *            2nd char
	 */
	public final void test(final char q, final char w) {
		switch (q) {
		case 'A':
			break;
		case 'B':
			break;
		case 'C':
			break;
		default:
			throw new RuntimeException();
		}
		switch (w) {
		case 'A':
			break;
		case 'B':
			break;
		case 'C':
			break;
		default:
			throw new RuntimeException();
		}
	}

	/*
	 *
	 */
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
		int[][] o = { { 2, 5 }, { -2, 4 }, { -1, 3 }, { 5, 1 } };
		int[][] m = { { 2, 2 }, { 2, 0 } };
		int[][] c = { { 2, 2 }, { 1, 1 }, { 1, 0 } };
		PolynomialSolver omar = new PolynomialSolver();
		Scanner input = new Scanner(System.in);
		Boolean flag = true;
		while (flag) {
			int action = input.nextInt();
			switch (action) {
			case 1:
				flag = true;
				System.out
						.println("Insert the variable name " + ": A , B or C");
				input.nextLine(); // clear buffer
				char poly1 = input.next(".").charAt(0); // reading char
				System.out.println(
						"Insert the polynomial " + "terms in the form :");
				System.out.println("( coeff1 , exponent1 ) "
						+ ", ( coeff2 , exponent2 ) , ..");
				SinglyLinkedList terms = new SinglyLinkedList();
				input.nextLine(); // clear buffer
				String line = new String();
				line = input.nextLine();
				Scanner ali = new Scanner(line).useDelimiter("\\(|,|\\)|\\s"); // ignoring
				// characters
				while (ali.hasNext()) {
					if (ali.hasNextInt())
						terms.add(ali.nextInt());
					else
						ali.next();
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
				try {
					if (omar.print(poly2) == null)
						System.out.println("Variable not set");
					else {
						if (poly2 == 'R') {
							flag = false;
							System.out.println(
									"Value in R : " + omar.print(poly2));
						} else
							System.out.println(omar.print(poly2));
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
				try {
					omar.add(poly3, poly4);
					System.out.println("Result set in R : " + omar.print('R'));
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
				float value = input.nextFloat(); // reading char
				try {
					System.out.println(omar.evaluatePolynomial(poly9, value));
				} catch (Exception e) {
					System.out.println("not valid polynomial");
				}
				break;
			case 7:
				System.out.println("Insert the variable name : A , B , C or R");
				char poly10 = input.next(".").charAt(0);
				try {
					omar.clearPolynomial(poly10);
				} catch (Exception e) {
					System.out.println("not valid polynomial");
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