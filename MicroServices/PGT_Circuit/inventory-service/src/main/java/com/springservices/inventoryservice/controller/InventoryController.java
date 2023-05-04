package com.springservices.inventoryservice.controller;


import com.springservices.inventoryservice.dto.InventoryResponse;
import com.springservices.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @SneakyThrows
    @GetMapping("/")
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){

        log.info("Sleep started");

        Thread.sleep(10000);

        log.info("Sleep Ended");


        return inventoryService.isInStock(skuCode);
    }


}
