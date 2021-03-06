package pl.java.scalatech.api;

import static com.google.common.collect.Lists.newArrayList;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

public interface OrderApi {
    Cart buy(List<Item> items);

    Order order(Cart cart);

    Deliver deliver(Order order);

    List<Item> items = newArrayList(Item.builder().name("spoon").quantity(2).price(BigDecimal.valueOf(100d)).build(),
            Item.builder().name("fork").quantity(4).price(BigDecimal.valueOf(104d)).build(),
            Item.builder().name("knife").quantity(2).price(BigDecimal.valueOf(12d)).build());

    default Deliver oneClick(List<Item> items) {
        Function<List<Item>, Cart> buyItem = this::buy;
        Function<Cart, Order> orderCart = this::order;
        Function<Order, Deliver> deliverOrder = this::deliver;
        Function<List<Item>, Deliver> oneClickFunction = buyItem.andThen(orderCart).andThen(deliverOrder);
        return oneClickFunction.apply(items);
    }
}
