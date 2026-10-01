package array.assignment_problems;

import java.util.Scanner;

public class HostelElectricityBill {

    static abstract class Room {

        int units;

        Room(int units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {

        SingleRoom(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return units * 8;
        }
    }

    static class SharedRoom extends Room {

        int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        double calculateBill() {
            return (units * 6) / (double) occupants;
        }
    }

    static class ACRoom extends Room {

        ACRoom(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return (units * 10) + 200;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            Room room;

            if (type.equals("SINGLE")) {

                room = new SingleRoom(units);

            } else if (type.equals("SHARED")) {

                int occupants = sc.nextInt();

                room = new SharedRoom(units, occupants);

            } else {

                room = new ACRoom(units);
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
