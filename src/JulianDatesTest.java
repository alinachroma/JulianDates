/*
    @author: Alina Khairullina, Zhasmina Dimova, Ibrahim Soueid
    @version: 2018.05.15 
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class JulianDatesTest extends JulianDate {
	public static void main(String[] args) {
		testBetweenDates();
		testJulianDateForAnyDate();
		testJulianForToday();
	}

	public static void testJulianForToday() {
		JulianDate actual = JulianDate.julianToday();
		double expected = 2458259.5;
		System.out.println("testJulianForToday");
		System.out.println("Expected:" + expected);
		System.out.println("Actual:" + actual);
	}
	public static void testBetweenDates() {
		JulianDate.julianBetweenDates();
		int expected = 1177;
		LocalDate localDate = LocalDate.parse("1993-09-28");
		LocalDate localDate1 = LocalDate.parse("1996-12-18");
		long actual = ChronoUnit.DAYS.between(localDate, localDate1);
		System.out.println("testJulianDateForAnyDate");
		System.out.println("Expected:" + expected);
		System.out.println("Actual:" + actual);
	}

	public static void testJulianDateForAnyDate() {
		JulianDate actual = JulianDate.julianAnyDateInJulian();
		long expected = 2382904;
		LocalDate actual1 = LocalDate.parse("1993-09-28");
		System.out.println("testJulianDateForAnyDate " + "Input Date: " + actual1);
		System.out.println("Expected:" + expected);
		System.out.println("Actual:" + actual1);
	}
}