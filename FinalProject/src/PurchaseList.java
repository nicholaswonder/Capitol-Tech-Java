import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PurchaseList {
    ArrayList<Purchase> list;
    PersonList personList;
    ProductList productList;
    DataAccessLayer dl = new DataAccessLayer();

    public PurchaseList(PersonList personList, ProductList productList) {
        list = new ArrayList<Purchase>();
        this.personList = personList;
        this.productList = productList;
        FillList();
    }

    private void FillList() {
        System.out.println("Retrieving Purchase Data...");
        try {
            ResultSet data = dl.GetPurchases();
            int id;
            Person person;
            Product product;
            int quantity;
            while (data.next()){
                id = data.getInt("PurchaseId");
                person = personList.SearchId(data.getInt("PersonId"));
                product = productList.SearchId(data.getInt("ProductId"));
                quantity = data.getInt("Quantity");
                list.add(new Purchase(id,person,product,quantity));
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve purchase data!");
            System.out.println(e.getMessage());
        }
    }

    public void NewPurchase(Person person, Product product, int quantity){
        // Check if there is enough in inventory for the purchase
        if (quantity < product.getQuantity()){
            ResultSet data = dl.NewPurchase(person.getID(), product.getId(), quantity, product.getQuantity());
            try {
                data.next(); // Get iterator into the data bounds
                list.add(new Purchase(data.getInt("PurchaseID"), person, product, quantity));
            } catch (SQLException e) {
                System.out.println("Error adding purchase to application!");
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Not enough in inventory for purchase!");
        }
    }

    public void PrintRawData(){ // Mainly for testing if data was put into the arrays
        for (Purchase p : list){
            System.out.println(p);
        }
    }
}
