package com.mangxiao.sample.webflux.service.impl;

import com.mangxiao.sample.webflux.model.Order;
import com.mangxiao.sample.webflux.service.OrderService;
import com.mangxiao.sample.webflux.util.NumberUtil;
import com.mangxiao.sample.webflux.util.OrderUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.MonoSink;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

@Service
public class OrderServiceImpl implements OrderService {

    private static List<Order> dataSet = new ArrayList<Order>();

    public Long saveOrder(Order order) {
        Order o = new Order();
        o.setAmount(order.getAmount());
        o.setId(Long.valueOf(NumberUtil.generateId()));
        o.setOrderId(OrderUtil.getOrderNo());
        o.setCreateTime(new Date());
        dataSet.add(o);
        return o.getId();
    }

    public Long deleteOrder(String orderId) {
        Order o = null;
        for (Order order:dataSet){
            if (order.getOrderId().equals(orderId)){
                o = order;
                dataSet.remove(order);
            }
        }
        return o.getId();
    }

    public Long updateOrder(Order order) {
        Order o = null;
        for (Order ox:dataSet){
            if (ox.getOrderId().equals(order.getOrderId())){
                dataSet.remove(ox);
                o = order;
                ox.setCreateTime(new Date());
                ox.setAmount(order.getAmount());
                dataSet.add(ox);
            }
        }
        return o.getId();
    }

    public Order quaryOrder(Order order) {
        Order o = null;
        for (Order ox:dataSet){
            if (ox.getOrderId().equals(order.getOrderId())){
                o = ox;
            }
        }
        return o;
    }

    public List<Order> quaryAll() {
        return dataSet;
    }
}
