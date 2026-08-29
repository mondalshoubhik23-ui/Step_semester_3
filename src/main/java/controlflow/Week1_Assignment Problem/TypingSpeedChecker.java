import java.util.Scanner;

public class TypingSpeedChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int length = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < length; i++) {
            if (i < typed.length() && original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = (i < typed.length()) ? typed.charAt(i) : ' ';
            }
        }

        double accuracy = ((double) matched / length) * 100;

        if (firstMismatchPos == -1 && original.length() == typed.length()) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", matched, length, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, length, accuracy, firstMismatchPos, origChar, typedChar);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);
        scanner.close();
    }
}
