package wad.test.api.controller.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wad.test.api.ApiResponse;
import wad.test.api.controller.product.dto.request.ProductCreateRequest;
import wad.test.api.service.product.ProductService;
import wad.test.api.service.product.response.ProductResponse;

import java.util.List;

import static wad.test.api.ApiResponse.ok;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @PostMapping("/api/v1/products/new")
    public ApiResponse<ProductResponse> creatProduct(@Valid @RequestBody ProductCreateRequest request) {
        return ok(productService.createProduct(request.toServiceRequest()));
    }

    @GetMapping("/api/v1/products/selling")
    public ApiResponse<List<ProductResponse>> getSellingProducts() {
        return ok(productService.getSellingProducts());
    }
}
