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

public class NeighbouringNumbers{

	static final boolean IS_TEST = false;
	
	public static void taskResult() {
		System.out.println("\n--- NeighbouringNumbers ---");

		Scanner in = new Scanner(System.in);
		String inputedValue = new String();

		if (!IS_TEST) {
			System.out.println("Please enter positive integer numbers trough spaces: ");
			inputedValue = in.nextLine();
			findNearestNeigboursIndex(inputedValue);
		} else {
			runTests();
		}
	}

	static final int ARR_LENGTH = 100; //size of aaray to store entered numbers
	static final int MASK_VALUE = -10;
	static final int ERROR_VALUE = -1;
	
	static void findNearestNeigboursIndex(String inputedValue) {
	
		if (inputedValue.length() > 0) {
		
			inputedValue = inputedValue.trim();
			
			if (inputedValue.indexOf(" ") > 0) {
			
				int[] arr = convertToIntArray(inputedValue);
				
				if (arr[ARR_LENGTH-1] != ERROR_VALUE) { //if there was no error in intArray()
				
					//remove unneeded values from arr
					int lastNumberIndex = 0;
					do lastNumberIndex++;
					while ((arr[lastNumberIndex] >= 0) && (lastNumberIndex < arr.length));

					int[] arrCopy = Arrays.copyOf(arr, lastNumberIndex);
					
					int[] numbersIndexes = new int[ARR_LENGTH]; //16 for 1 2 1 2 1 2 1 2 , 30 for 1 2 1 2 1 2 1 2 1 2 1 etc. -- complex log formula?
					if (IS_TEST) Arrays.fill(numbersIndexes, MASK_VALUE); //need to mask for better test output 

					int[] distances = new int[ARR_LENGTH];
					if (IS_TEST) Arrays.fill(distances, MASK_VALUE); //need to mask for better test output 
					
					//find all neighbours
					int neighboursIndex=0;
					for(int i = 0; i < lastNumberIndex-1; i++) {
						
						for (int j = i+1; j < lastNumberIndex; j++) {
							if ((1 == arrCopy[i]-arrCopy[j]) || (-1 == arrCopy[i]-arrCopy[j])) {
								numbersIndexes[neighboursIndex] = i;
								distances[neighboursIndex] = j-i;
								neighboursIndex++;
							}
						}
					}
									
					if (neighboursIndex-1 > 0) {
						if (IS_TEST) System.out.println("         arrCopy = " + Arrays.toString(arrCopy));
						if (IS_TEST) System.out.println("          Indexes = 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10");
						if (IS_TEST) System.out.print("  numbersIndexes = "); printIntArr(numbersIndexes);//Arrays.toString(numbersIndexes));
						if (IS_TEST) System.out.print("       distances = "); printIntArr(distances);//Arrays.toString(distances));

						//find the nearest neighbours						
						int nearestIndex = 0;
						for(int i = 1; i < neighboursIndex; i++)
							if (distances[i] < distances[nearestIndex]) nearestIndex = i;
							else if ((distances[i] == distances[nearestIndex]) && (numbersIndexes[i] < numbersIndexes[nearestIndex])) nearestIndex = numbersIndexes[i];
							
						System.out.println("NEAREST neigbour number index = " + numbersIndexes[nearestIndex]);
						
					} else System.out.println("There's no neigbours. Goodbye!");
				}  else System.out.println("Not a positive integer found... Goodbye!");
			} else System.out.println("You've entered only one value... Goodbye!");
		} else System.out.println("You've entered no values... Goodbye!");
	}
	
	static void printIntArr(int[] arr) {
		if (arr != null) {
			int i=0;
			System.out.print("[");
			while ((arr[i] != MASK_VALUE) && (i < arr.length)){
				System.out.print(" " + arr[i]);
				i++;
			}
			System.out.println(" ]");
		}
	}
	
	static int[] convertToIntArray(String s) {
		int[] arr = new int[ARR_LENGTH];
		Arrays.fill(arr, MASK_VALUE); //let's mask unneeded values of array
		
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
				arr[ARR_LENGTH-1]=ERROR_VALUE; //means ERROR
				break;
			}
		} while ((spaceIndex < length) && (spaceIndex > 0));
		
		return arr;
	}
	static void runTests() {
		String testString = " 3 9 7 5 6 ";
		System.out.println("\nfindNearestNeigboursIndex for string: " + testString);
		findNearestNeigboursIndex(testString);

		testString = "4 8 6 1 2 9 4 9";
		System.out.println("\nfindNearestNeigboursIndex for string: " + testString);
		findNearestNeigboursIndex(testString);
		
		testString = " 2 2 1 1 2 2";
		System.out.println("\nfindNearestNeigboursIndex for string: " + testString);
		findNearestNeigboursIndex(testString);
		
		testString = "1 0 3 2 1 3 5 4 6 9";
		System.out.println("\nfindNearestNeigboursIndex for string: " + testString);
		findNearestNeigboursIndex(testString);

		testString = " 1 2 1 2 1 2 1 2 1 2 1 ";
		System.out.println("\nfindNearestNeigboursIndex for string: " + testString);
		findNearestNeigboursIndex(testString);
		//System.out.println("Press ENTER to exit"); inputedValue = in.nextLine();
	}
}