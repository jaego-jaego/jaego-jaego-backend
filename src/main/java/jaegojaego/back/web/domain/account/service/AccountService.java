package jaegojaego.back.web.domain.account.service;

import jaegojaego.back.web.domain.account.dto.AccountJoinDTO;
import jaegojaego.back.web.domain.account.dto.AccountLoginDTO;
import jaegojaego.back.web.domain.account.entity.Account;
import jaegojaego.back.web.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    @Transactional
    public AccountJoinDTO.Response save(AccountJoinDTO.Request requestDto) {
        AccountJoinDTO accountJoinDTO = new AccountJoinDTO(requestDto);
        Account savedAccount = accountRepository.save(accountJoinDTO.toEntity());

        return AccountJoinDTO.Response.fromEntity(savedAccount);
    }

    public AccountLoginDTO.Response login(AccountLoginDTO.Request requestDto) {
        Optional<Account> loginAccount = accountRepository.findByUserId(requestDto.getUserId());

        if(loginAccount.isEmpty()){
            log.info("아이디가 올바르지 않습니다.");
            return null;
        }

        Account account = loginAccount.get();


        if (account.getFailCount() % 5 == 0 && account.getLastFailLogin() != null) {
            long passLogin = account.getLastFailLogin().until(LocalDateTime.now(), ChronoUnit.MINUTES);
            if(passLogin <= 0.1) {
                log.info("비밀번호 입력 횟수 초과");
                return null;
            }
        }
        if(!account.getUserPw().equals(requestDto.getUserPw())) {
            account.failLogin(account.getFailCount() + 1, LocalDateTime.now());
            log.info("비밀번호가 올바르지 않습니다." + account.getFailCount());
            accountRepository.save(account);
            return null;
        }

        account.failLogin(0,null);
        accountRepository.save(account);
        return AccountLoginDTO.Response.fromEntity(account);
    }

}
