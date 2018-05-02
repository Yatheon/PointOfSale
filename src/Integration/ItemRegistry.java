package Integration;

public class ItemRegistry {
    ItemDTO[] item;
    public ItemRegistry()
    {
        this.item = new ItemDTO[10];
        this.item[0] = new ItemDTO("apple", 5,2);
        this.item[1] = new ItemDTO("paron", 6,3);
        this.item[2] = new ItemDTO("bacon", 10,4);
        this.item[3] = new ItemDTO("choklad" , 15,5);
        this.item[4] = new ItemDTO("persika", 2,1);
        this.item[5] = new ItemDTO("penna", 35,12);
        this.item[6] = new ItemDTO("mjölk", 10,3);
        this.item[7] = new ItemDTO("ost", 70,25);
        this.item[8] = new ItemDTO("kebab", 60,20);
        this.item[9] = new ItemDTO("kol", 1000,550);
    }

    public ItemDTO getItem(int itemID) {
        return this.item[itemID];
    }
}
