package com.retail.billing.retail_billing.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.retail.billing.retail_billing.io.ItemRequest;
import com.retail.billing.retail_billing.io.ItemResponse;

public interface ItemService {


      ItemResponse add(ItemRequest request, MultipartFile file);

      List<ItemResponse>fetchItems();
      
      void deleteItem(String itemId);
}
