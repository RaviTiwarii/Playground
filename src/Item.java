class Item {
    private final String name;
    private final double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public boolean isImported() {
        return name.contains("imported");
    }

    public boolean isTaxable() {
        String exemptedItems = "book books pills chocolate";
        for (String exemptedItem : exemptedItems.split(" ")) {
            if (name.contains(exemptedItem))
                return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

