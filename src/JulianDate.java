/*
    @author: Alina Khairullina, Zhasmina Dimova, Ibrahim Soueid
    @version: 2018.05.15 
 */

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;

public class JulianDate {

	//1st date - Jan 1583 - 1
	public static double start = 2299238.5 - 1;
	private double julianToday; // today's Julian date
	private double julianUserDate; // another Julian date
	private double julianBetweenDates; // difference between two dates
	private double julianAnyDate;

	public static void main(String[] args) {
		JulianDate julianDateToday = JulianDate.julianToday();
		JulianDate julianDateAny = JulianDate.julianUserDate();
		JulianDate julianBetweenDate = JulianDate.julianBetweenDates();
		JulianDate julianAnyDate = JulianDate.julianAnyDateInJulian();
		System.out.println();
		System.out.println("According to the Julian Calendar, today is: " + julianDateToday.getJulianToday());
		System.out.println("The Julian date for the given date is: " + julianDateAny.getJulianUserDate());
		System.out.println("The Julian date beween these two date is:" + julianBetweenDate.getJulianBetweenDates());
	}

	public static JulianDate julianAnyDateInJulian() {
		// obtains an instance of LocalDate from a text string
		LocalDate givenDate = LocalDate.parse("1993-09-28");
		double julianDays = start; // counts from the 1st Jan 1583 3
		int givenYear = givenDate.getYear(); // the year of our new date
		for (int i = 1583; i < givenYear; i++) {
			LocalDate date = LocalDate.parse(i + "-01-01");
			julianDays = julianDays + date.lengthOfYear();
		} // julianDays + day of the given year
		julianDays = julianDays + givenDate.getDayOfYear();
		JulianDate julianDate = new JulianDate();
		julianDate.julianAnyDate = julianDays;
		return julianDate;
	}

	public static JulianDate julianBetweenDates() {
		//1992-07-01//obtains an instance of LocalDate from a text string
		LocalDate givenDate = LocalDate.parse("1993-09-28");
		LocalDate givenDate2 = LocalDate.parse("1996-12-18");
		double julianDays = start; // counts from the 1st Jan 1583
		long daysBetween = ChronoUnit.DAYS.between(givenDate, givenDate2); // counts how many days were gone between the two dates
		System.out.println("The Difference between " + givenDate + " and " + givenDate2 + " is " + daysBetween);
		JulianDate julianDate = new JulianDate();
		return julianDate;
	}

	public static JulianDate julianToday() {
		// obtain the current date from the system clock in our time-zone (Java API)
		LocalDate localDate = LocalDate.now();
		double julianDays = start;
		// getting the year field
		int currentYear = localDate.getYear();
		//for all the years from 1583 to today's
		//obtain the instance of LocalDate from a text string;
		//add the start date to the length of year represented by our date
		//to report: so for every year from 1583 to today we create the instance of the date "1 January of every year" and add the start date the instance
		for (int y = 1583; y < currentYear; y++) {
			LocalDate date = LocalDate.parse(y + "-01-01");
			julianDays = julianDays + date.lengthOfYear();
		}
		// julianDays + day of the current year
		julianDays = julianDays + localDate.getDayOfYear();
		JulianDate julianDate = new JulianDate();
		// today's Julian date
		julianDate.julianToday = julianDays;
		return julianDate;
	}

	public static JulianDate julianUserDate() {
		// obtains an instance of LocalDate from a text string
		LocalDate givenDate = LocalDate.parse("1993-09-28");
		double julianDays = start; // counts from the 1st Jan 1583 3
		int givenYear = givenDate.getYear(); // the year of our new date
		// concrete birthday date - the program reacts on it with the special message
		double alinasBirthday = 2448804.5; // 1992-07-01 - Alina
		double ibrahimsBirthday = 2451165.5; // 1998-12-18 - Ibrahim
		double zhasminasBirthday = 2448172.5; // 1990-10-08 - Zhasmina
		LocalDate dateToday = LocalDate.now(); // today
		long daysBetween = ChronoUnit.DAYS.between(givenDate, dateToday); // counts how many days the user's been living
		System.out.println("You've been living on the Earth for " + daysBetween + " days.");
		// if the day number is divisible by 100, prints special message
		if (daysBetween % 100 == 0) {
			System.out.println("Hey, what a beautiful number!");
		}
		// shows which the day of the week it was
		DayOfWeek dayOfWeek = givenDate.getDayOfWeek(); // java.util.DayOfWeek
		System.out.println("Did you know, that the day " + givenDate + " was a " + dayOfWeek + "?");
		//
		// same loop as for today's Julian date but with the given year instead of
		// current
		// for all the years from 1583 to the given one
		// obtain the instance of LocalDate from a text string;
		// add the start date to the length of year represented by our date
		for (int i = 1583; i < givenYear; i++) {
			LocalDate date = LocalDate.parse(i + "-01-01");
			julianDays = julianDays + date.lengthOfYear();
		}
		// julianDays + day of the given year
		julianDays = julianDays + givenDate.getDayOfYear();
		JulianDate julianDate = new JulianDate();
		julianDate.julianUserDate = julianDays;
		// if the date matches to the concrete birthday date we stored before, prints
		// special message
		if ((julianDays == alinasBirthday) || (julianDays == ibrahimsBirthday) || (julianDays == zhasminasBirthday)) {
			System.out.println("And by the way, wow...it's also your birthday! Wish you all the best!");
		}
		return julianDate;
	}

	public double getJulianToday() {
		return julianToday;
	}

	public double getJulianUserDate() {

	return julianUserDate;
	}

	public double getJulianBetweenDates() {
		return julianBetweenDates;
	}

}
