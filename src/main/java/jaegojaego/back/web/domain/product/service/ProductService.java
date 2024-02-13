package jaegojaego.back.web.domain.product.service;

import jaegojaego.back.web.domain.product.dto.ProductInsertDTO;
import jaegojaego.back.web.domain.product.entity.Product;
import jaegojaego.back.web.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductInsertDTO.Response save(ProductInsertDTO.Request requestDto){
        ProductInsertDTO productInsertDTO = new ProductInsertDTO(requestDto);
        Product product = productRepository.save(productInsertDTO.toEntity());

        return ProductInsertDTO.Response.fromEntity(product);
    }

}
