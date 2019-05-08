package mate.academy.webApp.model;

public class Good {
    private Long id;
    private String nameOfGood;
    private String discription;
    private Double price;

    public Good(Long id, String nameOfGood, String discription, Double price) {
        this.id = id;
        this.nameOfGood = nameOfGood;
        this.discription = discription;
        this.price = price;
    }

    public Good(String nameOfGood, String discription, Double price) {
        this.nameOfGood = nameOfGood;
        this.discription = discription;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        if (getId() != null ? !getId().equals(good.getId()) : good.getId() != null) return false;
        if (getNameOfGood() != null ? !getNameOfGood().equals(good.getNameOfGood()) : good.getNameOfGood() != null)
            return false;
        if (getDiscription() != null ? !getDiscription().equals(good.getDiscription()) : good.getDiscription() != null)
            return false;
        return getPrice() != null ? getPrice().equals(good.getPrice()) : good.getPrice() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNameOfGood() != null ? getNameOfGood().hashCode() : 0);
        result = 31 * result + (getDiscription() != null ? getDiscription().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", nameOfGood='" + nameOfGood + '\'' +
                ", discription='" + discription + '\'' +
                ", price=" + price +
                '}';
    }
}
