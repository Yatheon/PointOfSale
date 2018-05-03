package Integration;

public class ItemDTO {
    private String name;
    private double totalPrice;
    private double tax;
    private int id;
    public ItemDTO(String name, double totalPrice, double tax, int id) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getName() {
        return name;
    }

    public double getTax() {
        return tax;
    }

    public int getId() {
        return id;
    }
}
