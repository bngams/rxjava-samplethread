package fr.aelion.java.gfi2102.reactiveRestaurant;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class CookingService {

    public Flowable<Order> cook(Order o) {
        return Flowable.create(s -> {
            new Thread(() -> {
                try {
                    System.out.println("Cooking order " + o.getNum());
                    s.onNext(o);
                    Thread.sleep((long)(Math.random() * 20000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }, BackpressureStrategy.ERROR);
    }
}
