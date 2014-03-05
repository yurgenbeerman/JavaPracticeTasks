/*
 * CalendarSeeker.java  0.6 2014/02/26
 *
 * This code is created for self educational purpose, so anyone can use it. Author rights reserved.
 */


package edu.practice1;

import java.util.*;
import java.lang.String;
import edu.practice1.Utils;

/**
 * Java SE Basics Practice 1
 * Task 4. Calendar Seeker
 * The CalendarSeeker.taskResult() is called from Practice1Results class.
 * 
 * Business-Logic Requirements:
 * Implement a program that prints out the day of the week for a given day (1..31), month (1..12) and year. For example, for a given input "10 October 2010" it should print to the screen "Sunday"
 * 
 * Use runTest() method for tests.
 *
 * @version 	0.5 25 Feb 2014
 * @author 	Yuri Pyvovarenko
 *
 * General requirements to applications are:
 * 		•    Application must have accessible User Interface;
 * 		•    Application must have foolproof (check of entering data);
 * 		•    Application must be developed with minimum number of Java base classes – all the rest must be implemented autonomously. For example, Calendar Seeker can be easily implemented with the help of Date class but is very inappropriate in this module.
 * 		•    Application with its interim releases must be placed in SVN repository. 
 * 		•    When writing a code try to make it self-explanatory, but not confusing.
*/
public class CalendarSeeker {

	static final boolean IS_TEST = false;
	
	/** taskResult is called from Practice1Results class */
	public static void taskResult(boolean isPackageFinalized, Scanner input) {
		System.out.println("\n--- CalendarSeeker ---");

		if ((isPackageFinalized) && (!IS_TEST)) {
			MyDate date = inputDate(input);
			if (null != date) {
				System.out.println("We'll try to find out DayOfWeek for "  + date.toString());
				String weekDay = getDayOfWeek(date);
				if (weekDay.equals(Messages.ERROR_OCCURED)) {
					System.out.println(Messages.ERROR_OCCURED);
				} else {
					System.out.println("It is " + weekDay);
				}
			}
		} else {
			runTests();
		}
	}
	
	/** isLeapYear() static method is public to be used not only in this class. */
	public static boolean isLeapYear(int year) {
		boolean isLeap = false;
		if ((year % 100 == 0) && (year % 400 != 0)) {
			isLeap = false;
		} else if (0 == year % 4) {
			isLeap = true;
		}
		return isLeap;
	}
	
	
	/**
	 * Class MyDate is used mainly to store date value parts in a set of String and int variables.
	 * It has no user interface output.
	 * Zero values of int variables mean an error in data received by constructor or in internal calculations.
	 */
	static class MyDate {
		String day = "0";
		String month = "0";
		String year = "0";
		int intYear = 0;
		int intDay = 0;
		int intMonth = 0;
		int maxDaysInMonth = 0; 					 // must be updated by getIntMonth() BEFORE getIntDay() call!
		
		/**
		 * Constructor takes String parameters and assignes int values of the year, month and day.
		 * If an int value equals zero it means that value was not defined properly (error occured).
		*/
		public MyDate(String aday, String amonth, String ayear) {
			day = aday;
			month = amonth;
			year = ayear;
			intYear = getIntYear(); 			//must be calculated FIRST!
			intMonth = getIntMonth(); 		//must be calculated SECOND. It will set maxDaysInMonth according to the month. Number of days in February depends on leap year.
			maxDaysInMonth = Utils.Months.getMaxDaysInMonth(intMonth, isLeapYear(intYear));
			intDay = getIntDay(); 				//must be calculated THIRD! For instance the number of days in February (it's number should be calculates before) depends on leap year.
		}
		
		/** getIntYear() must be called FIRST when getting integer values of year, month and day! */
		int getIntYear() { 
			if (Utils.checkLessThen10DigitsOnly(year)) {
				return (Integer.valueOf(year)).intValue();
			} else {
				return 0;
			}
		}
		
