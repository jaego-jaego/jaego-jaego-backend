package jaegojaego.back.web.account.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
@Data
@Getter
public class AccountJoinParamVO {
    private String email;
    private String phone;
    private String name;
}
