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

	static final boolean IS_TEST = false;

	public static void taskResult(boolean isPackageFinalized) {
		System.out.println("\n--- Anagram ---");

		if ((isPackageFinalized) && (!IS_TEST)) {
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
			
			//The next transformations consider both strings. I concatenate them. lettersNum helps to differ two strings.
			stringA = stringA.toLowerCase();
			stringB = stringB.toLowerCase();
			
			//array of ints
			int[] intArr1 = new int[lettersNum];
			int[] intArr2 = new int[lettersNum];
			char letter = 'a';
			for (int i = 0; i < lettersNum; i++) {
				intArr1[i] = (int)stringA.charAt(i);
				intArr2[i] = (int)stringB.charAt(i);
			}
			/*
			for(char letter : charArr)
				if (i < lettersNum) intArr1[i] = (int)letter;
				else intArr2[i] = (int)letter;
			*/
			//sorted int arrays
			//Arrays.sort(intArr1); 			Arrays.sort(intArr2);
			intArr1 = sortIntArray(intArr1);
			intArr2 = sortIntArray(intArr2);
			if (IS_TEST) {
				System.out.println("intArr1 = " + Arrays.toString(intArr1));
				System.out.println("intArr2 = " + Arrays.toString(intArr2));
			}
			
			//compare sorted int arrays
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

	static int[] sortIntArray(int[] array) {
		//we will sort the copy of initial array, not to harm it in case of error while sorting
		int[] arr = new int[array.length];
		for (int i = array.length-1; i >= 0; i--) arr[i] = array[i];
	
		int maxIndex = arr.length;
		int temp = 0;
		for (int j = 0; j < maxIndex-1; j++) {
			// 1. find index of MIN number
			int minIndex = j;
			for(int k = j+1; k < maxIndex; k++) if (arr[k] <= arr[minIndex]) minIndex = k;
			// 2. put MIN number in j place, and the j-element put to old place of the MIN number
			if (arr[j]!=arr[minIndex]) { 
			  temp = arr[minIndex];
			  arr[minIndex] = arr[j];
			  arr[j] = temp;
			}
		}
		//System.out.println("\nThe sorted array is:"); for (int elem : arr) System.out.print(elem + ", ");
		return arr;
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
		/*
	int[] arr = {110, 109, 106, 107, 55, 22, 56, 75, 3};
	int[] arr1 = sortIntArray(arr);
	System.out.println("arr = " + Arrays.toString(arr));
	System.out.println("arr1 = " + Arrays.toString(arr1));
		*/

		String string1 = " Desperation ";
		String string2 = " A Rope Ends It ";
		System.out.println("string1 = " + string1 + ". string2 = " + string2 + ".");
		if (areAnagrams(string1, string2)) System.out.println("These two strings are anagrams.");
		else System.out.println("These two strings are NOT anagrams.\n");
		
		string1 = " wwnf ";
		string2 = " fNww ";
		System.out.println("string1 = " + string1 + ". string2 = " + string2 + ".");
		if (areAnagrams(string1, string2)) System.out.println("These two strings are anagrams.");
		else System.out.println("These two strings are NOT anagrams.\n");
		
		string1 = " jnkm ";
		string2 = " kmjn ";
		System.out.println("string1 = " + string1 + ". string2 = " + string2 + ".");
		if (areAnagrams(string1, string2)) System.out.println("These two strings are anagrams.");
		else System.out.println("These two strings are NOT anagrams.\n");
		
		string1 = " km ";
		string2 = " mk ";
		System.out.println("string1 = " + string1 + ". string2 = " + string2 + ".");
		if (areAnagrams(string1, string2)) System.out.println("These two strings are anagrams.");
		else System.out.println("These two strings are NOT anagrams.");

	}	
}