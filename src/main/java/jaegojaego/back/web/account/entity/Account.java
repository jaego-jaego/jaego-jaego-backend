package jaegojaego.back.web.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Account {

    private final static int PHONE_SIZE = 11;
    private final static int NAME_SIZE = 30;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = PHONE_SIZE)
    private String phone;

    @Column(nullable = false, length = NAME_SIZE)
    private String name;

    public Account(String email, String phone, String name, LocalDate birth, RabbitConnectionDetails.Address address) {
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

}
