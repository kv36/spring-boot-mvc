package kartheek.springframework.services;

import kartheek.springframework.models.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product findProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void deleteById(Integer id);
}
