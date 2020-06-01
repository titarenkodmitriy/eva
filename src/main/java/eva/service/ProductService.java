package eva.service;

import eva.dao.IProductDAO;
import eva.dao.IProductRepository;
import eva.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository dao;
    @Autowired
    IProductDAO pdao;

    @Override
    public Stream<Product> getAllProductAsStream() {
        return dao.getAllAsStream();
    }

    @Override
    public List<Product> getAllProduct() {
        return pdao.getAllProduct();
    }
}
