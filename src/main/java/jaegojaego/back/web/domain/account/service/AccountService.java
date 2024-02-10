package jaegojaego.back.web.domain.account.service;

import jaegojaego.back.web.domain.account.dto.AccountJoinDTO;
import jaegojaego.back.web.domain.account.entity.Account;
import jaegojaego.back.web.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    @Transactional
    public AccountJoinDTO save(AccountJoinDTO accountJoinDTO) {
        Account savedAccount = accountRepository.save(accountJoinDTO.toEntity());
        return new AccountJoinDTO(savedAccount);
    }
}
