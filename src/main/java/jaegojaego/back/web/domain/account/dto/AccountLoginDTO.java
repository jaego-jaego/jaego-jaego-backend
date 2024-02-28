package jaegojaego.back.web.domain.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jaegojaego.back.web.domain.account.entity.Account;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@NoArgsConstructor
public class AccountLoginDTO {

    @Data
    @Schema(name = "AccountLoginDTO_Request")
    public static class Request {
        @Schema(description = "아이디")
        private String userId; //아이디
        @Schema(description = "비밀번호")
        private String userPw; //비밀번호
    }

    @Data
    @Schema(name = "AccountLoginDTO_Response")
    public static class Response {
        @Schema(description = "이메일")
        private String email; //이메일
        @Schema(description = "전화번호")
        private String phone; //전화번호
        @Schema(description = "대표자성명")
        private String name; //대표자성명
        @Schema(description = "사업자등록번호")
        private String businessNumber; //사업자등록번호
        @Schema(description = "개업일자")
        private String openDate; //개업일자
        @Schema(description = "상호")
        private String shopName; //상호
        @Schema(description = "아이디")
        private String userId; //아이디
        @Schema(description = "비밀번호")
        private String userPw; //비밀번호

        public static Response fromEntity(Account account) {
            Response response = new Response();
            response.setEmail(account.getEmail());
            response.setPhone(account.getPhone());
            response.setName(account.getName());
            response.setBusinessNumber(account.getBusinessNumber());
            response.setOpenDate(account.getOpenDate());
            response.setShopName(account.getShopName());
            response.setUserId(account.getUserId());
            response.setUserPw(account.getUserPw());
            return response;
        }
    }

    private Request request;
    private Response response;

    public AccountLoginDTO(Request request) {
        this.request = request;
    }

    public AccountLoginDTO(Response response) {
        this.response = response;
    }

    //toEntity()메서드를 통해 Service > Database(Entity)로 Data를 전달할 때 Dto를 통해서 전달
    public Account toEntity() {
        Account account = Account.builder()
                .userId(request.getUserId())
                .userPw(request.getUserPw())
                .build();
        return account;
    }

    //이 메서드를 통해 Database(Entity) > Service로 Data를 전달할 때 Entity를 Dto로 전달
    public Account fromEntity() {
        Account account = Account.builder()
                .email(response.getEmail())
                .phone(response.getPhone())
                .name(response.getName())
                .businessNumber(response.getBusinessNumber())
                .openDate(response.getOpenDate())
                .shopName(response.getShopName())
                .userId(response.getUserId())
                .userPw(response.getUserPw())
                .build();
        return account;
    }

}
