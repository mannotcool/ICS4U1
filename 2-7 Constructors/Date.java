/**
 * Auto Generated Java Class.
 */
public class Date {
    private int month;
    private int day;
    private int year;
    
    public Date (int day, int month, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }
    
    // Accessor to get month number
    public int getMonth() {
        return month;
    }
    
    // Accessor to get month number
    public int getDay() {
        return day;
    }
    
    // Accessor to get month number
    public int getYear() {
        return year;
    }
    
    // Mutator to set year
    public void setYear(int newYear) {
        if (newYear < 1000 || newYear > 9999) {
            System.err.println("Year must be between 1000-9999, got "+ newYear);
            year = 1000;
        } else {
            year = newYear;
        }
    }
    
    // Mutator to set month
    public void setMonth(int newMonth) {
        if (newMonth < 1 || newMonth > 12) {
            System.err.println("Month must be between 1-12, got "+ newMonth);
            month = 1;
        } else {
            month = newMonth;
        }
    }
    
    // Mutator to set day
    public void setDay(int newDay) {
        if (newDay < 1 || newDay > 31) {
            System.err.println("Day must be between 1-31, got "+ newDay);
            day = 1;
        } else {
            day = newDay;
        }
    }
    
    public String toString() {
        return day + "/" + month + "/" + year;
    }
    
    
}
