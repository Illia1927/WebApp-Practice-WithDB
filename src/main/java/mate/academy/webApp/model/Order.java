package mate.academy.webApp.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long orderId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_to_good",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Good> goods = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {
    }

    public Order(List<Good> goods, User user) {
        this.user = user;
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getOrderId(), order.getOrderId()) &&
                Objects.equals(getGoods(), order.getGoods()) &&
                Objects.equals(getUser(), order.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getGoods(), getUser());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                '}';
    }
}
