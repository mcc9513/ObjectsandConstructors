public class Product {
    private double productCost;
    private int quantity;
    private String productName;

    public Product(double productCost, int quantity, String productName) {
        this.productCost = productCost;
        this.quantity = quantity;
        this.productName = productName;
    }

    public void totalCost() {
        double total = this.productCost * this.quantity;
        System.out.println("Total cost for " + this.quantity + " units of " + this.productName + ": $" + total);
    }

    public void printProduct() {
        System.out.println("Product Name: " + this.productName);
        System.out.println("Cost per unit: $" + this.productCost);
        System.out.println("Quantity purchased: " + this.quantity);
    }

}
