package com.mangxiao.sample.webflux.controller;

import com.mangxiao.sample.webflux.model.Order;
import com.mangxiao.sample.webflux.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/index")
@RestController
public class IndexController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/hello")
    public Mono<String> hello(){
        return Mono.just("hello webflux");
    }

    @GetMapping()
    public Flux<String> hi(){
        return Flux.just("hi,flux");
    }

    @PostMapping("/quaryOrderAll")
    public Flux<Order> quaryOrderAll(){
        return Flux.fromIterable(orderService.quaryAll());
    }
    @PostMapping("/quaryOrder")
    public Flux<Order> quaryOrder(@RequestBody Order order){
        return Flux.just(orderService.quaryOrder(order));
    }
    @PostMapping("/saveOrder")
    public Mono<Long> saveOrder(@RequestPart Order order){
        Long id = orderService.saveOrder(order);
        return Mono.create(orderMonoSink -> orderMonoSink.success(id));
    }
    @PostMapping("/deleteOrder")
    public Mono<Long> deleteOrder(@PathVariable("orderId") String orderId){
        Long id = orderService.deleteOrder(orderId);
        return Mono.create(orderMonoSink -> orderMonoSink.success(id));
    }
    @PostMapping("/updateOrder")
    public Mono<Long> updateOrder(@RequestBody Order order){
        Long id = orderService.updateOrder(order);
        return Mono.create(orderMonoSink -> orderMonoSink.success(id));
    }
}
