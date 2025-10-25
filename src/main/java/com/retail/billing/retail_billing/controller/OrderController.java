package com.retail.billing.retail_billing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.retail.billing.retail_billing.io.OrderRequest;
import com.retail.billing.retail_billing.io.OrderResponse;
import com.retail.billing.retail_billing.service.OrderService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

     private final OrderService orderService;
     
     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public OrderResponse createOrder(@RequestBody OrderRequest request){
       return orderService.createOrder(request);
        
     }
     @ResponseStatus(HttpStatus.NO_CONTENT)
     @DeleteMapping("/{orderId}")
     public void deleteOrder(@PathVariable String orderId){
        orderService.deleteOrder(orderId);

     }
     @GetMapping("/latest")
     public List<OrderResponse> getLatestOrders() {
       return orderService.getLatestOrders();
     }


}
