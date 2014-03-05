/*
 * NeighbouringNumbers.java  0.4 2014/02/25
 *
 * This code is created for self educational purpose, so anyone can use it. Author rights reserved.
 */

 
package edu.practice1;

import edu.practice1.Utils;
import java.util.*;

/**
 * Java SE Basics Practice 1
 * Task 2. Arrays - neighbouring numbers
 * The NeighbouringNumbers.taskResult() is called from Practice1Results class.
 * 
 * Business-Logic Requirements:
 * Find two neighbouring numbers in an array with the smallest distance to each other.
 * The index of the first number should be outputted to the screen. For example, in the
 * sequence 4 8 6 1 2 9 4 the minimum distance is 1 (between 1 and 2).
 * The function should return the index 3 (of number 1).
 * If ecxists more than one decision should be outputted only a first one.
 * Implementation Requirements:
 * All input should be get from keyboard
 * 
 * Use runTest() method for tests.
 *
 * @version 	0.4 25 Feb 2014
 * @author 	Yuri Pyvovarenko
 *
 * General requirements to applications are:
 * 		•    Application must have accessible User Interface;
 * 		•    Application must have foolproof (check of entering data);
 * 		•    Application must be developed with minimum number of Java base classes – all the rest must be implemented autonomously. For example, Calendar Seeker can be easily implemented with the help of Date class but is very inappropriate in this module.
 * 		•    Application with its interim releases must be placed in SVN repository. 
 * 		•    When writing a code try to make it self-explanatory, but not confusing.
*/
public class NeighbouringNumbers{

	static final boolean IS_TEST = false;
	
	public static void taskResult(boolean isPackageFinalized, Scanner input) {
		System.out.println("\n--- NeighbouringNumbers ---");

		//Scanner in = new Scanner(System.in);
		String inputedValue = new String();

		if ((isPackageFinalized) && (!IS_TEST)) {
			System.out.println(Messages.ENTER_INTEGERS_THROUGH_SPACES);
			inputedValue = input.nextLine();
			//in.close();
			int index = findNearestNeigboursIndex(inputedValue);
			if ( index < 0 ) {
				System.out.println(Messages.ERROR_OCCURED);
			} else {
				System.out.println(Messages.NEAREST_NEIGHBOUR + index);
			}
		} else {
			runTests();
		}
	}

	static final int ARR_LENGTH = 100; 						// Max size of aray to store entered numbers
	static final int MASK_VALUE = -10;
	static final int ERROR_VALUE = -1;
	
	static int findNearestNeigboursIndex(String inputedValue) {
		int result = -1;
		if (inputedValue.length() > 0) {
		
			inputedValue = inputedValue.trim();
			//System.out.println("inputedValue=|" + inputedValue + "|");
			
			if (inputedValue.indexOf(" ") > 0) {
			
				int[] array = convertToIntArray(inputedValue);
				if (array[ARR_LENGTH-1] != ERROR_VALUE) { 						// if there was no error in convertToIntArray()
				
					/* arrayCopy must contain only needed values from array */
					int lastNumberIndex = 0;
					do lastNumberIndex++;
					while ((array[lastNumberIndex] >= 0) && (lastNumberIndex < array.length));
					int[] arrayCopy = Arrays.copyOf(array, lastNumberIndex);

					/* There are 16 neighbours for 1 2 1 2 1 2 1 2
					 * 30 neighbours for 1 2 1 2 1 2 1 2 1 2 1 etc. -- complex log formula?
					 * I decided to use ARR_LENGTH as number of ints to store neigbours indexes
					 */				
					int[] allNeigboursIndexes = new int[ARR_LENGTH];
					int[] distances = new int[ARR_LENGTH];
					
					/* find all neighbours and calculate distances between them */
					int neighboursIndex=0;
					for(int i = 0; i < lastNumberIndex-1; i++) {
						for (int j = i+1; j < lastNumberIndex; j++) {
							if ((1 == arrayCopy[i]-arrayCopy[j]) || (-1 == arrayCopy[i]-arrayCopy[j])) {
								allNeigboursIndexes[neighboursIndex] = i;
								distances[neighboursIndex] = j-i;
								neighboursIndex++;
							}
						}
					}
									
					if (neighboursIndex > 0) {
						//System.out.println("allNeigboursIndexes = " + Arrays.toString(allNeigboursIndexes));
						//System.out.println("distances = " + Arrays.toString(distances));
						int index = 0;
						for(int i = 1; i < neighboursIndex; i++) {
							if (distances[i] < distances[index]) {
								index = i;
							} else if ((distances[i] == distances[index])
										&& (allNeigboursIndexes[i] < allNeigboursIndexes[index])) {
								index = allNeigboursIndexes[i];
							}
						}	
						result = allNeigboursIndexes[index];
					} //else System.out.println("There's no neigbours. Goodbye!");
				}  //else System.out.println("Not a positive integer found... Goodbye!");
			} //else System.out.println("You've entered only one value... Goodbye!");
		} //else System.out.println("You've entered no values... Goodbye!");
		
		return result;
	}
	
