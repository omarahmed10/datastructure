package eg.edu.alexu.csd.datastructure.hangman.cs47;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
import java.util.*;
import java.io.*;

public class hangmanGame implements IHangman {
	static String[] directionary = new String[] { "BELGIUM", "BURUNDI", "COLOMBIA", "EGYPT", "KAZAKHSTAN", "MAURITANIA",
			"SINGAPORE", "UZBEKISTAN" }; // this should be read from file,
											// instead of having them hard-coded
	public static int count =0;
	final static int n = 100000;
	public static String[] wordDir = new String[n];
	public static char[] codedWord = new char[n];
	public static int maxAttemp;
	public static int choosen;
	
	public void setDictionary(String[] words) {
		for (int i = 0; i < words.length; i++) {
			wordDir[i] = words[i];
		}

	}

	@Override
	public String selectRandomSecretWord() {
		Random x =new Random();
		choosen = x.nextInt(wordDir.length);
		for (int i = 0; i < wordDir[z].length(); i++) {
			codedWord[i]='-';
		}
		return codedWord;
	}

	@Override
	public String guess(Character c) {
		int x = wordDir[choosen].indexOf(c);
		if(c == null)
			return codedWord;
		else if( count == maxAttemp )
			return null;
		else if( x ){
			codedWord[x] = wordDir[choosen].charAt(x);
			count++;
			return codedWord;
		}
		else
			return codedWord;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if( max == null )
			maxAttemp = 0;
		else 
			maxAttemp = max;

	}

	public static void main(String[] args) {
		IHangman hangman = new HangmanEngine(); // Here you will create an
												// object of your class
		hangman.setDictionary(directionary);
		hangman.setMaxWrongGuesses(5);
		String secret = hangman.selectRandomSecretWord();
		Scanner input = new Scanner(System.in); // Get user input
		Character guess = null;
		do {
			String result = hangman.guess(guess);
			if (result == null) {
				System.out.println("Fail! correct answer = '" + secret + "'"); // fail
				return;
			}
			System.out.println(result);
			if (!result.contains("-")) {
				System.out.println("Well Done!"); // win
				return;
			}
			guess = input.next().toUpperCase().charAt(0);
		} while (true);

	}

}
