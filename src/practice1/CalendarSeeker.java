package practice1;

/*************
* Author: Yuri Pyvovarenko
*/

/**
https://learning.globallogic.com/moodle/mod/page/view.php?id=23
4. Calendar Seeker
Business-Logic Requirements:
Implement a program that prints out the day of the week for a given day (1..31), month (1..12) and year. For example, for a given input "10 October 2010" it should print to the screen "Sunday"

General requirements to applications are:
	•    Application must have accessible User Interface;
	•    Application must have foolproof (check of entering data);
	•    Application must be developed with minimum number of Java base classes – all the rest must be implemented autonomously. For example, Calendar Seeker can be easily implemented with the help of Date class but is very inappropriate in this module.
	•    Application with its interim releases must be placed in SVN repository. 
	•    When writing a code try to make it self-explanatory, but not confusing.
*/
import java.util.*;
import java.lang.String;

public class CalendarSeeker {

	static final boolean IS_TEST = true;

	public static void taskResult() {
		System.out.println("--- CalendarSeeker ---");

		if (!IS_TEST) {
			MyDate date = inputDate();
			date.dayOfWeek();
		} else {
			runTests();
		}
	}
	enum DaysOfWeek {"Sunday","Monday","Tuesday","Wednesday","Thrursday","Fryday","Saturday"
	
	}
	static class MyDate {
		String day = "15";
		String month = "October";
		String year = "1582";
		
		public MyDate(String aday, String amonth, String ayear) {
			day = aday;
			month = amonth;
			year = ayear;
		}
		
		protected void dayOfWeek() {
			System.out.println(
				"We'll try to find out dayOfWeek for day = "  + day
				+ ", month = "  + month
				+ ", year = "  + year
			);
			
			int a = (14 – month) / 12;
			int y = year - a;
			int m = month + 12 * a - 2;
			int weekDay = (7000 + (day + y + y / 4 – y / 100 + y / 400 + (31 * m) / 12)) % 7;
			
			switch weekDay
			case 0:

		}
	}
	
	static MyDate inputDate() {
		Scanner in = new Scanner(System.in);
		
		//get integer from User
		String inputedValue = new String();
		boolean isValid = false;
		String day, month, year;
		day = month = year = "";
		do {
			System.out.println("Please enter a date in format 10 October 2013: ");
			inputedValue = in.nextLine();
			
			inputedValue.trim();
			//get parts of date
			int startIndex = 0;
			int endIndex = inputedValue.indexOf(" ");
			if (endIndex > 0) {
				day = inputedValue.substring(0,endIndex);
				startIndex = endIndex+1;
				endIndex = inputedValue.indexOf(" ", startIndex);
				if (endIndex > startIndex) {
					month = inputedValue.substring(startIndex,endIndex);
					startIndex = endIndex+1;
					if (month.length() > 2) {
						year = inputedValue.substring(startIndex,inputedValue.length());
						if (year.length() == 4) isValid = true;
						else System.out.println("The year can not be recognized!");
					} else System.out.println("The month can not be recognized!");
				} else System.out.println("No second delimiter found. The month can not be recognized!");
			} else System.out.println("No delimiters found. The date can not be recognized!");
		} while (!isValid);
		
		System.out.println("Thank you. The date looks like valid.");
		
		MyDate date = new MyDate(day, month, year);
		
		return date;
	}

	static void runTests() {
		//String dateValue="10 October 2010";
		MyDate date = new MyDate("10", "October", "2010");
		date.dayOfWeek();
	}
}
