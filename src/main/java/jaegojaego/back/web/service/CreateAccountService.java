package jaegojaego.back.web.service;

import jaegojaego.back.web.entity.CreateAccount;
import jaegojaego.back.web.repository.CreateAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountService {
    private final CreateAccountRepository createAccountRepository;

    public CreateAccountService(CreateAccountRepository createAccountRepository) {
        this.createAccountRepository = createAccountRepository;
    }

    public CreateAccount insertAccount(CreateAccount createAccount){
        return createAccountRepository.save(createAccount);
    }
}
