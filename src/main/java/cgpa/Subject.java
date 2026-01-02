package cgpa;

public class Subject {
    private String subjectName;
    private double gradePoint;
    private int creditHours;
    public int getCreditHours() {
        return creditHours;
    }
    public Subject(String subjectName, double gradePoint, int creditHours) {
        this.subjectName = subjectName;
        this.gradePoint = gradePoint;
        this.creditHours = creditHours;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public double getTotalPoints() {
        return gradePoint * creditHours;
    }
} //Initial CGPA Calculator Project

