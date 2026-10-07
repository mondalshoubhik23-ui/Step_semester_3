import java.util.*;

abstract class Travel {
    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double fare();

    double total() {
        return fare() + 50;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 2;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    double fare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel travel;

            if (mode.equals("BUS")) {
                travel = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                travel = new Train(distance);
            } else {
                travel = new Flight(distance);
            }

            System.out.printf("%s: %.2f%n", mode, travel.total());
        }

        sc.close();
    }
}
