package cn.agree.domain;

public class IdCard {
    // 身份证号
    private String number;
    private String address;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "number='" + number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
