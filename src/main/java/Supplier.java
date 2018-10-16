import java.util.ArrayList;
import java.util.List;

public class Supplier {

    private String name;

    private List<Product> products = new ArrayList<>();

    public Supplier(String name){
        this.name = name;
    }

    public List<Product> products(){
        return products;
    }

}
