package com.retail.billing.retail_billing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.razorpay.RazorpayException;
import com.retail.billing.retail_billing.io.OrderResponse;
import com.retail.billing.retail_billing.io.PaymentRequest;
import com.retail.billing.retail_billing.io.PaymentVerificationRequest;
import com.retail.billing.retail_billing.io.RazorpayOrderResponse;
import com.retail.billing.retail_billing.service.OrderService;
import com.retail.billing.retail_billing.service.RazorpayService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "https://retail-billing.netlify.app")
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final RazorpayService razorpayService;
    private final OrderService orderService;
    
    @PostMapping("/create_order")
    @ResponseStatus(HttpStatus.CREATED)
    public RazorpayOrderResponse createRazorpayOrder(@RequestBody PaymentRequest request) throws RazorpayException{

       return razorpayService.createOrder(request.getAmount(), request.getCurrency());
       

    }
    @PostMapping("/verify")
    public OrderResponse verifyPayment(@RequestBody PaymentVerificationRequest request){
    
    return orderService.verifyPayment(request);


  }

}
