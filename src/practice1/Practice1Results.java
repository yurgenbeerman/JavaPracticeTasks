package practice1;

/*************
* Author: Yuri Pyvovarenko
*/

/**
all tasks are described at https://learning.globallogic.com/moodle/mod/page/view.php?id=23 and in each *.class
*/
import practice1.*;

public class Practice1Results{

	static final boolean IS_DONE = false;
	
	public static void main(String[] args) {

		if (IS_DONE) {
			//done tasks
			PrimeNumbers.taskResult();
			NeighbouringNumbers.taskResult();

			CalendarSeeker.taskResult();
		} else {
			//tasks in process
			Anagram.taskResult();
		}
	}
}