package string.assigment_problems;

public class ProductInventoryCSVParser {

    public static void parseProduct(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Product Record");
        } else {
            System.out.println("Product: " + fields[0]
                    + " | SKU: " + fields[1]
                    + " | Qty: " + fields[2]);
        }
    }

    public static void main(String[] args) {

        parseProduct("Wireless Mouse,WM-2201,150");
    }
}