package group54.managementeteries.Repository;
import group54.managementeteries.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import group54.managementeteries.Entity.aitisi;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.Optional;
@Hidden

@RepositoryRestResource(path= "aitisi")

public interface AitisiRepository extends JpaRepository<aitisi,Integer>{
    Optional<aitisi> findById(Integer id);
}
