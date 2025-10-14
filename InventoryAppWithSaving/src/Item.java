import java.util.Objects;

public class Item {

    // Variables
    private String Name;
    private int Quantity;
    private double UnitCost;

    // Constructors
    public Item() {
        Name = "NULL";
        Quantity = 0;
        UnitCost = 0;
    }

    public Item(String NewName, double NewUnitCost, int NewQuantity){
        this();
        SetName(NewName);
        SetUnitCost(NewUnitCost);
        SetQuantity(NewQuantity);
    }

    public Item(String NewName){
        this();
        SetName(NewName);
    }

    // Getters and Setters
    public void SetName(String NewName) {
        if (!NewName.isEmpty()) {
           Name = NewName;
        }
    }

    public String GetName(){
        return Name;
    }

    public void SetQuantity(int NewQuan) {
        if (NewQuan >= 0) {
            Quantity = NewQuan;
        }
    }

    public int GetQuantity() {
        return Quantity;
    }

    public void SetUnitCost(double NewVal) {
        if (NewVal >= 0) {
            UnitCost = NewVal;
        }
    }

    public double GetUnitCost() {
        return UnitCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(Name, item.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Name);
    }

    public String toCSV(){
        return GetName() + "," + GetUnitCost() + "," + GetQuantity();
    }

    @Override
    public String toString(){
        return GetName() + "\n" +
                "Cost: $" + GetUnitCost() + "\n" +
                "Quantity: " + GetQuantity() + "\n";
    }
}
