package onlinecatalog.onlinecatalog.repository;

import onlinecatalog.onlinecatalog.model.PendingUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingUserRepository extends JpaRepository<PendingUser, Integer> {

}
