package string.assigment_problems;

public class LibraryISBNValidator {

    public static String validateISBN(String isbn) {

        isbn = isbn.trim();

        if (isbn.length() != 13) {
            return "Invalid ISBN";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(isbn.charAt(i))) {
                return "Invalid ISBN";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                return "Invalid ISBN";
            }
        }

        String prefix = isbn.substring(0, 3);
        String middle = isbn.substring(3, 7);
        String last = isbn.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append(prefix.toUpperCase());
        result.append("-");
        result.append(middle);
        result.append("-");
        result.append(last);

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(validateISBN("abc1234567890"));
        System.out.println(validateISBN("ab1234567890"));
    }
}