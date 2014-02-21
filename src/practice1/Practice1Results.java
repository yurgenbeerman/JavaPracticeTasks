package practice1;

/*************
* Author: Yuri Pyvovarenko
*/

/**
all tasks are described at https://learning.globallogic.com/moodle/mod/page/view.php?id=23 and in each *.class


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