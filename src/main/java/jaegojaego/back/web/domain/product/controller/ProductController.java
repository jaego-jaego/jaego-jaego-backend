package jaegojaego.back.web.domain.product.controller;

import jaegojaego.back.web.common.apiResult.ApiResult;
import jaegojaego.back.web.domain.product.dto.ProductDTO;
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
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/insert")
    public ApiResult<ProductDTO.Response>productInsert(@RequestBody ProductDTO.Request requestDto){
        log.info("productInsert 확인 ========> {}", requestDto);
        ProductDTO.Response response = productService.save(requestDto);
        ApiResult<ProductDTO.Response> getProductInsertResponse = ApiResult.success(response);
        return getProductInsertResponse;
    }
//
//    @PostMapping("/delete")
//    public ApiResult<ProductDeleteDTO>productDelete(@RequestBody ProductDeleteDTO req){
//        log.info("productDelete 확인 ========> {}", req);
//        productService.delete(req.getProductId());
//        ApiResult<ProductDeleteDTO> getProductDelete = ApiResult.success(req);
//        return getProductDelete;
//    }

    @PostMapping("/delete")
    public ApiResult<ProductDTO.Delete>productDelete(@RequestBody ProductDTO.Delete req){
        log.info("productDelete 확인 ========> {}", req);
        productService.delete(req.getProductId());
        ApiResult<ProductDTO.Delete> getProductDelete = ApiResult.success(req);
        return getProductDelete;
    }
}
