package jaegojaego.back.web.domain.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jaegojaego.back.web.domain.product.entity.Product;
import jakarta.persistence.Column;
import lombok.*;

@Data
@Getter
@NoArgsConstructor
public class ProductInsertDTO {

    @Data
    public static class Request {
        @Schema(description = "품명")
        private String productName;     // 품명
        @Schema(description = "주요 납품처")
        private String  mainCustomer;   // 주요 납품처
        @Schema(description = "유효 아이디")
        private String validId;         // 유효 아이디
        @Schema(description = "연자리수")
        private int yearNum;            // 연자리수
        @Schema(description = "월자리수")
        private int monthNum;           // 월자리수
        @Schema(description = "일자리수")
        private int dateNum;            // 일자리수
        @Schema(description = "순번자리수")
        private int numDigits;          // 순번자리수
    }

    @Data
    public static class Response {

        @Schema(description = "품명")
        private String productName;     // 품명
        @Schema(description = "주요 납품처")
        private String  mainCustomer;   // 주요 납품처
        @Schema(description = "유효 아이디")
        private String validId;         // 유효 아이디
        @Schema(description = "연자리수")
        private int yearNum;            // 연자리수
        @Schema(description = "월자리수")
        private int monthNum;           // 월자리수
        @Schema(description = "일자리수")
        private int dateNum;            // 일자리수
        @Schema(description = "순번자리수")
        private int numDigits;          // 순번자리수
        public static jaegojaego.back.web.domain.product.dto.ProductInsertDTO.Response fromEntity(Product product) {
            jaegojaego.back.web.domain.product.dto.ProductInsertDTO.Response response = new jaegojaego.back.web.domain.product.dto.ProductInsertDTO.Response();
            response.setProductName(product.getProductName());
            response.setMainCustomer(product.getMainCustomer());
            response.setValidId(product.getValidId());
            response.setYearNum(product.getYearNum());
            response.setMonthNum(product.getMonthNum());
            response.setDateNum(product.getDateNum());
            response.setNumDigits(product.getNumDigits());
            return response;
        }
    }

    private jaegojaego.back.web.domain.product.dto.ProductInsertDTO.Request request;
    private jaegojaego.back.web.domain.product.dto.ProductInsertDTO.Response response;

    public ProductInsertDTO(jaegojaego.back.web.domain.product.dto.ProductInsertDTO.Request request) {
        this.request = request;
    }

    public ProductInsertDTO(jaegojaego.back.web.domain.product.dto.ProductInsertDTO.Response response) {
        this.response = response;
    }

    //toEntity()메서드를 통해 Service > Database(Entity)로 Data를 전달할 때 Dto를 통해서 전달
    public Product toEntity() {
        Product product = Product.builder()
                .productName(request.getProductName())
                .mainCustomer(request.getMainCustomer())
                .validId(request.getValidId())
                .yearNum(request.getYearNum())
                .monthNum(request.getMonthNum())
                .dateNum(request.getDateNum())
                .numDigits(request.getNumDigits())
                .build();
        return product;
    }

    //이 메서드를 통해 Database(Entity) > Service로 Data를 전달할 때 Entity를 Dto로 전달
    public Product fromEntity() {
        Product product = Product.builder()
                .productName(response.getProductName())
                .mainCustomer(response.getMainCustomer())
                .validId(response.getValidId())
                .yearNum(response.getYearNum())
                .monthNum(response.getMonthNum())
                .dateNum(response.getDateNum())
                .numDigits(response.getNumDigits())
                .build();
        return product;
    }
}
