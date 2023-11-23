package com.springservices.inventoryservice.service;


import com.springservices.inventoryservice.dto.InventoryResponse;
import com.springservices.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {


    private final InventoryRepository inventoryRepository;


    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes) {

        boolean isAllProductsValid = skuCodes.stream().allMatch(inventoryRepository::existsBySkuCode);

        if (!isAllProductsValid){
            throw new RuntimeException("Invalid SkuCode found");
        }

        return inventoryRepository.findBySkuCodeIn(skuCodes).stream()
                .map(inventory -> InventoryResponse
                        .builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build()
                ).toList();
    }

}
