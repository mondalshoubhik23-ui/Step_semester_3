import java.util.Scanner;

public class WareoHuseBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        for (int qty : sectionA) {
            totalA += qty;
        }
        for (int qty : sectionB) {
            totalB += qty;
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int maxQty = Integer.MIN_VALUE;
        String maxSection = "";
        int maxItemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA +
                " | Section B Total: " + totalB +
                " | Status: " + status +
                " | Highest Quantity: " + maxQty +
                " (" + maxSection + ", Item " + maxItemIndex + ")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items per section: ");
        int n = scanner.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("Enter quantities for Section A:");
        for (int i = 0; i < n; i++) {
            sectionA[i] = scanner.nextInt();
        }

        System.out.println("Enter quantities for Section B:");
        for (int i = 0; i < n; i++) {
            sectionB[i] = scanner.nextInt();
        }

        analyzeInventory(sectionA, sectionB);
        scanner.close();
    }
}