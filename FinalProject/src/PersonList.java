import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class PersonList {
    // Array object to hold persons objects
    private ArrayList<Person> list;
    private DataAccessLayer dl = new DataAccessLayer();

    public PersonList(){
        list = new ArrayList<Person>();
        FillList();
    }

    private void FillList() {
        System.out.println("Retrieving Customer Data...");
        try {
            ResultSet data = dl.GetCustomers();
            int id;
            String fName;
            String lName;
            while (data.next()){
                id = data.getInt("PersonId");
                fName = data.getString("FName");
                lName = data.getString("LName");
                list.add(new Person(id,fName,lName));
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve customer data!");
            System.out.println(e.getMessage());
        }
    }

    public void PrintRawData() { // For testing if data was put into the arrays
        for (Person p : list) {
            System.out.println(p.getID() + " - " + p);
        }
    }

    public void PrintData() { // Displaying data in a manner the user can understand
        System.out.println("Displaying customers: ");
        for (Person p : list) {
            System.out.println(p);
        }
        System.out.println();
    }

    public void PrintSelection() {
        for (Person p : list) {
            System.out.println(list.indexOf(p) + ". " + p);
        }
        System.out.println();
    }

    public Person SearchId(int id){
        // Does a quick search of the list by given id
        // Returns null if no person is found
        for (Person p : list) {
            if (p.getID() == id){
                return p;
            }
        }
        return null;
    }

    public void NewPerson(String fName, String lName){
        ResultSet data = dl.NewCustomer(fName, lName);
        try {
            data.next();
            list.add(new Person(data.getInt("PersonID"), fName, lName));
        } catch (SQLException e) {
            System.out.println("Error adding person to application!");
            System.out.println(e.getMessage());
        }
    }

    public Person GetPerson(int index){
        return list.get(index);
    }
}
