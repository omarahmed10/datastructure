package eg.edu.alexu.csd.datastructure.hangman.cs47;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.util.Random;
import java.util.*;

public class hangmanGame implements IHangman {

	int count = 0;
	int n;
	String[] wordDir;
	String choosenWord = new String();
	String codedWord = new String();
	int maxAttemp;
	int choosen;

	public void setDictionary(String[] words) {
		n = words.length;
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
		choosenWord = wordDir[choosen];
		return choosenWord;
	}

	@Override
	public String guess(Character c) {
		if (c == null)
			return codedWord;
		boolean hasuppercase = choosenWord.equals(choosenWord.toUpperCase());
		boolean haslowercase = choosenWord.equals(choosenWord.toLowerCase());

		if (hasuppercase)
			c = Character.toUpperCase(c);
		else if (haslowercase)
			c = Character.toLowerCase(c);

		int x = choosenWord.indexOf(c, 0);
		if (x >= 0) {
			do {
				codedWord = codedWord.substring(0, x) + choosenWord.charAt(x) + codedWord.substring(x + 1);
				x = choosenWord.indexOf(c, x + 1);
			} while (x >= 0);
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

}
