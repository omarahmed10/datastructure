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
	/**
	 * 
	 */
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
			if (c.size() == 0) {
				return null;
			} else {
				return myPrintStyle(c);
			}
		case 'R':
			if (r.size() == 0) {
				return null;
			} else {
				return myPrintStyle(r);
			}
		default:
			throw new RuntimeException();
		}
	}

	/**
	 * 
	 * @param z
	 *            Poly Name
	 * @return printed poly
	 */
	public final String myPrintStyle(final SinglyLinkedList z) {
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
					} else {
						tempStr += "x^" + temp[1];
					}
				} else if (temp[0] == -1) {
					if (temp[1] == 1) {
						tempStr += "-x";
					} else if (temp[1] == 0) {
						tempStr += "-1";
					} else {
						tempStr += "-x^" + temp[1];
					}
				} else if (temp[1] == 0) {
					tempStr += temp[0];
				} else if (temp[1] == 1) {
					tempStr += temp[0] + "x";
				} else {
					tempStr += temp[0] + "x^" + temp[1];
				}
			} else {
				if (temp[0] == 0) {
					continue;
				} else if (temp[0] == 1) {
					if (temp[1] == 1) {
						tempStr += "+x";
					} else if (temp[1] == 0) {
						tempStr += "+1";
					} else {
						tempStr += "+x^" + temp[1];
					}
				} else if (temp[0] == -1) {
					if (temp[1] == 1) {
						tempStr += "-x";
					} else if (temp[1] == 0) {
						tempStr += "-1";
					} else {
						tempStr += "-x^" + temp[1];
					} // ex (-1,5) = -x^5
				} else if (temp[1] == 0) {
					if (temp[0] > 0) {
						tempStr += "+" + temp[0];
					} else {
						tempStr += temp[0];
					}
				} else if (temp[1] == 1) {
					if (temp[0] > 0) {
						tempStr += "+" + temp[0] + "x";
					} else {
						tempStr += temp[0] + "x";
					}
				} else {
					if (temp[0] > 1) {
						tempStr += "+" + temp[0] + "x^" + temp[1];
					} else {
						tempStr += temp[0] + "x^" + temp[1];
					}
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
	public final int[][] add(final char poly1, final char poly2) {
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
		} else if ((poly1 == 'A' || poly2 == 'A')) {
			if ((poly1 == 'B' || poly2 == 'B')) {
				myAddStyle(a, b);
			} else if ((poly1 == 'C' || poly2 == 'C')) {
				myAddStyle(a, c);
			}
		} else if ((poly1 == 'B' || poly2 == 'B')) {
			if ((poly1 == 'C' || poly2 == 'C')) {
				myAddStyle(b, c);
			}
		}

		int[][] arr = new int[r.size()][2];
		for (int i = 0; i < r.size(); i++) {
			arr[i] = (int[]) r.get(i);
		}
		return arr;
	}

	/**
	 * 
	 * @param x
	 *            1st poly
	 * @param y
	 *            1st poly
	 */
	public final void myAddStyle(final SinglyLinkedList x,
			final SinglyLinkedList y) {

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

		int[][] arr = new int[r.size()][];
		for (int i = 0; i < r.size(); i++) {
			arr[i] = (int[]) r.get(i);
		}
		return arr;
	}

	/**
	 * 
	 * @param x
	 *            1st poly
	 * @param y
	 *            2nd poly
	 */
	public final void mySubtractStyle(final SinglyLinkedList x,
			final SinglyLinkedList y) {
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
		} else if (poly1 == 'B' && poly2 == 'B' && b.size() != 0) {
			myMultiplyStyle(b, b);
		} else if (poly1 == 'C' && poly2 == 'C' && c.size() != 0) {
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
	 *            1st Polynomail
	 * @param y
	 *            2nd polynomail
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
	

}