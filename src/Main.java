import java.util.Scanner;

/**
 * Give input as:
 * 1 book at 12.49
 * 1 music CD at 14.99
 * 1 chocolate bar at 0.85
 * then press enter to see results.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ShoppingCart shoppingCart = new ShoppingCart();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) break;
                shoppingCart.addItem(Parser.parse(line));
            }
            shoppingCart.printReport();
        }
    }

    static class Parser {
        static CartItem parse(final String line) {
            int quantity;
            String itemName;
            double price;

            String[] data = line.split(" ");
            quantity = Integer.parseInt(data[0]);

            itemName = "";
            for (int i = 1; i < data.length - 1; i++) {
                if (data[i].equals("at")) {
                    break;
                }
                if (!itemName.isEmpty()) itemName += " ";
                itemName += data[i];
            }
            price = Double.parseDouble(data[data.length - 1]);
            return new CartItem(new Item(itemName, price), quantity);
        }
    }
}