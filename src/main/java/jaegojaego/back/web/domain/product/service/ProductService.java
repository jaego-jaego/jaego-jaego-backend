package jaegojaego.back.web.domain.product.service;

import jaegojaego.back.web.domain.product.dto.ProductDeleteDTO;
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

    public void delete(Long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        } else {
            log.info(id+" 값을 가진 데이터를 찾을 수 없습니다.");
        }
    }



}
