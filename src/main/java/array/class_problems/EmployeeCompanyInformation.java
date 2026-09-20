package array.class_problems;

public class EmployeeCompanyInformation {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompanyInformation(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeCompanyInformation emp1 =
            new EmployeeCompanyInformation("Aisha", 50000);

        EmployeeCompanyInformation emp2 =
            new EmployeeCompanyInformation("Rahul", 60000);

        EmployeeCompanyInformation emp3 =
            new EmployeeCompanyInformation("Karan", 55000);

        System.out.println("3 Employee objects created");

        EmployeeCompanyInformation.printCompanyInfo();
    }
}