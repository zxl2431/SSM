package cn.agree.domain;

public class Mobile {
    private String mobileName;
    private Float price;

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "mobileName='" + mobileName + '\'' +
                ", price=" + price +
                '}';
    }
}
