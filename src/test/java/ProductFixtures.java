public class ProductFixtures {

    public static Product door = new Product(1,"Wooden Door", 35);
    public static Product floorPanel = new Product(2,"Floor Panel", 25);
    public static Product window = new Product(3,"Glass Window", 10);

    public static Supplier bobs = new Supplier("Bob's Household Supplies");
    public static Supplier kates = new Supplier("Kate's Home Goods");

    static{
        bobs.products().add(door);
        bobs.products().add(floorPanel);
        bobs.products().add(window);

        kates.products().add(floorPanel);
        kates.products().add(new Product(1,"Wooden Door", 35));
    }

}
