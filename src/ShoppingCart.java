import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {

    private final List<CartItem> cartItems = new ArrayList<>();

    public void addItem(final CartItem item) {
        cartItems.add(Objects.requireNonNull(item, "Item cannot be null."));
    }

    public void printReport() {
        StringBuilder report = new StringBuilder();
        double totalPrice = 0.0;
        double salesTax = 0.0;
        for (CartItem cartItem : cartItems) {
            double currentPrice = cartItem.getTotal();
            double currentTax = 0.0;
            Item item = cartItem.getItem();
            if (item.isTaxable()) {
                currentTax += currentPrice * 0.10;
            }
            if (item.isImported()) {
                currentTax += currentPrice  * 0.05;
            }
            currentPrice += currentTax;
            salesTax += currentTax;
            totalPrice += currentPrice;
            report.append(String.format("%d %s: %.2f", cartItem.getQuantity(), item.getName(), currentPrice)).append("\n");
        }
        report.append(String.format("Sales Taxes: %.2f", salesTax)).append("\n");
        report.append(String.format("Total: %.2f", totalPrice)).append("\n");
        System.out.println(report.toString());
    }
}