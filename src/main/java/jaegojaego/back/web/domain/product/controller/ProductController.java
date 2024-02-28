package jaegojaego.back.web.domain.product.controller;

import com.google.protobuf.Api;
import jaegojaego.back.web.common.apiResult.ApiResult;
import jaegojaego.back.web.common.apiResult.CommonResult;
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

    @PostMapping("/delete")
    public ApiResult<ProductDTO.Delete>productDelete(@RequestBody ProductDTO.Delete req) {
        log.info("productDelete 확인 ========> {}", req);
        ProductDTO.Delete delete = productService.delete(req);
        ApiResult<ProductDTO.Delete> deleteApiResult = ApiResult.notFound(delete);

        return delete != null ? ApiResult.success(delete) : ApiResult.notFound(delete);

    }
}
