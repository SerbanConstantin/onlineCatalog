package onlinecatalog.onlinecatalog.repository;

import onlinecatalog.onlinecatalog.model.PendingUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PendingUserRepository extends JpaRepository<PendingUser, Integer> {

    Optional<PendingUser> findByActivationCode(String activationCode);
}
