/*
 * PrimeNumbers.java  0.4 2014/02/25
 *
 * This code is created for self educational purpose, so anyone can use it. Author rights reserved.
 */

 
package edu.practice1;

import java.util.*;
import edu.practice1.Utils;
import edu.practice1.Messages;

/**
 * Java SE Basics Practice 1
 * Task 1. Prime Numbers
 * The PrimeNumbers.taskResult() is called from Practice1Results class.
 * 
 * Business-Logic Requirements:
 * Program should find prime numbers which are smaller or equal to the inputted from keyboard integer number. Prime numbers - integral numbers that are not evenly divisible by any other numbers except for themselves and 1. For example, for input number 6, the output of the program should be: [2, 3, 5].
 * Implementation Requirements:
 * The program should use next two nested loops and the modulus operator (%) to detect prime numbers
 * The program should expected input from the keyboard and show output to the screen
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
public class PrimeNumbers {

	static final boolean IS_TEST = false;

	public static void taskResult(boolean isPackageFinalized, Scanner input) {
		System.out.println("\n--- PrimeNumbers ---");
		
		if ((isPackageFinalized) && (!IS_TEST)) {
			Integer number = inputNumber(input);
			String primeNumbers = getPrimeNumbersString(number);
			if ( primeNumbers.equals("error") ) {
				System.out.println(Messages.NO_PRIME_NUMBER + number);
			} else {
				showResult(primeNumbers);
			}
		} else {
			runTests();
		}
	}
	/**
	 * getPrimeNumbersString receives integer value and returns "[list of of PrimeNumbers]" or "error" in case of error.
	 */
	static String getPrimeNumbersString(Integer number) {
		String result = "error";
		if (number > 1) {
			if (number.equals(2)) {
				result = "[2]";
			} else {
				result = "[2";
				for (int i = 3; i <= number; i++) {
					boolean isPrime = true;
					for(int j = 2; j < i; j++) {
						if ( 0 == i % j ) isPrime = false;
					}
					if (isPrime) result += ", " + i;
				}
				result += "]";
			}
		}
		return result;
	}
	
	static Integer inputNumber(Scanner input) {
//		Scanner in = new Scanner(System.in);
				
		/* get integer from User */
		String inputedValue;
		do {
			inputedValue = Utils.inputNotZeroString(input, Messages.ENTER_POSITIVE_INTEGER);
		} while (!Utils.checkLessThen10DigitsOnly(inputedValue));
		//in.close();
		return Integer.valueOf(inputedValue);
	}
	
	static void showResult(String s) {
		System.out.println(Messages.PRIME_NUMBERS_ARE + s);
	}
	
	static void runTests() {
		/* test checkLessThen10DigitsOnly */
		//Utils.runTests();
		
		/* test getPrimeNumbersString */
		String[][] testValuesAndRightResults = {
			{"6", "[2, 3, 5]"},
			{"8", "[2, 3, 5, 7]"},
			{"11", "[2, 3, 5, 7, 11]"},
			{"1", "error"},
			{"2", "[2]"},
			{"0", "error"},
			{"-1", "error"}
		};
		boolean isOk = false;
		Integer number;
		for (String[] pairOfStrings : testValuesAndRightResults) {
			number = Integer.valueOf(pairOfStrings[0]);
			String primeNumbers = getPrimeNumbersString(number);

			/* for Automated tests */
			isOk = primeNumbers.equals(pairOfStrings[1]);

			/* for Manual tests: */
			System.out.println("For initial value of " + pairOfStrings[0] + " calculated: " + primeNumbers + ". Right result: " + pairOfStrings[1] +
				((isOk) ? " - OK" : " - are different. ERROR!"));
		}
	}
}