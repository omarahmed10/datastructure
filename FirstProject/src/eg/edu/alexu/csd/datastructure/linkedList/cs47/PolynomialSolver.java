package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class PolynomialSolver implements IPolynomialSolver {

	private SinglyLinkedList a;
	private SinglyLinkedList b;
	private SinglyLinkedList c;
	private SinglyLinkedList r;
	private SinglyLinkedList multiVar;

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
				a.add(terms[i]);
			}
			System.out.println("Polynomial A is set");
		}
			break;
		case 'B': {
			b = new SinglyLinkedList();
			for (int i = 0; i < terms.length; i++) {
				b.add(terms[i]);
			}
			System.out.println("Polynomial B is set");
		}
			break;
		case 'C': {
			c = new SinglyLinkedList();
			for (int i = 0; i < terms.length; i++) {
				c.add(terms[i]);
			}
			System.out.println("Polynomial C is set");
		}
			break;
		default:
			break;
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
			return null;
		}
	}

	public String myPrintStyle(SinglyLinkedList omar) {
		String poly = new String();
		if ((int) omar.size() <= 0) {
			System.out.println("Variable not set");
			throw new RuntimeException();
		} else {
			for (int i = 0; i < omar.size(); i++) {
				boolean ignore = false;
				int[] term = (int[]) omar.get(i);
				/*
				 * ignoring printing(+)at the end and at the beginning
				 */
				if (i != omar.size() && !ignore && i != 0 && term[0] > 0)
					poly += "+";
				if (term[0] == 0) // if not else if because we need both to be
									// executed
					ignore = true; // ignore this term
				else if (term[0] == 1 && term[1] == 1)
					poly += "x" ;
				else if( term[0] == 1 && term[1] != 0 )
					poly += "x^" + term[1];
				else if (term[1] == 0)
					poly += term[0];
				else
					poly += term[0] + "x^" + term[1];
			}
		}
		return poly;
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
		default:
			throw new RuntimeException();
		}
	}

	/**
	 * . Evaluate the polynomial
	 * 
	 * @param poly
	 *            name of the polynomial
	 * @param the
	 *            polynomial constant value
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
		}
		else if( poly1 == 'R' && poly2 == 'M'){
			myAddStyle(r, multiVar);
		}
		int[][] R = new int[r.size()][];
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
				i++;
				j++;
				int[] t3 = t1; // b7ot al exp.
				t3[0] = t1[0] + t2[0]; // adding coff.
				r.add(t3);
			}
		}
		while( i < x.size() ){
			int[] t1 = (int[]) x.get(i);
			i++;
			r.add(t1);
		}
		while( j < y.size() ){
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
		else if (poly1 == poly2)
			r.add(0);
		else
			throw new RuntimeException();

		int[][] R = new int[r.size()][];
		for (int i = 0; i < r.size(); i++) {
			R[i] = (int[]) r.get(i);
		}
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
	}

	public int[][] multiply(char poly1, char poly2) {
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
		int[][] R = new int[r.size()][];
		for (int i = 0; i < r.size(); i++)
			R[i] = (int[]) r.get(i);
		
		return R;
	}
	public void myMultiplyStyle(SinglyLinkedList x, SinglyLinkedList y){
		for(int i = 0; i < x.size() ;i++){
			int[] termX = (int[])x.get(i);
			for(int j =0 ;j < y.size() ;j++){
				int[] termY = (int[])y.get(j);
				int[] z = new int[2];
				z[0] = termX[0]*termY[0];
				z[1] = termX[1]*termY[1];
				multiVar.add(z);
			}
			add('R', 'M');// where M is multiVar and R is the accumulator 
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
		int[][] o = { { 2, 5 }, { -2, 4 }, { -1, 3 }, { 5, 1 }};
		int[][] m = { {2,2}, {2,0} };
		int[][] c = { {2,2}, {1,1}, {1,0} };
		PolynomialSolver omar = new PolynomialSolver();
		omar.setPolynomial('A', o);
		omar.print('A');
		omar.setPolynomial('B', m);
		omar.print('B');
		omar.setPolynomial('C', c);
		omar.print('C');
		omar.add('B', 'C');
		omar.print('R');
	}
}
