package practice1;

/*************
* Author: Yuri Pyvovarenko
*/

/**
https://learning.globallogic.com/moodle/mod/page/view.php?id=23
2. Arrays - neighbouring numbers
Business-Logic Requirements:
Find two neighbouring numbers in an array with the smallest distance to each other. The index of the first number should be outputted to the screen. For example, in the sequence 4 8 6 1 2 9 4 the minimum distance is 1 (between 1 and 2). The function should return the index 3 (of number 1).
If ecxists more than one decision should be outputted only a first one.
Implementation Requirements:
All input should be get from keyboard

General requirements to applications are:
	•    Application must have accessible User Interface;
	•    Application must have foolproof (check of entering data);
	•    Application must be developed with minimum number of Java base classes – all the rest must be implemented autonomously. For example, Calendar Seeker can be easily implemented with the help of Date class but is very inappropriate in this module.
	•    Application with its interim releases must be placed in SVN repository. 
	•    When writing a code try to make it self-explanatory, but not confusing.
*/
import practice1.*;
import java.util.*;

//PrimeNumbers.isIntegerNumber(str)


public class NeighbouringNumbers{
	public static void taskResult() {
		System.out.println("\n--- NeighbouringNumbers ---");
		
		Scanner in = new Scanner(System.in);
		String inputedValue = new String();
		System.out.println("Please enter positive integer numbers trough spaces: ");
		inputedValue = in.nextLine();
		if (inputedValue.length()>0) {
			inputedValue.trim();
			if (inputedValue.indexOf(" ")>0) {
				int[] arr = intArray(inputedValue);
				if (arr[100]>-1) { //if there was no error
				
				//remove unneeded values from arr
				lastNumberIndex = 0;
				do lastNumberIndex++ while (arr[lastNumberIndex]>=0) && (lastNumberIndex<arr.length());
				int[] arrCopy = Arrays.copyOf(arr, lastNumberIndex);
				arr = Arrays.copyOf(arrCopy, lastNumberIndex);

				//find neighbous
				Arrays.sort(arr);
				
				//TODO
				
				}  else System.out.println("Not a positive integer found... Goodbye!");
			} else System.out.println("You've entered only one value... Goodbye!");
		} else System.out.println("You've entered no values... Goodbye!");
		
		System.out.println("Press ENTER to exit");
		inputedValue = in.nextLine();
	}
	
	static int[] intArray(String s) {
		int[] arr = new int[100];
		Arrays.fill(arr, -10); //let's mask unneeded values of array
		
		int currrentIndex = 0;
		int spaceIndex = 0;
		int arrIndex = 0;
		int length = s.length();
		String numberStr;
		
		do {
			spaceIndex = s.indexOf(" ", currrentIndex);
			if (spaceIndex>=0) numberStr = s.substring(currrentIndex, spaceIndex);
			else numberStr = s.substring(currrentIndex, length);
			
			if (PrimeNumbers.isIntegerNumber(numberStr)) {
				arr[arrIndex] = (Integer.valueOf(numberStr)).intValue();
				arrIndex++;
				currrentIndex = spaceIndex +1;
			} else {
				System.out.println("Not a positive number: " + numberStr + "! Goodbye!");
				arr[100]=-1; //means ERROR
				break;
			}
		} while ((spaceIndex < length) && (spaceIndex > 0));
		System.out.println("arr = " + Arrays.toString(arr));
		return arr;
	}
}