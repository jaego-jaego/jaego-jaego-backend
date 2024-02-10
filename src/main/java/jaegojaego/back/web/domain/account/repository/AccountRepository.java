package jaegojaego.back.web.domain.account.repository;

import jaegojaego.back.web.domain.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
