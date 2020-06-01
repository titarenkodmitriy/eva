package eva.dao;

import eva.entity.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {
    @Query("select * from products")
    Stream<Product>getAllAsStream();
}
