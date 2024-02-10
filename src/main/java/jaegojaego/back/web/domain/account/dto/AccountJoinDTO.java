package jaegojaego.back.web.domain.account.dto;

import jaegojaego.back.web.domain.account.entity.Account;
import jaegojaego.back.web.util.RoleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
public class AccountJoinDTO {
    private String email;
    private String phone;
    private String name;
//    @Enumerated(EnumType.STRING)
//    private RoleType role;

    //@Builder
    public AccountJoinDTO(String email, String phone, String name, RoleType role) {
        this.email=email;
        this.phone=phone;
        this.name=name;
//        this.role= role;
    }

    public AccountJoinDTO(Account account) {
        this.email = account.getEmail();
        this.phone = account.getPhone();
        this.name = account.getName();
//        this.role = account.getRole();
    }

    //toEntity()메서드를 통해 Service > Database(Entity)로 Data를 전달할 때 Dto를 통해서 전달
    public Account toEntity() {
        Account account = Account.builder()
                .email(email)
                .phone(phone)
                .name(name)
                .email(email)
//                .role(role)
                .build();
        return account;
    }
}
