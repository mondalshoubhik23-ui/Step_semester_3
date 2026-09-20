package array.assignment_problems;

public class StudentCollegeInformation {

    // Instance fields
    String name;
    double attendance;

    // Static fields
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    public StudentCollegeInformation(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method
    public static void printCollegeInfo() {
        System.out.println(studentCount + " Student objects created");
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        StudentCollegeInformation student1 =
            new StudentCollegeInformation("Ravi", 85);

        StudentCollegeInformation student2 =
            new StudentCollegeInformation("Anitha", 90);

        StudentCollegeInformation.printCollegeInfo();
    }
}