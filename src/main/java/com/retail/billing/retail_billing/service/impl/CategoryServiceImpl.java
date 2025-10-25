package com.retail.billing.retail_billing.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.retail.billing.retail_billing.entity.CategoryEntity;
import com.retail.billing.retail_billing.io.CategoryRequest;
import com.retail.billing.retail_billing.io.CategoryResponse;
import com.retail.billing.retail_billing.repository.CategoryRepository;
import com.retail.billing.retail_billing.repository.ItemRepository;
import com.retail.billing.retail_billing.service.CategoryService;
import com.retail.billing.retail_billing.service.FileUploadService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileUploadService fileUploadService;
    private final ItemRepository itemRepository;

    @Override
    public CategoryResponse add(CategoryRequest request, MultipartFile file){
        String imgUrl = fileUploadService.uploadFile(file);

        CategoryEntity newCategory = convertToEntity(request);
        newCategory.setImgUrl(imgUrl);
        newCategory = categoryRepository.save(newCategory);
        return convertToResponse(newCategory);
    }
    @Override
    public List<CategoryResponse> read(){
           return categoryRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());


    }
    @Override
    public void delete(String categoryId){
        CategoryEntity existingCategory = categoryRepository.findByCategoryId(categoryId)
             .orElseThrow(() -> new RuntimeException("category not found:"+categoryId));
        fileUploadService.deleteFile(existingCategory.getImgUrl());
        categoryRepository.delete(existingCategory);

    }
    private CategoryResponse convertToResponse(CategoryEntity newCategory){
      Integer itemsCount = itemRepository.countByCategoryId(newCategory.getId());
         return CategoryResponse.builder()
                  .categoryId(newCategory.getCategoryId())
                  .name(newCategory.getName())
                  .description(newCategory.getDescription())
                  .bgColor(newCategory.getBgColor())
                  .imgUrl(newCategory.getImgUrl())
                  .createdAt(newCategory.getCreatedAt())
                  .updatedAt(newCategory.getUpdatedAt())
                  .items(itemsCount)
                  .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request){
      
        return CategoryEntity.builder()
                  .categoryId(UUID.randomUUID().toString())
                  .name(request.getName())
                  .description(request.getDescription())
                  .bgColor(request.getBgColor())
                  .build();
    }
}
