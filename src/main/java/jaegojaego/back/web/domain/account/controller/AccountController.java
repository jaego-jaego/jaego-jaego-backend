package jaegojaego.back.web.domain.account.controller;

import jaegojaego.back.web.common.apiResult.ApiResult;
import jaegojaego.back.web.domain.account.dto.AccountJoinDTO;
import jaegojaego.back.web.domain.account.dto.AccountLoginDTO;
import jaegojaego.back.web.domain.account.entity.Account;
import jaegojaego.back.web.domain.account.service.AccountService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;
    @Autowired
    private HttpSession httpSession;

    //회원가입
    @PostMapping("/join")
    public ApiResult<AccountJoinDTO.Response> accountJoin(@RequestBody AccountJoinDTO.Request requestDto){
        log.info("accountJoinDTO 확인 ========> {}", requestDto);
        AccountJoinDTO.Response response = accountService.save(requestDto);
        ApiResult<AccountJoinDTO.Response> getAccountJoinResponse = ApiResult.success(response);
        return getAccountJoinResponse;
    }


    //로그인
    @PostMapping("/login")
    public ApiResult<AccountLoginDTO.Response> accountLogin(@RequestBody AccountLoginDTO.Request requestDto){
        log.info("AccountLoginDTO 확인 ========> {}", requestDto);
        ApiResult<AccountLoginDTO.Response> test = new ApiResult<AccountLoginDTO.Response>();

        AccountLoginDTO.Response account = accountService.login(requestDto);
        if (account != null) {
            // 로그인 성공 시 세션에 사용자 정보를 저장합니다.
            httpSession.setAttribute("loggedInUser", account);
            httpSession.setAttribute("nickname", account.getName());

            return ApiResult.success(account);
        } else {
            log.info("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return null;
        }
        //TODO 비밀번호 조회 로직
        //TODO 아이디 조회 로직
        //TODO return 변경
    }

}
