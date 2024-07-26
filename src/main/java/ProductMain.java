public class ProductMain {
    public static void main(String[] args) {
        Product product = new Product(19.99, 3, "Wireless Keyboard");

        product.printProduct();
        product.totalCost();
    }
}