	static int[] convertToIntArray(String s) {
		int[] result = new int[ARR_LENGTH];
		Arrays.fill(result, MASK_VALUE); 					//let's mask unneeded values of array
		
		int currrentIndex = 0;
		int spaceIndex = 0;
		int arrIndex = 0;
		int length = s.length();
		String numberString;
		
		do {
			spaceIndex = s.indexOf(" ", currrentIndex);
			if (spaceIndex>=0) numberString = s.substring(currrentIndex, spaceIndex);
			else numberString = s.substring(currrentIndex, length);
			
			if (Utils.checkLessThen10DigitsOnly(numberString)) {
				result[arrIndex] = (Integer.valueOf(numberString)).intValue();
				arrIndex++;
				currrentIndex = spaceIndex +1;
			} else {
				//System.out.println("Not a positive number: " + numberString + "! Goodbye!");
				result[ARR_LENGTH-1]=ERROR_VALUE; 							//means ERROR
				break;
			}
		} while ((spaceIndex < length) && (spaceIndex > 0));
		
		return result;
	}
	
	/* printIntArr prints array without mask-values -- was used for debugging */
	static void printIntArr(int[] array) {
		if (array != null) {
			int i = 0;
			System.out.print("[");
			while (( array[i] != MASK_VALUE ) && ( i < array.length )){
				System.out.print(" " + array[i]);
				i++;
			}
			System.out.println(" ]");
		}
	}
	
	static void runTests() {
		
		String[][] testValuesAndRightResults = {
			{"4 8 6 1 2 9 4", "3"},
			{"1 2", "0"},
			{" 1 2 ", "0"},
			{" 3 9 7 5 6 ", "3"},
			{"4 8 6 1 2 9 4 9", "3"},
			{" 2 2 1 1 2 2", "1"},
			{"1 0 3 2 1 3 5 4 6 9", "0"},
			{" 1 2 1 2 1 2 1 2 1 2 1 ", "0"},
			{"9 7 1 4 2 3  ", "4"},
			{"1 7 5 9 2 6  ", "2"}
		};
		boolean isOk = false;
		Integer number;
		Integer calculatedNumber;
		Integer rightNumber;
		for (String[] pairOfStrings : testValuesAndRightResults) {
			calculatedNumber = Integer.valueOf(findNearestNeigboursIndex(pairOfStrings[0]));
			rightNumber = Integer.valueOf(pairOfStrings[1]);

			/* for Automated tests */
			isOk = rightNumber.equals(calculatedNumber);

			/* for Manual tests: */
			System.out.println("For initial value of " + pairOfStrings[0] + " calculated: " + calculatedNumber + ". Right result: " + pairOfStrings[1] +
				((isOk) ? " - OK" : " - are different. ERROR!"));
		}
	}
}