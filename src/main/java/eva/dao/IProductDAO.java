package eva.dao;

import eva.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IProductDAO {
    List<Product> getAllProduct();
    Product getById(Integer id);
}
