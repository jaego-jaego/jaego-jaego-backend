package jaegojaego.back.web.account.repository;

import jaegojaego.back.web.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
