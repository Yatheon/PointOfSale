package Integration;

/**
 * Contains all the different items that are available
 */
public class ItemRegistry {
    private ItemDTO[] item;
    public ItemRegistry()
    {
        this.item = new ItemDTO[10];
        this.item[0] = new ItemDTO("apple", 5,2, 0);
        this.item[1] = new ItemDTO("paron", 6,3, 1);
        this.item[2] = new ItemDTO("bacon", 10,4, 2);
        this.item[3] = new ItemDTO("choklad" , 15,5, 3);
        this.item[4] = new ItemDTO("persika", 2,1, 4);
        this.item[5] = new ItemDTO("penna", 35,12, 5);
        this.item[6] = new ItemDTO("mjolk", 10,3, 6);
        this.item[7] = new ItemDTO("ost", 70,25, 7);
        this.item[8] = new ItemDTO("kebab", 60,20, 8);
        this.item[9] = new ItemDTO("kol", 1000,1100,9);
    }

    /**
     * Identifies the item that is requested and returns it
     *
     * @param itemID the ID of the item that is requested
     * @return the requested item
     * @throws ItemNotFoundException if there is no item with the matching itemID
     * @throws DataBaseFailureException if the database crashes unexpectedly
     */
    public ItemDTO getItem(int itemID) throws ItemNotFoundException, DataBaseFailureException {
        /*This if statement is a hardcoded database failure*/
        if (itemID == 666){
            throw new DataBaseFailureException("The database crashed, please contact your administrator.\nitemID that caused the crash: "+itemID,itemID);
        }

        for(int i = 0; i < this.item.length; i++)
            if (this.item[i].getId() == itemID)
                return this.item[i];

        throw new ItemNotFoundException("The item with the ID that was inputted (ID: "+itemID+") was not found in the item registry",itemID);

    }
}
