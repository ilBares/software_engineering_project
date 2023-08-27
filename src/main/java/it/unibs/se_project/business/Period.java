package it.unibs.se_project.business;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Period {
    public static class DayMonth {
        private int day;
        private int month;

        public DayMonth(int day, int month) {
            this.day = day;
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public int getMonth() {
            return month;
        }
    }

    private DayMonth startDate;
    private DayMonth endDate;

    public Period(DayMonth startDate, DayMonth endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DayMonth getStartDate() {
        return startDate;
    }

    public DayMonth getEndDate() {
        return endDate;
    }

    // public static boolean todayIncluded(Period period) {
    //     Calendar calendar = Calendar.getInstance();

    //     int day = calendar.get(Calendar.DAY_OF_MONTH);
    //     int month = calendar.get(Calendar.MONTH) + 1;

    //     DayMonth start = period.getStartDate();
    //     DayMonth end = period.getEndDate();

    //     if (month > start.getMonth() && month < end.getMonth()) {
    //         return true;
    //     }
    //     if (month == start.getMonth() || month == end.getMonth()) {
    //         return day >= start.getDay() && day <= end.getDay();
    //     }
    //     return false;
    // }

    public static boolean dateIncludedInPeriod(LocalDate date, Period period) {
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();

        DayMonth start = period.getStartDate();
        DayMonth end = period.getEndDate();

        if (month > start.getMonth() && month < end.getMonth()) {
            return true;
        }
        if (month == start.getMonth() || month == end.getMonth()) {
            return day >= start.getDay() && day <= end.getDay();
        }
        return false;
    }

    public static Period fromString(String periodString) {
        String[] dateStrings = periodString.split("\\|");
        
        String[] dayMonthS = dateStrings[0].split("-");
        String[] dayMonthE = dateStrings[1].split("-");

        int dayS = Integer.parseInt(dayMonthS[0]);
        int monthS = Integer.parseInt(dayMonthS[1]);

        int dayE = Integer.parseInt(dayMonthE[0]);
        int monthE = Integer.parseInt(dayMonthE[1]);

        return new Period(new DayMonth(dayS, monthS), new DayMonth(dayE, monthE));
    }

    @Override
    public String toString() {
        String startDateStr = String.format("%02d-%02d", startDate.day, startDate.month);
        String endDateStr = String.format("%02d-%02d", endDate.day, endDate.month);

        return startDateStr + "|" + endDateStr;
    }
}



// public static boolean todayIncluded(Period period) {
    //     Calendar calendar = Calendar.getInstance();

    //     calendar.setTime(period.getStartDate());
    //     int dayS = calendar.get(Calendar.DAY_OF_MONTH);
    //     int monthS = calendar.get(Calendar.MONTH);

    //     calendar.setTime(period.getEndDate());
    //     int dayE = calendar.get(Calendar.DAY_OF_MONTH);
    //     int monthS = calendar.get



    //     Date today = new Date();

    //     boolean afterStart = today.after(period.getStartDate());
    //     boolean beforeEnd = today.before(period.getEndDate());



    //     return afterStart && beforeEnd;
    // }

    // public static Period fromString(String periodString) throws ParseException {
    //     // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //     SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM");
    //     String[] dateStrings = periodString.split("\\|");

    //     // Calendar calendar = Calendar.getInstance();

    //     String startStringDate = dateStrings[0];
    //     String endStringDate = dateStrings[1];

    //     // String startStringDate = String.format("%s-%s", dateStrings[0], calendar.get(Calendar.YEAR));
    //     // String endStringDate = String.format("%s-%s", dateStrings[1], calendar.get(Calendar.YEAR));

    //     Date startDate = dateFormat.parse(startStringDate);
    //     Date endDate = dateFormat.parse(endStringDate);

    //     return new Period(startDate, endDate);
    // }