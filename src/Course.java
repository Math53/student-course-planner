package src;

public class Course {
    private String name;
    private String code;
    private int credits;
    private String dayTime; // e.g., "MWF 10:00-11:00"

    public Course(String name, String code, int credits, String dayTime) {
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.dayTime = dayTime;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getCredits() {
        return credits;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    
    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    @Override
    public String toString() {
        return code + ": " + name + " (" + credits + " credits, " + dayTime + ")";
    }
}
