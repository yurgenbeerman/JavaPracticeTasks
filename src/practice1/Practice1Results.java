package practice1;

/*************
* Author: Yuri Pyvovarenko
*/

/**
https://learning.globallogic.com/moodle/mod/page/view.php?id=23

2. Arrays - neighbouring numbers
Business-Logic Requirements:
Find two neighbouring numbers in an array with the smallest distance to each other. The index of the first number should be outputted to the screen. For example, in the sequence 4 8 6 1 2 9 4 the minimum distance is 1 (between 1 and 2). The function should return the index 3 (of number 1).
If ecxists more than one decision should be outputted only a first one.
Implementation Requirements:
All input should be get from keyboard

3. Anagram
Business-Logic Requirements:
An anagram is a word or a phrase that can be created by rearranging the letters of another given word or phrase. We ignore white spaces and letter case. The all letters of "Desperation" can be rearranged to the phrase "A Rope Ends It". The program should receive input of two strings and give the output to screen telling whether these words are anagrams

4. Calendar Seeker
Business-Logic Requirements:
Implement a program that prints out the day of the week for a given day (1..31), month (1..12) and year. For example, for a given input "10 October 2010" it should print to the screen "Sunday"
*/
import practice1.*;

public class Practice1Results{
	public static void main(String[] args) {

		//PrimeNumbers.taskResult();
		
		NeighbouringNumbers.taskResult();
		
		/*		
		Anagram.taskResult();
		 
		CalendarSeeker.taskResult();
		*/
	}
}