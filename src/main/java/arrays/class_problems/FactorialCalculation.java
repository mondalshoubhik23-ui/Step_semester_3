package arrays.class_problems;

import java.util.Scanner;

public class FactorialCalculation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }

        System.out.println("Factorial: " + factorial);

        sc.close();
    }
}
