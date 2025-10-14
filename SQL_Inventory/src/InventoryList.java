import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryList {
    // Array object to hold Product objects
    private ArrayList<Product> list;
    private DataAccessLayer dl = new DataAccessLayer();

    public InventoryList() {
        list = new ArrayList<Product>();
        FillList();
    }

    private void FillList() {
        System.out.println("Retrieving Inventory Data...");
        try {
            ResultSet data = dl.GetProducts();
            int id;
            String name;
            double price;
            while (data.next()){
                id = data.getInt("ProductId");
                name = data.getString("ProductName");
                price = data.getDouble("Price");
                list.add(new Product(id,name,price));
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve inventory data!");
            System.out.println(e.getMessage());
        }
    }

    public void PrintRawData(){ // Mainly for testing if data was put into the arrays
        for (Product p : list){
            System.out.println(p);
        }
    }

    public void PrintData() { // Displaying data in a manner the user can understand
        System.out.println("Displaying products: ");
        for (Product p : list) {
            System.out.println(p.GetName() + " : $" + p.GetPrice());
        }
        System.out.println();
    }

    public void PrintSelection() {
        for (Product p : list) {
            System.out.println(list.indexOf(p) + ". " + p.GetName() + " - $" + p.GetPrice());
        }
        System.out.println();
    }

    public void NewProduct(String name, double price) {
        Product test = new Product(name,price);
        if (!list.contains(test)) {
            try {
                ResultSet data = dl.NewProduct(name, price);
                data.next();
                int id = data.getInt("ProductId");
                Product p = new Product(id, name, price);
                list.add(p);
            } catch (SQLException e) {
                System.out.println("Application error creating new product!");
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("This product already exists!");
        }
    }

    public int GetId(int index){
        return list.get(index).GetID();
    }

    public void UpdateProduct(int index, String name, double price){
        Product p = new Product(name,price);
        if (!list.contains(p)){
            int id = list.get(index).GetID();
            dl.UpdateProduct(id,name,price);
            list.get(index).SetName(name);
            list.get(index).SetPrice(price);
        } else {
            System.out.println("This product already exists!");
        }
    }
}
