package jaegojaego.back.web.domain.account.controller;

import jaegojaego.back.web.domain.account.dto.AccountJoinDTO;
import jaegojaego.back.web.domain.account.dto.AccountJoinParamVO;
import jaegojaego.back.web.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    //회원가입
    @PostMapping("/join")
    public String accountJoin(@RequestBody AccountJoinDTO accountJoinDTO){
        log.info("accountJoinDTO 확인 ========> {}", accountJoinDTO);
        accountService.save(accountJoinDTO);
        return "";
    }
}
