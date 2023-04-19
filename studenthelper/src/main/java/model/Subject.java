package model;

public class Subject {
    private String courseName;
    private String date;
    private String time;


    public Subject(String courseName, String date, String time) {
        this.courseName = courseName;
        this.date = date;
        this.time = time;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
