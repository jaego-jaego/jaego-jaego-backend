package jaegojaego.back.web.domain.product.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Entity
@Getter
@NoArgsConstructor

public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;          // 품번

    @Column(nullable = false)
    private String productName;     // 품명

    @Column(nullable = false)
    private String  mainCustomer;   // 주요 납품처

    @Column(nullable = false)
    private String validId;         // 유효 아이디

    @Column(nullable = false)
    private int yearNum;            // 연자리수

    @Column(nullable = false)
    private int monthNum;           // 월자리수

    @Column(nullable = false)
    private int dateNum;            // 일자리수

    @Column(nullable = false)
    private int numDigits;          // 순번자리수

    @Builder
    public Product(String productName, String mainCustomer, String validId, int yearNum, int monthNum, int dateNum, int numDigits) {
        this.productName = productName;
        this.mainCustomer = mainCustomer;
        this.validId = validId;
        this.yearNum = yearNum;
        this.monthNum = monthNum;
        this.dateNum = dateNum;
        this.numDigits = numDigits;
    }



}


