package eg.edu.alexu.csd.datastructure.hangman.cs47;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.util.Random;
import java.util.*;

public class hangmanGame implements IHangman {
//	static String[] directionary = new String[] { "OMARAOMAR","AHMEDAHMED" }; // this should be read from file,
//											// instead of having them hard-coded
	static int count = 0;
	static int n;
	static String[] wordDir ;
	static String codedWord = new String();
	static int maxAttemp;
	static int choosen;
	static Scanner input;

	public void setDictionary(String[] words) {
		n= words.length;
		wordDir = new String[n];
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
		return wordDir[choosen];
	}

	@Override
	public String guess(Character c) {
		if (c == null)
			return codedWord;
		int x = wordDir[choosen].indexOf(c,0);
		if(x >= 0){
			do{
				codedWord = codedWord.substring(0, x) + wordDir[choosen].charAt(x) + codedWord.substring(x + 1);
				x = wordDir[choosen].indexOf(c, x+1);
			}while(x >= 0);
			return codedWord;
		}
		else {
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
//
//	public static void main(String[] args) {
//		hangmanGame hangman = new hangmanGame(); // Here you will create an
//													// object of your class
//		hangman.setDictionary(directionary);
//		hangman.setMaxWrongGuesses(5);
//		String secret = hangman.selectRandomSecretWord();
//		input = new Scanner(System.in);
//		Character guess = null;
//		do {
//			String result = hangman.guess(guess);
//			if (result == null) {
//				System.out.println("Fail! correct answer = '" + secret + "'"); // fail
//				return;
//			}
//			System.out.println(result);
//			if (!result.contains("-")) {
//				System.out.println("Well Done!"); // win
//				return;
//			}
//			guess = input.next().toUpperCase().charAt(0);
//		} while (true);
//
//	}

}
