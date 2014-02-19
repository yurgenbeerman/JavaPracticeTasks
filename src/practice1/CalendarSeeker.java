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
import practice1.*;

public class CalendarSeeker {

	static final boolean IS_TEST = false;

	public static void taskResult() {
		System.out.println("--- CalendarSeeker ---");

		if (!IS_TEST) {
			MyDate date = inputDate();
			if (null != date) date.printDayOfWeek();
		} else {
			runTests();
		}
	}
	
	static class MyDate {
		String day = "15";
		String month = "October";
		String year = "1582";
		DaysOfWeek dayOfWeek;
		
		public MyDate(String aday, String amonth, String ayear) {
			day = aday;
			month = amonth;
			year = ayear;
		}
		
		protected void printDayOfWeek() {
			System.out.println(
				"We'll try to find out DayOfWeek for day = "  + day
				+ ", month = "  + month
				+ ", year = "  + year
			);
			int intDay = getIntDay();
			int intMonth = getIntMonth();
			int intYear = getIntYear();
			
			if ( (intDay > 0) && (intMonth > 0) && (intYear > 0)) {
				int a = (14 - intMonth) / 12;
				int y = intYear - a;
				int m = intMonth + 12 * a - 2;
				int weekDay = (7000 + (intDay + y + y/4 - y/100 + y/400 + (31*m)/12)) % 7;
				
				boolean isOk = false;
				//practice of emun usage
				switch (weekDay) {
					case 0: dayOfWeek = DaysOfWeek.SU; isOk = true; break;
					case 1: dayOfWeek = DaysOfWeek.MO; isOk = true; break;
					case 2: dayOfWeek = DaysOfWeek.TU; isOk = true; break;
					case 3: dayOfWeek = DaysOfWeek.WE; isOk = true; break;
					case 4: dayOfWeek = DaysOfWeek.TH; isOk = true; break;
					case 5: dayOfWeek = DaysOfWeek.FR; isOk = true; break;
					case 6: dayOfWeek = DaysOfWeek.SA; isOk = true; break;
					default: System.out.println("Error in calculations of weekDay");
				}
				
				if (isOk) System.out.println("It is " + dayOfWeek.getName());
			} else System.out.println("Wrong data! Goodbye!");
		}
		
		int getIntDay() {
			if (PrimeNumbers.isIntegerNumber(day)) return (Integer.valueOf(day)).intValue();
			else return 0;
		}
		
		int getIntMonth() {
			int intMonth = 0;
			if (month.equalsIgnoreCase("january")) intMonth = 1;
			else if (month.equalsIgnoreCase("february")) intMonth = 2;
			else if (month.equalsIgnoreCase("march")) intMonth = 3;
			else if (month.equalsIgnoreCase("april")) intMonth = 4;
			else if (month.equalsIgnoreCase("may")) intMonth = 5;
			else if (month.equalsIgnoreCase("june")) intMonth = 6;
			else if (month.equalsIgnoreCase("july")) intMonth = 7;
			else if (month.equalsIgnoreCase("august")) intMonth = 8;
			else if (month.equalsIgnoreCase("september")) intMonth = 9;
			else if (month.equalsIgnoreCase("october")) intMonth = 10;
			else if (month.equalsIgnoreCase("november")) intMonth = 11;
			else if (month.equalsIgnoreCase("december")) intMonth = 12;
			return intMonth;
		}
		
		int getIntYear() {
			if (PrimeNumbers.isIntegerNumber(year)) return (Integer.valueOf(year)).intValue();
			else return 0;
		}
	}
	
	enum DaysOfWeek {
		SU("Sunday"),MO("Monday"),TU("Tuesday"),WE("Wednesday"),TH("Thursday"),FR("Friday"),SA("Saturday");
		DaysOfWeek(String name) {
			this.name = name;
		}
		private String name;
		public String getName() {
			return name;
		}
	}
	
	static MyDate inputDate() {
		Scanner in = new Scanner(System.in);
		
		String inputedValue = new String();
		
		MyDate date = null;
		do {
			System.out.println("Please enter a date in format 10 October 2013 (or EXIT to exit): ");
			inputedValue = (in.nextLine()).trim();
			
			if (inputedValue.equalsIgnoreCase("EXIT")) break;
			
			date = processDateString(inputedValue);
			
		} while (null == date);
		
		return date;
	}

	static MyDate processDateString(String inputedValue) {
	
		String day, month, year;
		day = month = year = "";
		
		MyDate date = null;
		
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
					if (year.length() == 4) {
						//System.out.println("Thank you. The date looks like valid.");
						date = new MyDate(day, month, year);
					}
					else System.out.println("The year can not be recognized!");
				} else System.out.println("The month can not be recognized!");
			} else System.out.println("No second delimiter found. The month can not be recognized!");
		} else System.out.println("No delimiters found. The date can not be recognized!");
		
		return date;
	}
		
	static void runTests() {
		String dateValue="10 October 2010";
		MyDate date = processDateString(dateValue); //new MyDate("10", "October", "2010");
		date.printDayOfWeek();
		
		dateValue="17 FEBRuary 2014";
		date = processDateString(dateValue); //new MyDate("10", "October", "2010");
		date.printDayOfWeek();
		
		dateValue="19 FEBRuary 2014";
		date = processDateString(dateValue); //new MyDate("10", "October", "2010");
		date.printDayOfWeek();
		
		dateValue="01 FEBRuary 2054";
		date = processDateString(dateValue); //new MyDate("10", "October", "2010");
		date.printDayOfWeek();
		
		dateValue="01 FEBRuary 2014";
		date = processDateString(dateValue); //new MyDate("10", "October", "2010");
		date.printDayOfWeek();
	}
}
