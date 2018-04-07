package kartheek.springframework.services;

import kartheek.springframework.config.JpaIntegrationConfig;
import kartheek.springframework.models.Product;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class ProductServiceJpaIntegrationTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Ignore
    @Test
    public void testListMethod() throws Exception {

        List<Product> products = (List<Product>) productService.listAll();
        assertThat(products.size(), is(6));
    }

    @Ignore
    @Test
    public void testGetById() throws Exception {

        Integer productId = 1;
        Product product = productService.getById(productId);
        assertThat(product.getId(), is(1));
    }

    @Ignore
    @Test
    public void testSave() throws Exception {

        Product product = new Product();
        product.setPrice(BigDecimal.TEN);
        product.setImageUrl("www.gulte.com");
        product.setDescription("My knowledge centre");

        Product savedProduct = productService.saveOrUpdate(product);

        assertThat(savedProduct.getDescription(), is("My knowledge centre"));
        assertThat(savedProduct.getImageUrl(), is("www.gulte.com"));
    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {

        Integer productId = 1;
        Product product = productService.getById(productId);
        product.setImageUrl("my new changed url");
        product.setPrice(new BigDecimal("1000000"));

        Product updatedProduct = productService.saveOrUpdate(product);
        assertThat(updatedProduct.getImageUrl(), is("my new changed url"));
        assertThat(updatedProduct.getPrice(), is(new BigDecimal("1000000")));
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {

        List<Product> productList = (List<Product>) productService.listAll();
        System.out.println(productList.size());
        assertThat(productList.size(), is(5));
        Integer productId = 2;
        productService.delete(productId);

        List<Product> updatedProductList = (List<Product>) productService.listAll();

        assertThat(updatedProductList.size(), is(4));
    }
}
