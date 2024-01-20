package jaegojaego.back.web.repository;

import jaegojaego.back.web.entity.CreateAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateAccountRepository extends JpaRepository<CreateAccount, Long> {
}
