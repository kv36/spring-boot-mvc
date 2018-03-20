package kartheek.springframework.services;

import kartheek.springframework.models.Product;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer, Product> products;

    public ProductServiceImpl() {
        loadAllProducts();
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findProductById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        if (product != null){
            if (product.getId() == null){
                product.setId(getNextKey());
            }
            products.put(product.getId(), product);

            return product;
        } else {
            throw new RuntimeException("Product Can't be null");
        }
    }

    private Integer getNextKey(){
        return Collections.max(products.keySet()) + 1;
    }

    @Override
    public void deleteById(Integer id) {
        products.remove(id);
    }

    public void loadAllProducts() {

        products = new HashMap<>();
        Product product1 = new Product();
        product1.setDescription("This is my best Tv");
        product1.setId(1);
        product1.setImageUrl("image url1");
        product1.setPrice(BigDecimal.TEN);

        products.put(1, product1);

        Product product2 = new Product();
        product2.setDescription("This is my best Refrigerator");
        product2.setId(2);
        product2.setImageUrl("image url2");
        product2.setPrice(BigDecimal.TEN);

        products.put(2, product2);

        Product product3 = new Product();
        product3.setDescription("This is my best project");
        product3.setId(3);
        product3.setImageUrl("image url3");
        product3.setPrice(BigDecimal.TEN);

        products.put(3, product3);
    }
}
