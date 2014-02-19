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

public class CalendarSeeker {

	static final boolean IS_TEST = false;

	public static void taskResult() {
		System.out.println("--- CalendarSeeker ---");

		if (!IS_TEST) {
		/*
			Scanner in = new Scanner(System.in);
			String string1 = inputString(in, 1);
			String string2 = inputString(in, 2);
			
			if (areAnagrams(string1, string2)) System.out.println("These two strings are anagrams.");
			else System.out.println("These two strings are NOT anagrams.");
			*/
		} else {
			runTests();
		}
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
		System.out.println("Tests");
	}	
}