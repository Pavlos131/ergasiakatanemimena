package group54.managementeteries.Repository;

import group54.managementeteries.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.Optional;
@Hidden
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}