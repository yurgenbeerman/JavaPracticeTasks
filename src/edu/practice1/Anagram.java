/*
 * Anagram.java  0.4 2014/02/25
 *
 * This code is created for self educational purpose, so anyone can use it. Author rights reserved.
 */

 
package edu.practice1;

import java.util.*;
import java.lang.String;
import edu.practice1.Messages;
import edu.practice1.Utils;

/**
 * Java SE Basics Practice 1
 * Task 3. Anagram
 * The Anagram.taskResult() is called from Practice1Results class.
 * 
 * Business-Logic Requirements:
 * An anagram is a word or a phrase that can be created by rearranging the letters of another
 * given word or phrase. We ignore white spaces and letter case. The all letters of
 * "Desperation" can be rearranged to the phrase "A Rope Ends It". The program should
 * receive input of two strings and give the output to screen telling whether these words are
 * anagrams
 * 
 * Use runTest() method for tests.
 *
 * @version 	0.4 25 Feb 2014
 * @author 	Yuri Pyvovarenko
 *
 * General requirements to applications are:
 * 		•    Application must have accessible User Interface;
 * 		•    Application must have foolproof (check of entering data);
 * 		•    Application must be developed with minimum number of Java base classes – all
 *				 the rest must be implemented autonomously. For example, Calendar Seeker
 *				 can be easily implemented with the help of Date class but is very inappropriate
 *				 in this module.
 * 		•    Application with its interim releases must be placed in SVN repository. 
 * 		•    When writing a code try to make it self-explanatory, but not confusing.
*/
public class Anagram {

	static final boolean IS_TEST = false;

	public static void taskResult(boolean isPackageFinalized, Scanner input) {
		System.out.println("\n--- Anagram ---");

		if ((isPackageFinalized) && (!IS_TEST)) {
			//Scanner in = new Scanner(System.in);
			String string1 = Utils.inputNotZeroString(input, "Please enter string1: ");
			String string2 = Utils.inputNotZeroString(input, "Please enter string2: ");
			//in.close();
			if (areAnagrams(string1, string2)) {
				System.out.println(Messages.IS_ANAGRAM + "\n");
			} else {
				System.out.println(Messages.NOT_ANAGRAM + "\n");
			}
		} else {
			runTests();
		}
	}
	
	static boolean areAnagrams(String string1, String string2) {

		boolean result = false;
		
		/* remove all spaces */
		String stringA = string1.replace(" ", "");
		String stringB = string2.replace(" ", "");

		if (stringA.length() == stringB.length()) {
			int lettersNum = stringA.length();
			stringA = stringA.toLowerCase();
			stringB = stringB.toLowerCase();
			
			/* Cast to array of ints */
			int[] intArr1 = new int[lettersNum];
			int[] intArr2 = new int[lettersNum];
			char letter = 'a';
			for (int i = 0; i < lettersNum; i++) {
				intArr1[i] = (int) stringA.charAt(i);
				intArr2[i] = (int) stringB.charAt(i);
			}
			
			/* Sort int arrays */
			/* I may use Arrays.sort(intArr1); Arrays.sort(intArr2); but i propose to use own sort */
			intArr1 = sortIntArray(intArr1);
			intArr2 = sortIntArray(intArr2);
			if (IS_TEST) {
				System.out.println("intArr1 = " + Arrays.toString(intArr1));
				System.out.println("intArr2 = " + Arrays.toString(intArr2));
			}
			
			/* compare sorted int arrays */
			boolean isDifferent = false;
			for (int i = 0; i < lettersNum; i++)
				if (intArr1[i] != intArr2[i]) {
					isDifferent = true;
					if (IS_TEST) System.out.println("Diffference at i = " + i);
					break;
				};
			
			result = !isDifferent;
		
		} else System.out.println("These strings differ in number of letters");
		
		return result;
	}	

	/* Selection sort method */
	static int[] sortIntArray(int[] array) {
	
		/* we will sort the copy of initial array, not to harm it in case of error while sorting */
		/* I can use Arrays.copyOf() or System.arraycopy(), but there is a task: Application must be developed with minimum number of Java base classes */
		int[] result = new int[array.length];
		for (int i = array.length-1; i >= 0; i--) result[i] = array[i];
	
		int maxIndex = result.length;
		int temp = 0;
		for (int j = 0; j < maxIndex-1; j++) {
		
			/* 1. find index of MIN number */
			int minIndex = j;
			for(int k = j+1; k < maxIndex; k++) if (result[k] <= result[minIndex]) minIndex = k;
			
			/* 2. put MIN number in j place, and the j-element put to old place of the MIN number */
			if (result[j]!=result[minIndex]) { 
			  temp = result[minIndex];
			  result[minIndex] = result[j];
			  result[j] = temp;
			}
		}
		//System.out.println("\nThe sorted array is:"); for (int elem : result) System.out.print(elem + ", ");
		return result;
    }

	static void runTests() {
	
		//int[] arr = {110, 109, 106, 107, 55, 22, 56, 75, 3};
		//int[] arr1 = sortIntArray(arr);
		//System.out.println("arr = " + Arrays.toString(arr));
		//System.out.println("arr1 = " + Arrays.toString(arr1));

		String[][] testStrings = {
			{ " Desperation ", " A Rope Ends It " },
			{ " wwnf ", " fNww " },
			{ " km ", " MK " },
			{ "op", "vK" },
			{ " jnkm ", " kmjn " }
		};
		for(String[] stringsPair : testStrings) {
			System.out.println("string1 = " + stringsPair[0] + ". string2 = " + stringsPair[1] + ".");
			if (areAnagrams(stringsPair[0], stringsPair[1])) {
				System.out.println(Messages.IS_ANAGRAM + "\n");
			} else {
				System.out.println(Messages.NOT_ANAGRAM + "\n");
			}
		}
	}	
}