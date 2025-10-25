package com.retail.billing.retail_billing.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.retail.billing.retail_billing.io.CategoryRequest;
import com.retail.billing.retail_billing.io.CategoryResponse;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request, MultipartFile file);

    List<CategoryResponse> read();

    void delete(String caregoryId);
}  