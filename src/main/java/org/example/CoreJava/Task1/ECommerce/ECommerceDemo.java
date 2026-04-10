package org.example.CoreJava.Task1.ECommerce;

public class ECommerceDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product laptop = new ElectronicsProduct("E1001", 1200.0, 10, 100.0);
        Product apple = new GroceryProduct("G2001", 2.0, 100, 0.5);

        cart.addProduct(laptop);
        cart.addProduct(apple);

        cart.showCart();
        System.out.println("Total: " + cart.calculateTotal());

        cart.removeProduct("G2001");
        cart.showCart();
        System.out.println("Total after removal: " + cart.calculateTotal());
    }
}
