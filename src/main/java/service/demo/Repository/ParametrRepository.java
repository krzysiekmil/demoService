package service.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import service.demo.Model.Parametr;

@Repository
public interface ParametrRepository extends CrudRepository<Parametr,Long> {
}
