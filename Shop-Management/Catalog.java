import java.util.Vector;

public class Catalog {

    public Vector<Product> products;
    public Catalog(){
        products = new Vector<>();
    }
    public Product getProduct(int code) throws ProductNotExistException{
        for (Product p: products) {
            if (p.getCode() == code)
                return p;
        }
        throw new ProductNotExistException("Error!!");
    }

    public Product getProductName(String name) throws ProductNotExistException{
        for (Product p: products) {
            if (p.getName() == name)
                return p;
        }
        throw new ProductNotExistException("Error!!");
    }

}
