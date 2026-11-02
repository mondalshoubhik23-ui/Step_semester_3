package arrays.assigment_problems;

import java.util.Scanner;

public class ClassAttendanceTracker {

    static void attendanceSummary(int[] days) {

        int present = 0;
        int current = 0;
        int longest = 0;

        for (int day : days) {

            if (day == 1) {
                present++;
                current++;

                if (current > longest) {
                    longest = current;
                }

            } else {
                current = 0;
            }
        }

        System.out.println("Present: " + present);
        System.out.println("Longest streak: " + longest);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        attendanceSummary(days);

        sc.close();
    }
}
