package jaegojaego.back.web.domain.product.service;

import jaegojaego.back.web.domain.product.dto.ProductDTO;
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

    public ProductDTO.Response save(ProductDTO.Request requestDto){
        ProductDTO productDTO = new ProductDTO(requestDto);
        Product product = productRepository.save(productDTO.toEntity());
        return ProductDTO.Response.fromEntity(product);
    }
    public void delete(Long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        } else {
            log.info(id+" 값을 가진 데이터를 찾을 수 없습니다.");
        }
    }

//    public Pro



}
