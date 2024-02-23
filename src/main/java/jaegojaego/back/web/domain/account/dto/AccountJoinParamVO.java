package jaegojaego.back.web.domain.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
@Data
@Getter
public class AccountJoinParamVO {
    @Schema(description = "이메일")
    private String email;
    @Schema(description = "전화번호")
    private String phone;
    @Schema(description = "대표자성명")
    private String name;
}
