package com.mangxiao.sample.webflux.service;

import com.mangxiao.sample.webflux.model.Order;
import reactor.core.publisher.MonoSink;

import java.util.List;
import java.util.function.Consumer;

public interface OrderService {

    public Long saveOrder(Order order);

    public Long deleteOrder(String orderId);

    public Long updateOrder(Order order);

    public Order quaryOrder(Order order);

    public List<Order> quaryAll();
}
