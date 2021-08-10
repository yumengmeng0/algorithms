package chapter102;

import edu.princeton.cs.algs4.Date;

/**
 * @author: ymm
 * @date: 2021/6/26
 * @version: 1.0.0
 * @description:
 */
public class SmartDate extends Date {
    /**
     * Initializes a new date from the month, day, and year.
     *
     * @param month the month (between 1 and 12)
     * @param day   the day (between 1 and 28-31, depending on the month)
     * @param year  the year
     * @throws IllegalArgumentException if this date is invalid
     */
    public SmartDate(int month, int day, int year) {
        super(month, day, year);
    }

    /**
     * Initializes new date specified as a string in form MM/DD/YYYY.
     *
     * @param date the string representation of this date
     * @throws IllegalArgumentException if this date is invalid
     */
    public SmartDate(String date) {
        super(date);
    }

    public void dayOfTheWeek() {

    }

    public static void main(String[] args) {

    }
}
