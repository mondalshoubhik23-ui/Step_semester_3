import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
    abstract String shape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    String shape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    String shape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }

    String shape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            if (type.equals("CIRCLE")) {
                String owner = sc.next();
                double radius = sc.nextDouble();
                Plot plot = new Circle(owner, radius);
                double area = plot.area();
                System.out.printf("%s (%s): %.2f%n", plot.owner, plot.shape(), area);
                total += area;
            } else if (type.equals("RECTANGLE")) {
                String owner = sc.next();
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                Plot plot = new Rectangle(owner, length, width);
                double area = plot.area();
                System.out.printf("%s (%s): %.2f%n", plot.owner, plot.shape(), area);
                total += area;
            } else if (type.equals("TRIANGLE")) {
                String owner = sc.next();
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                Plot plot = new Triangle(owner, base, height);
                double area = plot.area();
                System.out.printf("%s (%s): %.2f%n", plot.owner, plot.shape(), area);
                total += area;
            }
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
