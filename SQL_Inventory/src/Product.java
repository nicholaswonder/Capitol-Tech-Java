import java.util.Objects;

public class Product {
    private final int id;
    private String name;
    private double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.id = 0;
        this.name = name;
        this.price = price;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public int GetID() {
        return id;
    }

    // id cannot be changed in sql, so it shouldn't be changed in the object

    public double GetPrice() {
        return price;
    }

    public void SetPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public String toString() {
        return id + ", " + name + ", $" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
