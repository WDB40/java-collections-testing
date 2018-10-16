import java.util.ArrayList;
import java.util.Collection;

public class Application {

    public static void main(String[] args) {

        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();

        products.add(door);
        products.add(floorPanel);
        products.add(window);

        products.forEach((Product product) -> {
            if (product.getWeight() > 20) {
                System.out.println(product);
            }
        });

        System.out.println(products.contains(window));

        products.removeIf((Product product) -> product.getWeight()<20);

        System.out.println(products.contains(window));

    }
}
