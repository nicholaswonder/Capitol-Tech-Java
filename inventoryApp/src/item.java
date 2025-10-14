import java.util.Objects;

public class item
{
    private double cost;
    private String name;
    private int quantity;
    private double totalValue;

    public item()
    {
        cost = 0;
        name = "NULL";
        quantity = 0;
        totalValue = 0;
    }

    public item(String name, double cost, int quantity)
    {
        this();
        setName(name);
        setCost(cost);
        setQuantity(quantity);
    }

    public item(String name, double cost) // To search for a product
    {
        this();
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost >= 0)
        {
            this.cost = cost;
            setTotalValue(this.cost, getQuantity());
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0)
        {
            this.quantity = quantity;
            setTotalValue(getCost(), this.quantity);
        }
    }

    public void addQuantity(int quan){
        if (quan >= 0){
            this.quantity += quan;
        }
    }

    public double getTotalValue() {
        return totalValue;
    }

    private void setTotalValue(double cost, int quantity) {
        totalValue = cost * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        item item = (item) o;
        return Double.compare(cost, item.cost) == 0 && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, name);
    }

    public String toString()
    {
        return getName() + "\nCost : $" + getCost() + "\nQuantity : " +
                getQuantity() + "\nTotal Value : $" + getTotalValue() + "\n"; // Auto white space in output
    }
}
