package jaegojaego.back.web.domain.account.dto;

import jaegojaego.back.web.domain.account.entity.Account;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
public class AccountJoinDTO {
    private String email; //이메일
    private String phone; //전화번호
    private String name; //대표자성명
    private String businessNumber; //사업자등록번호
    private String openDate; //개업일자
    private String shopName; //상호
    private String userId; //아이디
    private String userPw; //비밀번호
//    @Enumerated(EnumType.STRING)
//    private RoleType role;

    public AccountJoinDTO(Account account) {
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.businessNumber = businessNumber;
        this.openDate = openDate;
        this.shopName = shopName;
        this.userId = userId;
        this.userPw = userPw;
    }

    //toEntity()메서드를 통해 Service > Database(Entity)로 Data를 전달할 때 Dto를 통해서 전달
    public Account toEntity() {
        Account account = Account.builder()
                .email(email)
                .phone(phone)
                .name(name)
                .email(email)
                .businessNumber(businessNumber)
                .openDate(openDate)
                .shopName(shopName)
                .userId(userId)
                .userPw(userPw)
                .build();
        return account;
    }
}
