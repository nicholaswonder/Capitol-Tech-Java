import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductList {
    // Array object to hold Product objects
    private ArrayList<Product> list;
    private DataAccessLayer dl = new DataAccessLayer();

    public ProductList() {
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
            int quantity;
            while (data.next()){
                id = data.getInt("ProductId");
                name = data.getString("PName");
                price = data.getDouble("Price");
                quantity = data.getInt("Quantity");
                list.add(new Product(id,name,price,quantity));
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
            System.out.println(p.getName() + " : $" + p.getPrice() + " : " + p.getQuantity() + " in inventory");
        }
        System.out.println();
    }

    public Product GetProduct(int index){
        return list.get(index);
    }

    public void PrintSelection() {
        for (Product p : list) {
            System.out.println(list.indexOf(p) + ". " + p.getName() + " - $" + p.getPrice() + " : " + p.getQuantity() + " left");
        }
        System.out.println();
    }

    public Product SearchId(int id){
        for (Product p : list) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void NewProduct(String name, double price, int quantity) {
        Product test = new Product(name,price);
        if (!list.contains(test)) {
            try {
                ResultSet data = dl.NewProduct(name, price, quantity);
                data.next();
                int id = data.getInt("ProductId");
                Product p = new Product(id, name, price, quantity);
                list.add(p);
            } catch (SQLException e) {
                System.out.println("Application error creating new product!");
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("This product already exists!");
        }
    }

    public void UpdateProduct(int index, Product p){
        dl.UpdateProduct(p.getId(), p.getName(), p.getPrice(), p.getQuantity());
        list.set(index, p);
    }

    /*
    public int GetId(int index){
        return list.get(index).getId();
    }

    public void UpdateProduct(int index, String name, double price, int quantity){
        Product p = new Product(name,price);
        if (!list.contains(p)){
            int id = list.get(index).getId();
            dl.UpdateProduct(id,name,price);
            list.get(index).SetName(name);
            list.get(index).SetPrice(price);
        } else {
            System.out.println("This product already exists!");
        }
    } */
}