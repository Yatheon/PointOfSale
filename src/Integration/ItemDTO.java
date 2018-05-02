package Integration;

public class ItemDTO {
    private String name;
    private double totalPrice;
    private double tax;
    public ItemDTO(String name, double totalPrice, double tax) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.tax = tax;
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
}
