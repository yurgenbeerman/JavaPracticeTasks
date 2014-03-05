/*
 * Practice1Results.java		0.4 2014/02/25
 *
 * This code is created for self educational purpose, so anyone can use it. Author rights reserved.
 */


package edu.practice1;

import edu.practice1.*;
import java.util.*;

/**
 * Java SE Basics Practice 1
 * The Practice1Results class calls taskResult() methods of other classes that solve different learning tasks:
 * 		 + PrimeNumbers.java
 * 		 + NeighbouringNumbers.java
 * 		 + Anagram.java
 * 		 + CalendarSeeker.java
 *
 * To test all learning tasks add "test" argument at java Practice1Results command line call.
 * Then taskResult() of each class will call own runTest() method.
 *
 * @version 		0.4 25 Feb 2014
 * @author 		Yuri Pyvovarenko
*/
public class Practice1Results {

	static final boolean IS_FINALIZED = true;
	
	public static void main(String[] args) {
		boolean ifRunTests = !IS_FINALIZED;
		
		/* check if "test" argument was passed */
		if (null != args) {
			if (0 < args.length) {
				//System.out.println("args[0] = |" + args[0] + "|");
				if ("test".equals(args[0])) {
					ifRunTests = true;
				}
			}
		}
		
		if (ifRunTests) {
			/*Put here calls of tasks in process - to test: */
			PrimeNumbers.taskResult(!ifRunTests, null);
			NeighbouringNumbers.taskResult(!ifRunTests, null);	
			Anagram.taskResult(!ifRunTests, null); 
			CalendarSeeker.taskResult(!ifRunTests, null);
		} else {
			/* we will need an input stream */
			Scanner input = new Scanner(System.in);

			/*Put here calls of all finalized tasks - to show: */
			PrimeNumbers.taskResult(!ifRunTests, input);
			NeighbouringNumbers.taskResult(!ifRunTests, input);	
			Anagram.taskResult(!ifRunTests, input); 
			CalendarSeeker.taskResult(!ifRunTests, input);
			
			input.close();
		}
	}
}