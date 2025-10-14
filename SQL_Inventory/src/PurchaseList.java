import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseList {
    // Array object to hold Purchase Objects
    private ArrayList<Purchase> list;
    DataAccessLayer dl = new DataAccessLayer();

    public PurchaseList() {
        list = new ArrayList<Purchase>();
        FillList();
    }

    private void FillList() {
        System.out.println("Retrieving Purchase Data...");
        try {
            ResultSet data = dl.GetPurchases();
            int id;
            int personId;
            int productId;
            while (data.next()){
                id = data.getInt("PurchaseId");
                personId = data.getInt("PersonId");
                productId = data.getInt("ProductId");
                list.add(new Purchase(id,personId,productId));
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve purchase data!");
            System.out.println(e.getMessage());
        }
    }

    public void PrintRawData(){ // Mainly for testing if data was put into the arrays
        for (Purchase p : list){
            System.out.println(p);
        }
    }

    public void PrintData() { // Displaying data in a manner the user can understand
        /*
            This one will be a little different from the other two since the raw data is only numbers
            Instead of iterating the raw data through a loop, this grabs a ResultSet which is filled with usable data
            that the user can understand
        */

        ResultSet data = dl.GetPurchaseData();
        String person;
        String product;
        double price;
        try {
            System.out.println("Displaying purchases: ");
            while (data.next()) {
                person = data.getString("PersonName");
                product = data.getString("ProductName");
                price = data.getDouble("Price");

                System.out.println(person + " - " + product + " : $" + price);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while displaying purchase data");
        }

        System.out.println();
    }

    public void PrintSelection() { // Displaying data in a manner the user can understand
        /*
            This one will be a little different from the other two since the raw data is only numbers
            Instead of iterating through a loop, this grabs a ResultSet which is filled with usable data
            that the user can understand
        */

        ResultSet data = dl.GetPurchaseData();
        String person;
        String product;
        double price;
        int counter = 1;
        try {
            while (data.next()) {
                person = data.getString("PersonName");
                product = data.getString("ProductName");
                price = data.getDouble("Price");

                System.out.println(counter + ". " + person + " - " + product + " : $" + price);
                counter++;
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while displaying purchase data");
        }

        System.out.println();
    }

    public void NewPurchase(int PersonId, int ProductId) {
        // Not testing for equal objects because one person can purchase a product multiple times
        try {
            ResultSet data = dl.NewPurchase(PersonId, ProductId);
            data.next();
            int id = data.getInt("PurchaseId");
            Purchase p = new Purchase(id, PersonId, ProductId);
            list.add(p);
        } catch (SQLException e) {
            System.out.println("Application error creating new purchase!");
            System.out.println(e.getMessage());
        }
    }

    public void UpdatePurchase(int PurchaseIndex, int PersonID, int ProductID) {
        int id = list.get(PurchaseIndex).GetId();
        dl.UpdatePurchase(id,PersonID,ProductID);
        list.get(PurchaseIndex).SetPersonId(PersonID);
        list.get(PurchaseIndex).SetProductId(ProductID);
    }
}
