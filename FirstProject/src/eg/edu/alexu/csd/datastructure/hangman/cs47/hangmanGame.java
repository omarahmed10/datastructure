package eg.edu.alexu.csd.datastructure.hangman.cs47;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.util.Random;
import java.util.*;

public class hangmanGame implements IHangman {
	static String[] directionary = new String[] { "omaromar", "BLAGHHF" };
	int count = 0;
	int n;
	String[] wordDir;
	String choosenWord = new String();
	String codedWord = new String();
	int maxAttemp;
	int choosen;
//	boolean[] vist = new boolean[26];

	public void setDictionary(String[] words) {
		n = words.length;
		wordDir = new String[n];
		for (int i = 0; i < words.length; i++) {
			wordDir[i] = words[i];
		}

	}

	@Override
	public String selectRandomSecretWord() {
		if (n > 0) {
			Random x = new Random();
			choosen = x.nextInt(wordDir.length);
			choosenWord = wordDir[choosen];
			
			if(choosenWord == null)
				return null;

			for (int i = 0; i < choosenWord.length(); i++) {
				codedWord = codedWord + "-";
			}
			
			return choosenWord;
		} else
			return null;
	}
	

	@Override
	public String guess(Character c) {
		
		if (c == null)
			return codedWord;
		
		if(count >= maxAttemp)
			return null;
		
		boolean hasuppercase = choosenWord.equals(choosenWord.toUpperCase());
		boolean haslowercase = choosenWord.equals(choosenWord.toLowerCase());

//		int Z = 0;
		if (hasuppercase) {
			c = Character.toUpperCase(c);
//			Z = (int) c.charValue() - 65;
		} else if (haslowercase) {
			c = Character.toLowerCase(c);
//			Z = (int) c.charValue() - 97;
		}
		//////////// if this char used then return
//		if (vist[Z])
//			return codedWord;
		
		if( codedWord == choosenWord )
			return null;
		
		int x = choosenWord.indexOf(c, 0);
		if (x >= 0) {
			do {
				codedWord = codedWord.substring(0, x) + choosenWord.charAt(x) + codedWord.substring(x + 1);
				x = choosenWord.indexOf(c, x + 1);
			} while (x >= 0);

//			vist[Z] = true;
			return codedWord;
		} else {
			count++;
//			vist[Z] = true;
			if (count >= maxAttemp)
				return null;
			else 
				return codedWord;
		}
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if (max.equals(null))
			maxAttemp = 0;
		else
			maxAttemp = max.intValue();

	}

	public static void main(String[] args) {
		hangmanGame hangman = new hangmanGame(); // Here you will create an
		// object of your class
		hangman.setDictionary(directionary);
		hangman.setMaxWrongGuesses(0);
		String secret = hangman.selectRandomSecretWord();
		Scanner input = new Scanner(System.in);
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
			guess = input.next().charAt(0);
		} while (true);

	}

}
