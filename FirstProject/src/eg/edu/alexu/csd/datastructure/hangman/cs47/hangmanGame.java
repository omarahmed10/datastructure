package eg.edu.alexu.csd.datastructure.hangman.cs47;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.util.Random;
import java.util.*;

public class hangmanGame implements IHangman {
	static String[] directionary = new String[] { "BELGIUM", "BURUNDI", "COLOMBIA", "EGYPT", "KAZAKHSTAN", "MAURITANIA",
			"SINGAPORE", "UZBEKISTAN" }; // this should be read from file,
											// instead of having them hard-coded
	public static int count = 0;
	public static String[] wordDir = new String[directionary.length];
	public static String codedWord = new String();
	public static int maxAttemp;
	public static int choosen;
	private static Scanner input;

	public void setDictionary(String[] words) {
		for (int i = 0; i < words.length; i++) {
			wordDir[i] = words[i];
		}

	}

	@Override
	public String selectRandomSecretWord() {
		Random x = new Random();
		choosen = x.nextInt(wordDir.length);
		for (int i = 0; i < wordDir[choosen].length(); i++) {
			codedWord = codedWord + "-";
		}
		return codedWord;
	}

	@Override
	public String guess(Character c) {
		int x = wordDir[choosen].indexOf(c);
		if (c == null)
			return codedWord;
		else if (count == maxAttemp)
			return null;
		else if (x >= 0) {
			codedWord = codedWord.substring(0, x) + wordDir[choosen].charAt(x) + codedWord.substring(x + 1);
			return codedWord;
		} else {
			count++;
			if (count == maxAttemp)
				return null;
			else
				return codedWord;
		}
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if (max == null)
			maxAttemp = 0;
		else
			maxAttemp = max;

	}

	public static void main(String[] args) {
		hangmanGame hangman = new hangmanGame(); // Here you will create an
													// object of your class
		hangman.setDictionary(directionary);
		hangman.setMaxWrongGuesses(5);
		String secret = hangman.selectRandomSecretWord();
		input = new Scanner(System.in);
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
