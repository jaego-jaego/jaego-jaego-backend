package jaegojaego.back.web.domain.account.dto;

import lombok.Data;
import lombok.Getter;
@Data
@Getter
public class AccountJoinParamVO {
    private String email;
    private String phone;
    private String name;
}
