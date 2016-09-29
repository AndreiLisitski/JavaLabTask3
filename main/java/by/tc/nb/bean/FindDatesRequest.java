package by.tc.nb.bean;

public class FindDatesRequest extends Request {

    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

//public class FindNotesRequest extends Request {
//
//    private String findString;
//
//    public String getFindString() {
//        return findString;
//    }
//
//    public void setFindString(String findString) {
//        this.findString = findString;
//    }
//}