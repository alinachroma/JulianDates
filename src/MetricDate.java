/*
    @author: Alina Khairullina, Zhasmina Dimova, Ibrahim Soueid
    @version: 2018.05.15 
 */

public class MetricDate extends JulianDate {
	public static double start = 2299238.5 - 1;

	public MetricDate(int julianAnyDate) {
		super();
		System.out.println(convertToMetric(julianAnyDate));
		System.out.println(convertToJulianDate(10, 5, 2, 1));
	}

	public String convertToMetric(int julianAnyDate) {
		int day = julianAnyDate % 10;
		julianAnyDate -= day;
		int week = (julianAnyDate % 100) / 10;
		julianAnyDate -= julianAnyDate % 100;
		int month = (julianAnyDate % 1000) / 100;
		julianAnyDate -= julianAnyDate % 1000;
		int year = julianAnyDate % 1000;
		return day + ".day in the " + week + ".week of the month: " + month + ".month in the " + year + ".";
	}

	public int convertToJulianDate(int metricDay, int metricWeek, int metricMonth, int metricYear) {
		return (metricYear * 1000) + (metricMonth * 100) + (metricWeek * 10) + metricDay;
	}
}