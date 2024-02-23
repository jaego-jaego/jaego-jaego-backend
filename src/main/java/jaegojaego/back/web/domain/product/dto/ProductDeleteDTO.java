package jaegojaego.back.web.domain.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ProductDeleteDTO {
    @Schema(description = "품번")
    private Long productId;
}
