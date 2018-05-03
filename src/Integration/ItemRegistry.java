package Integration;

public class ItemRegistry {
    ItemDTO[] item;
    public ItemRegistry()
    {
        this.item = new ItemDTO[10];
        this.item[0] = new ItemDTO("apple", 5,2, 0);
        this.item[1] = new ItemDTO("paron", 6,3, 1);
        this.item[2] = new ItemDTO("bacon", 10,4, 2);
        this.item[3] = new ItemDTO("choklad" , 15,5, 3);
        this.item[4] = new ItemDTO("persika", 2,1, 4);
        this.item[5] = new ItemDTO("penna", 35,12, 5);
        this.item[6] = new ItemDTO("mjölk", 10,3, 6);
        this.item[7] = new ItemDTO("ost", 70,25, 7);
        this.item[8] = new ItemDTO("kebab", 60,20, 8);
        this.item[9] = new ItemDTO("kol", 1000,1100,9);
    }

    public ItemDTO getItem(int itemID) {
        for(int i = 0; i < this.item.length; i++){
            if(this.item[i].getId() == itemID )
                return this.item[i];
        }

        return this.item[9];
    }
}
