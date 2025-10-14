import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerList {
    // Array object to hold persons objects
    private ArrayList<Person> list;
    private DataAccessLayer dl = new DataAccessLayer();

    public CustomerList(){
        list = new ArrayList<Person>();
        FillList();
    }

    private void FillList() {
        System.out.println("Retrieving Customer Data...");
        try {
            ResultSet data = dl.GetCustomers();
            int id;
            String name;
            while (data.next()){
                id = data.getInt("PersonId");
                name = data.getString("PersonName");
                list.add(new Person(id,name));
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve customer data!");
            System.out.println(e.getMessage());
        }
    }

    public void PrintRawData() { // For testing if data was put into the arrays
        for (Person p : list) {
            System.out.println(p);
        }
    }

    public void PrintData() { // Displaying data in a manner the user can understand
        System.out.println("Displaying customers: ");
        for (Person p : list) {
            System.out.println(p.GetName());
        }
        System.out.println();
    }

    public void PrintSelection() {
        for (Person p : list) {
            System.out.println(list.indexOf(p) + ". " + p.GetName());
        }
        System.out.println();
    }

    public void NewCustomer(String name) {
        Person test = new Person(name);
        if (!list.contains(test)) {
            try {
                ResultSet data = dl.NewCustomer(name);
                data.next();
                int id = data.getInt("PersonId");
                Person p = new Person(id, name);
                list.add(p);
            } catch (SQLException e) {
                System.out.println("Application error creating new person!");
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("This person already exists!");
        }
    }

    public int GetId(int index){
        return list.get(index).GetID();
    }

    public void UpdateCustomer(int index, String name){
        Person p = new Person(name);
        if (!list.contains(p)){
            int id = list.get(index).GetID();
            dl.UpdateCustomer(id,name);
            list.get(index).SetName(name);
        } else {
            System.out.println("This person already exists!");
        }
    }
}
