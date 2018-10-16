import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Product {

    public static final Comparator<Product> BY_WEIGHT = comparing(Product::getWeight);

    private String name;
    private int weight;

    public Product(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return String.format("Product Name: %s and Product Weight: %d", name, weight);
    }
}
