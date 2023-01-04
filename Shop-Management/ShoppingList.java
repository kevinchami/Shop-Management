public class ShoppingList {

    Product[] products;
    int[] amount;
    private int num;

    public ShoppingList() {
        products = new Product[1000];
        amount = new int[1000];
        num = 0;

    }

    public void addProduct(Product p, int amount) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = p;
                this.amount[i] = amount;
                return;
            }
        }

    }

    public String toString() {
        String s = "";
        int totalPrice = 0;
//        for (int i = 0; i < products.length && products[i] != null; i++) {
//            s += "Products: " + products[i].getCode() + ", " + products[i].getPrice() + ", "
//                    + amount[i] + ", " + products[i].getPrice() * amount[i] + " \nName: " + products[i].getName() + "\n";
//            totalPrice += products[i].getPrice() * amount[i];
//
//        }

        for (int i = 0; i < products.length && products[i] != null; i++) {
            s += "Product: " + products[i].getName() + ", Price: " + products[i].getPrice() + ", Amount: " + amount[i] + "\n";
            totalPrice += products[i].getPrice() * amount[i];
        }

        s += "\nTotal price: " + totalPrice;
        return s;
    }


}
