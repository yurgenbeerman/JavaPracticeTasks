package practice1;

/*************
* Author: Yuri Pyvovarenko
*/

/**
Java SE Basics Practice 1


*/
import practice1.*;

public class Practice1Results{

	static final boolean IS_FINALIZED = true;
	
	public static void main(String[] args) {

		if (IS_FINALIZED) {
			//finalized tasks - to show
			PrimeNumbers.taskResult(IS_FINALIZED);
			NeighbouringNumbers.taskResult(IS_FINALIZED);			
			Anagram.taskResult(IS_FINALIZED);
			CalendarSeeker.taskResult(IS_FINALIZED);
		} else {
			//tasks in process - to test

		}
	}
}