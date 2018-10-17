import java.util.*;

public class ProductCatalogue implements  Iterable<Product>{

    public static final int LIGHT_VAN_WEIGHT_LIMIT = 20;
    private final SortedSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);

    public void isSuppliedBy(Supplier supplier){

        products.addAll(supplier.products());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public Set<Product> lightVanProducts(){
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.headSet(heaviestLightVanProduct);
    }

    private Product findHeaviestLightVanProduct() {

        for(Product product: products){
            if(product.getWeight() > LIGHT_VAN_WEIGHT_LIMIT){
                return product;
            }
        }
        return products.last();
    }

    public Set<Product> heavyVanProducts(){
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.tailSet(heaviestLightVanProduct);
    }
}
