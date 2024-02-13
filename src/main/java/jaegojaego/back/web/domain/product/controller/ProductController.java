package jaegojaego.back.web.domain.product.controller;

import jaegojaego.back.web.common.apiResult.ApiResult;
import jaegojaego.back.web.domain.product.dto.ProductInsertDTO;
import jaegojaego.back.web.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/insert")
    public ApiResult<ProductInsertDTO.Response>productInsert(@RequestBody ProductInsertDTO.Request requestDto){
        log.info("productInsert 확인 ========> {}", requestDto);
        ProductInsertDTO.Response response = productService.save(requestDto);
        ApiResult<ProductInsertDTO.Response> getProductInsertResponse = ApiResult.success(response);
        return getProductInsertResponse;
    }
}
