package jaegojaego.back.web.domain.account.service;

import jaegojaego.back.web.domain.account.dto.AccountJoinDTO;
import jaegojaego.back.web.domain.account.dto.AccountLoginDTO;
import jaegojaego.back.web.domain.account.entity.Account;
import jaegojaego.back.web.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
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

        if(loginAccount.isEmpty()){ return null; }

        Account account = loginAccount.get();

        if(!account.getUserPw().equals(requestDto.getUserPw())) { return null; }

        return AccountLoginDTO.Response.fromEntity(account);
    }

}
