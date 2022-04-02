package by.incubator.weekdays;

public enum DaysOfWeek {
    MONDAY("MON", false),TUESDAY("TUE", false),
    WEDNESDAY("WED", false), THURSDAY("THU", false),
    FRIDAY("FRI", false), SATURDAY("SAT", true),
    SUNDAY("SUN" , true);

    public static final int DAYS_OF_WEEK = 7;
    private String shortName;
    private boolean weekday;

    DaysOfWeek (String shortName, boolean weekday) {
        this.shortName = shortName;
        this.weekday = weekday;
    }

    public static void display(int num) {
        DaysOfWeek day;

        if (num > DAYS_OF_WEEK || num < 1) {
            System.out.println(num);
            return;
        }

        day = values()[num - 1];
        System.out.println(day.getInfo());
    }

    public String getInfo() {
        return  name() +
                " (" + shortName + ") " +
                (weekday ? "is a weekend" : "is not a weekend");
    }
}
