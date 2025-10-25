package com.retail.billing.retail_billing.service;

import java.util.List;

import com.retail.billing.retail_billing.io.UserRequest;
import com.retail.billing.retail_billing.io.UserResponse;

public interface UserService {

    UserResponse  createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);

}
