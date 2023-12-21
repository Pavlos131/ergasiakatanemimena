package group54.managementeteries.Repository;


import group54.managementeteries.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.Optional;
@Hidden
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String roleName);
}