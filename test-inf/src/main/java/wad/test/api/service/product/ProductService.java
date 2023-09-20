package wad.test.api.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wad.test.api.service.product.response.ProductResponse;
import wad.test.domain.product.Product;
import wad.test.domain.product.ProductRepository;
import wad.test.domain.product.ProductSellingStatus;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());
        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }
}
