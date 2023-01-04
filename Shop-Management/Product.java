public class Product
{
    private int code;
    private double price;
    private String name;
    public Product(String name, int code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }
    public Product(String name){
        this.name = name;
    }
    public int getCode() { return code; }
    public double getPrice() { return price; }
    public String getName(){
        return name;
    }
}
