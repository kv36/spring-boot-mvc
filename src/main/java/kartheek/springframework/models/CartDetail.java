package kartheek.springframework.models;

import javax.persistence.*;

@Entity
public class CartDetail implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;

    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
