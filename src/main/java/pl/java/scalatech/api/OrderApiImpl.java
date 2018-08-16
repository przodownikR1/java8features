package pl.java.scalatech.api;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderApiImpl implements OrderApi {

    @Override
    public Cart buy(List<Item> items) {
        log.info("buy....");
        return Cart.builder().items(items).build();
    }

    @Override
    public Order order(Cart cart) {
        log.info("order ...");
        return Order.builder().cart(cart).build();
    }

    @Override
    public Deliver deliver(Order order) {
        log.info("deliver ....");
        return Deliver.builder().order(order).build();
    }

}
