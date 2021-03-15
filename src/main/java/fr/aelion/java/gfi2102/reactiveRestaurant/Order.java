package fr.aelion.java.gfi2102.reactiveRestaurant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Integer num;
    private Pager pager;
    private String desc;

    public void ready() {
        System.out.println("Order ready: " + num);
        this.pager.ready();
    }
}
