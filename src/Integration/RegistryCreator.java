package Integration;

public class RegistryCreator {
    private ItemRegistry itemRegistry;

    public RegistryCreator(){
        this.itemRegistry = new ItemRegistry();
    }

    public ItemRegistry getItemRegistry() {
        return itemRegistry;
    }
}
