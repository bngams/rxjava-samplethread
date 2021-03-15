package fr.aelion.java.gfi2102.reactiveRestaurant;

import io.reactivex.Flowable;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderingService {

    private static AtomicInteger orderNum = new AtomicInteger(0);
    private static final CookingService cs = new CookingService();

    public Order createOrder(String desc) {
        return new Order(orderNum.incrementAndGet(), new Pager(), desc);
    }

    public boolean payOrder(Order order) {
        this.launchOrder(order);
        return true;
    }

    private void launchOrder(Order order) {
        Flowable<Order> f = cs.cook(order);
        f.subscribe(meal -> {
            meal.ready();
        });
        System.out.println("Order " + order.getNum() + " is launched");
    }
}
