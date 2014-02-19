package practice1;

/*************
* Author: Yuri Pyvovarenko
*/

/**
https://learning.globallogic.com/moodle/mod/page/view.php?id=23
3. Anagram
Business-Logic Requirements:
An anagram is a word or a phrase that can be created by rearranging the letters of another given word or phrase. We ignore white spaces and letter case. The all letters of "Desperation" can be rearranged to the phrase "A Rope Ends It". The program should receive input of two strings and give the output to screen telling whether these words are anagrams

General requirements to applications are:
	•    Application must have accessible User Interface;
	•    Application must have foolproof (check of entering data);
	•    Application must be developed with minimum number of Java base classes – all the rest must be implemented autonomously. For example, Calendar Seeker can be easily implemented with the help of Date class but is very inappropriate in this module.
	•    Application with its interim releases must be placed in SVN repository. 
	•    When writing a code try to make it self-explanatory, but not confusing.
*/
import java.util.*;
import java.lang.String;

public class Anagram {

	static final boolean IS_TEST = true;

	public static void taskResult() {
		System.out.println("--- Anagram ---");



		if (!IS_TEST) {
			Scanner in = new Scanner(System.in);
			String string1 = inputString(in, 1);
			String string2 = inputString(in, 2);
			
			if (areAnagrams(string1, string2)) System.out.println("These two strings are anagrams.");
			else System.out.println("These two strings are NOT anagrams.");
			
		} else {
			runTests();
		}
	}
	
	static boolean areAnagrams(String string1, String string2) {

		boolean result = false;
		
		//remove all spaces
		//string1 = string1.trim();  		string2 = string2.trim();
		String stringA = string1.replace(" ", "");
		String stringB = string2.replace(" ", "");

		if (stringA.length() == stringB.length()) {
			
			int lettersNum = stringA.length();
			
			//All next transformations consider both strings. I concatenate them. lettersNum helps to differ two strings.
			stringA = (stringA + stringB).toLowerCase();
			
			//string2 = string2.toLowerCase();
			
			//array of chars
			char[] charArr = new char[lettersNum * 2];
			for (int i = 0; i < lettersNum * 2; i++)
				charArr[i] = stringA.charAt(i);
			
			//array of ints
			int[] intArr1 = new int[lettersNum];
			int[] intArr2 = new int[lettersNum];
			for(charArr: letter)
				if (i < lettersNum) intArr1[i] = (int)letter;
				else intArr2[i] = (int)letter;
			
			//sorted int arrays
			Arrays.sort(intArr1);
			Arrays.sort(intArr2);
			
			//compare sorted int arrays
			boolean isDifferent = false;
			for (int i = 0; i < lettersNum; i++)
				if (intArr1[i] == intArr1(i)) {
					isDifferent = true;
					break;
				};
			
			result = !isDifferent;
			
			//System.out.println("AFTER SPACES REPLACING string1 = " + string1 + " string2 = " + string2);
			//if (string1.equalsIgnoreCase(string2)) result = true;
			//if (string1.equals(string2)) result = true;		
		
		} else System.out.println("These strings differ in number of letters");
		
		return result;
	}	
	
	static String inputString(Scanner in,  int num) {
		String inputedValue = new String();
		String trimmedValue = new String();
		do {
			System.out.println("Please enter string" + num + ": ");
			inputedValue = in.nextLine();
			trimmedValue = inputedValue.trim();
		} while (0 == trimmedValue.length());
		
		return inputedValue;
	}

	static void runTests() {
		String string1 = "Desperation";
		String string2 = "A Rope Ends It";
		System.out.println("string1 = " + string1 + " string2 = " + string2);
		if (areAnagrams(string1, string2)) System.out.println("These two strings are anagrams.");
		else System.out.println("These two strings are NOT anagrams.");
	}	
}