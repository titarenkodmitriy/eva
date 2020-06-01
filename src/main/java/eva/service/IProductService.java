package eva.service;

import eva.entity.Product;

import java.util.List;
import java.util.stream.Stream;


public interface IProductService {
    Stream<Product> getAllProductAsStream();
    List<Product> getAllProduct();
}
