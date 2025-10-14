import java.sql.*;
public class DataAccessLayer {
    public boolean TestConnection(){
        String databaseURL = "jdbc:mysql://localhost:3306/javasql";
        String username = "root";
        String password = "";

        // Get Driver

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            // Get Connection

            try {
                DriverManager.getConnection(databaseURL,username,password);
                System.out.println("Database connection successful");
                return true;
            } catch (SQLException e) {
                System.out.println("Connection to MySQL failed");
                System.out.println(e.getMessage());
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Driver failed to load");
            System.out.println(e.getMessage());
            return false;
        }
    }

    private Connection GetConnection() {
        String databaseURL = "jdbc:mysql://localhost:3306/javasql";
        String username = "root";
        String password = "";
        Connection conn;

        // Get Driver

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get Connection

            try {
                conn = DriverManager.getConnection(databaseURL,username,password);
                return conn;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private ResultSet GetData(String sql) { // Returns a ResultSet
        try {
            Connection conn = GetConnection();
            if (conn != null){
                Statement st = conn.createStatement();
                ResultSet result;
                result = st.executeQuery(sql);
                return result;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve data");
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void SetData(String sql) { // For adding/updating sql without returning
        try {
            Connection conn = GetConnection();
            if (conn != null){
                Statement st = conn.createStatement();
                st.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println("Failed to update database");
            System.out.println(e.getMessage());
        }
    }

    public ResultSet GetCustomers(){
        return GetData("SELECT * FROM persons;");
    }

    public ResultSet NewCustomer(String name){ // Creates new sql entry and returns its data for object creation
        String sql = "INSERT INTO persons (PersonName) VALUES ('" + name + "');";
        SetData(sql);
        sql = "SELECT PersonId FROM persons WHERE PersonName = '" + name + "';";
        return GetData(sql);
    }

    public void UpdateCustomer(int id, String name) {
        String sql = "UPDATE persons SET PersonName = '" + name + "' WHERE PersonID = " + id;
        SetData(sql);
    }

    public ResultSet GetProducts(){
        return GetData("SELECT * FROM products;");
    }

    public ResultSet NewProduct(String name, double price){ // Creates new sql entry and returns its data for object creation
        String sql = "INSERT INTO products (ProductName, Price) VALUES ('" + name + "'," + price + ");";
        SetData(sql);
        sql = "SELECT ProductId FROM products WHERE ProductName = '" + name + "' AND Price = " + price + ";";
        return GetData(sql);
    }

    public void UpdateProduct(int id, String name, double price){
        String sql = "UPDATE products SET ProductName = '" + name + "', Price = " + price + " WHERE ProductID = " + id + ";";
        SetData(sql);
    }

    public ResultSet GetPurchases(){
        return GetData("SELECT * FROM purchase;");
    }

    public ResultSet GetPurchaseData(){
        String sql = "SELECT persons.PersonName, products.ProductName, products.Price\n" +
                        "FROM purchase\n" +
                        "JOIN persons ON persons.PersonId = purchase.PersonId\n" +
                        "JOIN products ON products.ProductId = purchase.ProductId;";
        return GetData(sql);
    }

    public ResultSet NewPurchase(int PersonId, int ProductId) { // Creates new sql entry and returns its data for object creation
        String sql = "INSERT INTO purchase (PersonID, ProductID) VALUES (" + PersonId + "," + ProductId + ");";
        SetData(sql);
        // Since there can be non-unique purchases, there may be repeated records.
        // This will only grab the most recently added record
        sql = "SELECT PurchaseID FROM purchase\n" +
                "WHERE PersonID = " + PersonId + " AND ProductID = " + ProductId + "\n" +
                "ORDER BY PurchaseID DESC\n" +
                "LIMIT 1;";
        return GetData(sql);
    }

    public void UpdatePurchase(int PurchaseId, int PersonId, int ProductId) {
        String sql = "UPDATE purchase SET PersonID = " + PersonId + ", ProductID = " + ProductId + " WHERE PurchaseID = " + PurchaseId + ";";
        SetData(sql);
    }
}