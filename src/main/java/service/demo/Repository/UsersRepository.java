package service.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.demo.Model.Users;
import java.util.Optional;
public interface UsersRepository extends JpaRepository<Users,Integer>{
        Optional<Users>findByName(String username);
}


