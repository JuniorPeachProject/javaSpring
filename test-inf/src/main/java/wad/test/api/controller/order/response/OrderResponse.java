package wad.test.api.controller.order.response;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import wad.test.api.service.product.response.ProductResponse;
import wad.test.domain.order.Order;
import wad.test.domain.order.OrderStatus;
import wad.test.domain.orderProduct.OrderProduct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderResponse {
    private Long id;
    private int totalPrice;
    private LocalDateTime registeredDateTime;
    private List<ProductResponse> products;

    @Builder
    public OrderResponse(Long id, int totalPrice, LocalDateTime registeredDateTime, List<ProductResponse> products) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.registeredDateTime = registeredDateTime;
        this.products = products;
    }

    public static OrderResponse of(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .totalPrice(order.getTotalPrice())
                .registeredDateTime(order.getRegisteredDateTime())
                .products(order.getOrderProducts().stream()
                        .map(orderProduct -> ProductResponse.of(orderProduct.getProduct()))
                        .collect(Collectors.toList()))
                .build();
    }
}
