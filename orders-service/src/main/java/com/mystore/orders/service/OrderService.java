package com.mystore.orders.service;

import com.mystore.orders.dto.OrderRequest;
import com.mystore.orders.dto.OrderResponse;
import com.mystore.orders.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class OrderService {

    String GET_PROD_URL  = "http://product-service/products/{id}";


    @Autowired
    private DiscoveryClient discoveryClient ;

    @Autowired
    private RestTemplate restTemplate;

    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Product product = restTemplate.getForObject(GET_PROD_URL, Product.class, orderRequest.getProductId());

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        int quantity = orderRequest.getQty();
        double totalPrice = quantity * product.getPrice();

        OrderResponse response = new OrderResponse();
        response.setOrderId(1l);
        response.setProductId(product.getId());
        response.setProductName(product.getName());
        response.setQty(quantity);
        response.setTotalPrice(totalPrice);

        return response;
    }

}
