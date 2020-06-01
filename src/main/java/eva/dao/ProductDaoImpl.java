package eva.dao;

import eva.dao.mapper.ProductMapper;
import eva.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class ProductDaoImpl  implements IProductDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProduct() {
        return jdbcTemplate.query("SELECT * FROM products", new ProductMapper());
    }

    @Override
    public Product getById(Integer id){
        List<Product> list = jdbcTemplate.query("select * from products where id = ?",
                new Object[]{Integer.valueOf(id)}, new ProductMapper());
        System.out.println("List size - " + list.size() );
        if(list.size() == 1){
            return list.get(0);
        }else return null;
    }
}
