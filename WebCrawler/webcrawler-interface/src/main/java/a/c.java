package a;

public class c {
    private int num;
    private String name;
    private double price;
    private long p;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getP() {
        return p;
    }

    public void setP(long p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "c{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", p=" + p +
                '}';
    }
}
