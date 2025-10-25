package com.retail.billing.retail_billing.service;

import com.razorpay.RazorpayException;
import com.retail.billing.retail_billing.io.RazorpayOrderResponse;

public interface RazorpayService {

   RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException;

}
