package array.class_problems;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class LibraryItemDueDateCalculator {

    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    static abstract class LibraryItem {

        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getBorrowingDays();

        LocalDate getDueDate() {
            return CURRENT_DATE.plusDays(getBorrowingDays());
        }
    }

    static class Book extends LibraryItem {

        Book(String title) {
            super(title);
        }

        @Override
        int getBorrowingDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {

        DVD(String title) {
            super(title);
        }

        @Override
        int getBorrowingDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {

        Magazine(String title) {
            super(title);
        }

        @Override
        int getBorrowingDays() {
            return 3;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Function<String, LibraryItem>> itemTypes = new HashMap<>();

        itemTypes.put("BOOK", Book::new);
        itemTypes.put("DVD", DVD::new);
        itemTypes.put("MAGAZINE", Magazine::new);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();

            String[] parts = line.split("\\s+", 2);

            String type = parts[0];
            String title = parts[1].trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item = itemTypes.get(type).apply(title);

            System.out.println(item.title + ": " + item.getDueDate());
        }

        sc.close();
    }
}
