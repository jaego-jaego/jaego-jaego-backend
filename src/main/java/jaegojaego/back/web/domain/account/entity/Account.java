package jaegojaego.back.web.domain.account.entity;

import io.swagger.v3.oas.annotations.info.Contact;
import jaegojaego.back.web.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Account extends BaseEntity {

    private final static int PHONE_SIZE = 11;
    private final static int NAME_SIZE = 30;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = PHONE_SIZE)
    private String phone;

    @Column(nullable = false, length = NAME_SIZE)
    private String name;

    @Builder
    public Account(String email, String phone, String name, LocalDate birth, RabbitConnectionDetails.Address address) {
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

}
