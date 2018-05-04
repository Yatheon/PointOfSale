package Integration;

import java.util.ArrayList;

/**
 * Contains all the information about the current sale
 */
public class SaleDTO {
    private ItemDTO[] itemDTO;
    private double totalCost;
    private double tax;
    public SaleDTO()
    {
        this.itemDTO = new ItemDTO[0];
        this.totalCost = 0;
        this.tax = 0;
    }
    public SaleDTO(ItemDTO[] itemDTO,double totalCost, double tax )
    {
        this.itemDTO = itemDTO;
        this.totalCost = totalCost;
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public ItemDTO[] getItemDTO() {
        return itemDTO;
    }
}