		/** getIntDay() must be called THIRD when getting integer values of year, month and day! */
		int getIntDay() { 
			if (Utils.checkLessThen10DigitsOnly(day)) {
				int monthDayNumber = (Integer.valueOf(day)).intValue();
				if (monthDayNumber <= maxDaysInMonth) {
					return monthDayNumber;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		}
		
		/** getIntMonth() must be called SECOND when getting integer values of year, month and day! */
		//TODO -- recode as enum
		int getIntMonth() {
			return Utils.Months.getMonthNumber(month);
		}
		
		/** toString() method is overrided here*/
		public String toString() {
			return ("day = " + day + ", month = "  + month + ", year = "  + year);
		}
	}

	
	/** printDayOfWeek() calculates and outputs the day of week based on MyDate instance received. */
	/* see algorythms:
	 * http://base.vingrad.ru/view/3139-vyichislenie-dnya-nedeli-po-date
	 * http://ru.wikibooks.org/wiki/Алгоритм_вычисления_дня_недели
	 * http://www.distedu.ru/mirror/_math/algolist.manual.ru/misc/yearweek.php
	 */
	static String getDayOfWeek(MyDate date) {
		String result = Messages.ERROR_OCCURED;
		if (null != date) {
			if ( (date.intDay > 0) && (date.intMonth > 0) && (date.intYear > 0)) {
				int a = (14 - date.intMonth) / Utils.WEEKDAY_TOTAL_MONTHS;
				int y = date.intYear - a;
				int m = date.intMonth + Utils.WEEKDAY_TOTAL_MONTHS * a - 2;
				int weekDay = 	(Utils.WEEKDAY_CONST1 +
											(date.intDay + y + y / 4 - y / Utils.WEEKDAY_CONST2 +
												y / Utils.WEEKDAY_CONST3 + 
												(Utils.WEEKDAY_MONTH_MAX_DAYS * m) /
													Utils.WEEKDAY_TOTAL_MONTHS
											)
										) % Utils.WEEKDAY_TOTAL_DAYS;
				
				result = Utils.DAYS_OF_WEEK[weekDay];
			} //else System.out.println("Entered data is wrong!");
		} //else System.out.println("Wrong data! Goodbye!");
		return result;
	}
	
	/* inputDate() is to get date from user or exit the app. */
	static MyDate inputDate(Scanner input) {
		//Scanner input = new Scanner(System.in);
		String inputedValue = Utils.inputNotZeroString(input, Messages.ENTER_DATE);
		//input.close();		
		MyDate result = castStringToMyDateObject(inputedValue);
		return result;
	}

	/* Casting String to MyDate. */
	static MyDate castStringToMyDateObject(String inputedValue) {
		String day = "";
		String month = "";
		String year = "";
		MyDate result = null;

		String[] arguments = inputedValue.trim().split(" ");
		if (3 == arguments.length) {
			result = new MyDate(arguments[0], arguments[1], arguments[2]);
		}
		
		/* get and preliminary test parts of date */
		//inputedValue = inputedValue.trim();
		/*
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
					if ((year.length() > 0) && (year.length() < 10)){
						//System.out.println("Thank you. The date looks like valid.");
						result = new MyDate(day, month, year);
					}
					else System.out.println("The year is zero or too long for processing!");
				} else System.out.println("The month can not be recognized!");
			} else System.out.println("No second delimiter found. The month can not be recognized!");
		} else System.out.println("No delimiters found. The date can not be recognized!");
		*/
		return result;
	}
		
	static void runTests() {
		/* dateString in tests should be trimmed, OR need to uncomment trim() call in method above */
		String[] dateStrings = {
			"28 FEBRuary 2014",
			"10 janUARY 10000",
			"  10 janUARY 10000  ",
			"10 October 20100999999990",
			"10 October 201099999",
			"28 FEBRuary 2014 q",
			"de dce c",
			"29 january YYYY",
			"29 FEBRuary 2014",
			"90 FEBRuary 1111",
			"9 FEBRuary 0000",
			"00 december 9999",
			"10 Octobbb 2010"
		};
		MyDate date = null;

		for(String dateStringToProcess : dateStrings) {
			date = castStringToMyDateObject(dateStringToProcess);
			System.out.println("\nTest string: " + dateStringToProcess + ". Result = " + getDayOfWeek(date));
		}
		
		/* leapYear tests */
		int[] years = {1300, 2012, 2014};
		for(int yearToTest : years) {
			System.out.println("\nTest if year " + yearToTest + " is leap: " + isLeapYear(yearToTest));
		}
	}
}