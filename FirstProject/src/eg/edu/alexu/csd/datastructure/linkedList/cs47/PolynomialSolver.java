package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class PolynomialSolver implements IPolynomialSolver {

	private SinglyLinkedList a;
	private SinglyLinkedList b;
	private SinglyLinkedList c;
	private SinglyLinkedList r = new SinglyLinkedList();
	private SinglyLinkedList l = new SinglyLinkedList();
	private SinglyLinkedList multiVar = new SinglyLinkedList();

	public void setPolynomial(char poly, int[][] terms) {
		for (int i = 0; i < terms.length - 1; i++) {
			if (terms[i][1] <= terms[i + 1][1]) {
				throw new RuntimeException();
			}
		}
		switch (poly) {
		case 'A': {
			a = new SinglyLinkedList();
			for (int i = 0; i < terms.length; i++) {
				if (terms[i][1] < 0)
					throw new RuntimeException();
				a.add(terms[i]);
			}
			System.out.println("Polynomial A is set");
		}
			break;
		case 'B': {
			b = new SinglyLinkedList();
			for (int i = 0; i < terms.length; i++) {
				if (terms[i][1] < 0)
					throw new RuntimeException();
				b.add(terms[i]);
			}
			System.out.println("Polynomial B is set");
		}
			break;
		case 'C': {
			c = new SinglyLinkedList();
			for (int i = 0; i < terms.length; i++) {
				if (terms[i][1] < 0)
					throw new RuntimeException();
				c.add(terms[i]);
			}
			System.out.println("Polynomial C is set");
		}
			break;
		default:
			throw new RuntimeException();
		}

	}

	public String print(char poly) {
		switch (poly) {
		case 'A':
			System.out.println(myPrintStyle(a));
			return myPrintStyle(a);
		case 'B':
			System.out.println(myPrintStyle(b));
			return myPrintStyle(b);
		case 'C':
			System.out.println(myPrintStyle(c));
			return myPrintStyle(c);
		case 'R':
			System.out.println(myPrintStyle(r));
			return myPrintStyle(r);
		default:
			throw new RuntimeException();
		}
	}

	public final String myPrintStyle(SinglyLinkedList z) {
		if( z.size() == 0 )
			return null;
		String tempStr = new String("");
		for (int i = 0; i < z.size(); i++) {
			int[] temp = (int[]) z.get(i);
			if (i == 0) {
				if (temp[0] == 0)
					tempStr += 0;
				else if (temp[0] == 1) {
					if (temp[1] == 1)
						tempStr += "x"; // ex (1,1)=x
					else if (temp[1] == 0)
						tempStr += "1"; // ex (1,0) = +1
					else
						tempStr += "x^" + temp[1]; // ex (1,-5) = +x^-5
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
					if (temp[1] == 1)
						tempStr += "+x"; // ex (1,1)=x
					else if (temp[1] == 0)
						tempStr += "+1"; // ex (1,0) = +1
					else
						tempStr += "+x^" + temp[1]; // ex (1,-5) = +x^-5
				} else if (temp[0] == -1) {
					if (temp[1] == 1)
						tempStr += "-x"; // ex (-1,1) = -x
					else if (temp[1] == 0)
						tempStr += "-1"; // ex (-1,0) = -1
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
		case 'A': {
			if (a.size() < 0)
				throw new RuntimeException();
			a.clear();
		}
			break;
		case 'B': {
			if (b.size() < 0)
				throw new RuntimeException();
			b.clear();
		}
			break;
		case 'C': {
			if (c.size() < 0)
				throw new RuntimeException();
			c.clear();
		}
		case 'R': {
			if (r.size() < 0)
				throw new RuntimeException();
			r.clear();
		}
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
	 * @param polynomial
	 *            constant value
	 * @return the value of the polynomial
	 */
	public final float evaluatePolynomial(char poly, float value) {
		float v = 0;
		switch (poly) {
		case 'A': {
			for (int i = 0; i < a.size(); i++) {
				int[] term = (int[]) a.get(i);
				v += term[0] * Math.pow(value, term[1]);
			}
		}
			return v;
		case 'B': {
			for (int i = 0; i < b.size(); i++) {
				int[] term = (int[]) b.get(i);
				v += term[0] * Math.pow(value, term[1]);
			}
		}
			return v;
		case 'C': {
			for (int i = 0; i < c.size(); i++) {
				int[] term = (int[]) c.get(i);
				v += term[0] * Math.pow(value, term[1]);
			}
		}
			return v;
		default:
			break;
		}
		return 0;
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
		if (poly1 == 'A' || poly2 == 'A') {
			if (poly1 == 'B' || poly2 == 'B') {
				myAddStyle(a, b);
			} else if (poly1 == 'C' || poly2 == 'C') {
				myAddStyle(a, c);
			}
		} else if (poly1 == 'B' || poly2 == 'B') {
			if (poly1 == 'C' || poly2 == 'C') {
				myAddStyle(b, c);
			}
		} else if (poly1 == 'R' && poly2 == 'M') {
			myAddStyle(r, multiVar);
		} else if (poly1 == 'A' && poly2 == 'A')
			myAddStyle(a, a);
		else if (poly1 == 'B' && poly2 == 'B')
			myAddStyle(b, b);
		else if (poly1 == 'C' && poly2 == 'C')
			myAddStyle(c, c);

		if (r.size() == 0) 
//		{
//			int[][] temp = { { 0, 0 } };
//			return temp;
//		}
		 return null;
		int[][] R = new int[r.size()][];
		for (int i = 0; i < r.size(); i++) {
			R[i] = (int[]) r.get(i);
		}
		// r.clear();
		return R;
	}

	public void myAddStyle(SinglyLinkedList x, SinglyLinkedList y) {
		int i = 0, j = 0;
		while (i < x.size() && j < y.size()) {
			int[] t1 = (int[]) x.get(i), t2 = (int[]) y.get(j), t3;
			if (t1[1] > t2[1]) {
				i++;
				r.add(t1);
			} else if (t2[1] > t1[1]) {
				j++;
				r.add(t2);
			} else {
				i++;
				j++;
				t3 = t1; // b7ot al exp.
				t3[0] = t1[0] + t2[0]; // adding coff.
				if (t3[0] != 0)
					r.add(t3);
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

	public int[][] subtract(char poly1, char poly2) {
		/*
		 * Because A - B != B - A
		 */
		if (poly1 == 'A' && poly2 == 'B')
			myStubtractStyle(a, b);
		else if (poly1 == 'A' && poly2 == 'C')
			myStubtractStyle(a, c);
		else if (poly1 == 'B' && poly2 == 'C')
			myStubtractStyle(b, c);
		else if (poly1 == 'B' && poly2 == 'A')
			myAddStyle(b, a);
		else if (poly1 == 'C' && poly2 == 'A')
			myStubtractStyle(c, a);
		else if (poly1 == 'C' && poly2 == 'B')
			myStubtractStyle(c, b);
		else if (poly1 == poly2) {
			int[][] temp = { { 0, 0 } };
			return temp;
		} else
			throw new RuntimeException();

		if (r.size() == 0) 
//		{
//			int[][] temp = { { 0, 0 } };
//			return temp;
//		}
		 return null;
		int[][] R = new int[r.size()][];
		for (int i = 0; i < r.size(); i++) {
			R[i] = (int[]) r.get(i);
		}
//		r.clear();
		return R;
	}

	public void myStubtractStyle(SinglyLinkedList x, SinglyLinkedList y) {
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
				i++;
				j++;
				int[] t3 = t1; // b7ot al exp.
				t3[0] = t1[0] - t2[0]; // adding coff.
				r.add(t3);
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

	public int[][] multiply(char poly1, char poly2) {
		if (poly1 == 'A' && poly2 == 'A') {
			myMultiplyStyle(a, a);
		}

		else if (poly1 == 'B' && poly2 == 'B') {
			myMultiplyStyle(b, b);
		}

		else if (poly1 == 'C' && poly2 == 'C') {
			myMultiplyStyle(c, c);
		}

		if (poly1 == 'A' || poly2 == 'A') {
			if (poly1 == 'B' || poly2 == 'B') {
				myMultiplyStyle(a, b);
			} else if (poly1 == 'C' || poly2 == 'C') {
				myMultiplyStyle(a, c);
			}
		} else if (poly1 == 'B' || poly2 == 'B') {
			if (poly1 == 'C' || poly2 == 'C') {
				myMultiplyStyle(b, c);
			}
		}

		if (r.size() == 0) 
//		{
//			int[][] temp = { { 0, 0 } };
//			return temp;
//		}
		 return null;
		int[][] R = new int[r.size()][];
		for (int i = 0; i < r.size(); i++)
			R[i] = (int[]) r.get(i);
//		r.clear();
		return R;
	}

	public void myMultiplyStyle(SinglyLinkedList x, SinglyLinkedList y) {
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
			myAddStyle(l, multiVar); // where M is multiVar and R is the
			// accumulator
		}
	}

	public static void main(String[] args) {
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial variable");
		System.out.println("====================================================================");
		int[][] o = { { 2, 5 }, { -2, 4 }, { -1, 3 }, { 5, 1 } };
		int[][] m = { { 2, 2 }, { 2, 0 } };
		int[][] c = { { 2, 2 }, { 1, 1 }, { 1, 0 } };
		PolynomialSolver omar = new PolynomialSolver();
		omar.setPolynomial('A', o);
		omar.print('A');
		omar.clearPolynomial('A');
		omar.print('A');
		omar.setPolynomial('B', m);
		omar.print('B');
		omar.setPolynomial('C', c);
		omar.print('C');
		omar.add('A', 'B');
		omar.print('R');
		omar.multiply('B', 'C');
		omar.print('R');
	}
}
