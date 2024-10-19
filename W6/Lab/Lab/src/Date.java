public class Date {
    /** Which day it is*/
    private int day;
    /** Which month is the date in*/
    private int month;
    /** The year of the date*/
    private int year;

    /**
     * Creates Date object with the specified day, month and year
     * @param day       day of the month (1-31)
     * @param month     month of the year (1-12)
     * @param year      year of the date
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Gets the day of the month
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Gets the month of the year
     * @return  the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets the year
     * @return  the year of the date
     */
    public int getYear() {
        return year;
    }

    /** This method returns a human-friendly String representation of this */
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    /**
     * Checks if other object is equal to this
     * @param o     the other object we compare this to
     * @return  true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }
}
