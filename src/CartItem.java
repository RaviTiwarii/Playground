import java.util.Objects;

public class CartItem {
    private final Item item;
    private final int quantity;

    public CartItem(Item item, int quantity) {
        this.item = Objects.requireNonNull(item, "Item cannot be null");
        this.quantity = validate(quantity);
    }

    private int validate(int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("quantity should be greater then 0");
        return quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return item.getPrice() * quantity;
    }
}
