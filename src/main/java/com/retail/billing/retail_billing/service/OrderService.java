package com.retail.billing.retail_billing.service;

import java.time.LocalDate;
import java.util.List;


import com.retail.billing.retail_billing.io.OrderRequest;
import com.retail.billing.retail_billing.io.OrderResponse;
import com.retail.billing.retail_billing.io.PaymentVerificationRequest;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    void deleteOrder(String orderId);

    List<OrderResponse> getLatestOrders();

    OrderResponse verifyPayment(PaymentVerificationRequest request);

    Double sumSalesByDate(LocalDate date);

    Long countByOrderDate(LocalDate date);

    List<OrderResponse>findRecentOrders();

}
