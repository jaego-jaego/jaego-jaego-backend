package jaegojaego.back.web.domain.account.entity;

import jaegojaego.back.web.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Getter
@NoArgsConstructor
@Entity
public class Account extends BaseEntity {

    private final static int PHONE_SIZE = 11;
    private final static int NAME_SIZE = 30;

    @Column(nullable = false)
    private String email; //이메일

    @Column(nullable = false, length = PHONE_SIZE)
    private String phone; //전화번호

    @Column(nullable = false, length = NAME_SIZE)
    private String name; //대표자성명

    @Column(nullable = false)
    private String businessNumber; //사업자등록번호

    @Column(nullable = false)
    private String openDate; //개업일자

    @Column(nullable = false)
    private String shopName; //상호

    @Column(nullable = false)
    private String userId; //아이디

    @Column(nullable = false)
    private String userPw; //비밀번호

    @Builder
    public Account(String email, String phone, String name, RabbitConnectionDetails.Address address, String businessNumber, String openDate, String shopName, String userId, String userPw) {
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.businessNumber = businessNumber;
        this.openDate = openDate;
        this.shopName = shopName;
        this.userId = userId;
        this.userPw = userPw;
    }

}
