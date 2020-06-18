package mate.academy.webApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "goods_id")
    private Long goodId;

    @Column(name = "name_of_good")
    private String nameOfGood;

    @Column
    private String discription;

    @Column
    private Double price;

    @ManyToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public Good(Long goodId, String nameOfGood, String discription, Double price) {
        this.goodId = goodId;
        this.nameOfGood = nameOfGood;
        this.discription = discription;
        this.price = price;
    }

    public Good(String nameOfGood, String discription, Double price) {
        this.nameOfGood = nameOfGood;
        this.discription = discription;
        this.price = price;
    }

    public Good() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getNameOfGood() {
        return nameOfGood;
    }

    public void setNameOfGood(String nameOfGood) {
        this.nameOfGood = nameOfGood;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Good)) return false;
        Good good = (Good) o;
        return Objects.equals(getGoodId(), good.getGoodId()) &&
                Objects.equals(getNameOfGood(), good.getNameOfGood()) &&
                Objects.equals(getDiscription(), good.getDiscription()) &&
                Objects.equals(getPrice(), good.getPrice()) &&
                Objects.equals(getOrders(), good.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGoodId(), getNameOfGood(), getDiscription(), getPrice(), getOrders());
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId=" + goodId +
                ", nameOfGood='" + nameOfGood + '\'' +
                ", discription='" + discription + '\'' +
                ", price=" + price +
                '}';
    }
}
