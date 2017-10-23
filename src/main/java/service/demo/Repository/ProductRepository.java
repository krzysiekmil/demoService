package service.demo.Repository;
import org.springframework.data.repository.CrudRepository;
import service.demo.Model.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {
}
