package Model;
import Integration.ItemDTO;
import Integration.SaleDTO;
public class Receipt {
    
    Receipt(SaleDTO saleDTO){
        ItemDTO[] itemDTO = saleDTO.getItemDTO();
        for(int i = 0; i< itemDTO.length; i++)
        {
            System.out.println(itemDTO[i].getTotalPrice() +"  "+ itemDTO[i].getName() );
            System.out.println("Total Cost: "+saleDTO.getTotalCost());
        }

    }
}
