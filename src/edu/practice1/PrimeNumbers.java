package practice1;

/*************
* Author: Yuri Pyvovarenko
*/

/**
Java SE Basics Practice 1
1. Prime Numbers
Business-Logic Requirements:
Program should find prime numbers which are smaller or equal to the inputted from keyboard integer number. Prime numbers - integral numbers that are not evenly divisible by any other numbers except for themselves and 1. For example, for input number 6, the output of the program should be: [2, 3, 5].
Implementation Requirements:
The program should use next two nested loops and the modulus operator (%) to detect prime numbers
The program should expected input from the keyboard and show output to the screen

General requirements to applications are:
	•    Application must have accessible User Interface;
	•    Application must have foolproof (check of entering data);
	•    Application must be developed with minimum number of Java base classes – all the rest must be implemented autonomously. For example, Calendar Seeker can be easily implemented with the help of Date class but is very inappropriate in this module.
	•    Application with its interim releases must be placed in SVN repository. 
	•    When writing a code try to make it self-explanatory, but not confusing.
*/
import java.util.*;

public class PrimeNumbers {

	static final boolean IS_TEST = false;

	public static void taskResult(boolean isPackageFinalized) {
		System.out.println("\n--- PrimeNumbers ---");
		
		if ((isPackageFinalized) && (!IS_TEST)) {
			Integer num = inputNumber();
			
			if (num > 2) {
				String resultStr = "[2";

				//collect all the prime numbers to resultStr
				for (int i = 3; i <= num; i++) {

					//check if it is a Prime number
					boolean isPrime = true;
					for(int j = 2; j < i; j++) {
						if ( 0 == i % j ) isPrime = false;
					}
					
					if (isPrime) resultStr += ", " + i;
				}
				
				showResult(resultStr + "]");
				
			} else {
				if (num.equals(2)) showResult("[2]");
				else System.out.println("There's no prime number which is smaller or equal to " + num);
			}
		} else {
			runTests();
		}
	}

	
	static void runTests() {
		System.out.println("isNotNegativeIntegerNumber |12q|" + isNotNegativeIntegerNumber("12q"));
		System.out.println("isNotNegativeIntegerNumber |1.2|" + isNotNegativeIntegerNumber("1.2"));
		System.out.println("isNotNegativeIntegerNumber |1,2|" + isNotNegativeIntegerNumber("1,2"));
		System.out.println("isNotNegativeIntegerNumber |12|" + isNotNegativeIntegerNumber("12"));
		System.out.println("isNotNegativeIntegerNumber |000|" + isNotNegativeIntegerNumber("000"));
		System.out.println("isNotNegativeIntegerNumber |-0|" + isNotNegativeIntegerNumber("-0"));
		System.out.println("isNotNegativeIntegerNumber ||" + isNotNegativeIntegerNumber(""));
		System.out.println("isNotNegativeIntegerNumber | |" + isNotNegativeIntegerNumber(" "));
	}
	
	public static boolean isNotNegativeIntegerNumber(String s) {
		boolean isDigit = false;

		//go through all string symbols and check if they are digits
		for (int i = 0; i < s.length(); i++) {
			Character symbol = s.charAt(i);		
			//compare the symbol to all digits 0..9
			for(Integer j = 0; j < 10; j++) {
				isDigit = false;
				String digit = j.toString();
				if ( (symbol.toString()).equals(digit) ) {
					isDigit = true;
					break;
				}
			}

			if (!isDigit) break;
		}
		
		return isDigit;
	}
	
	static Integer inputNumber() {
		Scanner in = new Scanner(System.in);
		
		//get integer from User
		String inputedValue = new String();
		do {
			System.out.println("Please enter a positive integer number: ");
			inputedValue = in.nextLine();
		} while (!isNotNegativeIntegerNumber(inputedValue));
		
		return Integer.valueOf(inputedValue);
	}
	
	static void showResult(String s) {
		System.out.println("The prime numbers which are smaller or equal to the inputted are: " + s);
	}
}