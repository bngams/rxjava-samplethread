package fr.aelion.java.gfi2102.reactiveRestaurant;

public class Restaurant {

    private OrderingService os = new OrderingService();

    public void order(String desc) {
        os.payOrder(os.createOrder(desc));
    }
}
