package practice1;

/*************
* Author: Yuri Pyvovarenko
*/

/**
https://learning.globallogic.com/moodle/mod/page/view.php?id=23
4. Calendar Seeker
Business-Logic Requirements:
Implement a program that prints out the day of the week for a given day (1..31), month (1..12) and year. For example, for a given input "10 October 2010" it should print to the screen "Sunday"
*/
import practice1.*;

public class Practice1Results{

	static final boolean IS_TEST = true;
	
	public static void main(String[] args) {

		if (!IS_TEST) {
			//done tasks
			PrimeNumbers.taskResult();
			NeighbouringNumbers.taskResult();
			Anagram.taskResult();
		} else {
			//in work tasks
			
			//CalendarSeeker.taskResult();
		}
	}
}