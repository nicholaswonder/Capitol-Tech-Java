import java.sql.*;
public class DataAccessLayer {
    public boolean TestConnection(){
        String databaseURL = "jdbc:mysql://localhost:3306/javafinal";
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
        String databaseURL = "jdbc:mysql://localhost:3306/javafinal";
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

    private void SetData(String sql) { // For adding/updating sql
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
        return GetData("SELECT * FROM persons");
    }

    public ResultSet NewCustomer(String fName, String lName){
        String sql = "INSERT INTO persons (FName, LName) VALUES ('" + fName + "', '" + lName + "');";
        SetData(sql);
        sql = "SELECT PersonId FROM persons WHERE FName = '" + fName + "' AND LName = '" + lName + "';";
        return GetData(sql);
    }

    public ResultSet GetProducts(){
        return GetData("SELECT * FROM products");
    }

    public ResultSet NewProduct(String name, double price, int quan){
        String sql = "INSERT INTO Products(PName,Price,Quantity) VALUES ('" + name + "'," + price + "," + quan + ");";
        SetData(sql);
        sql = "SELECT ProductId FROM products WHERE PName = '" + name + "' AND Price = " + price + " AND Quantity = " + quan + ";";
        return GetData(sql);
    }

    public void UpdateProduct(int id, String name, double price, int quan){
        String sql = "UPDATE products SET PName = '" + name + "', Price = " + price + ", Quantity = " + quan + " WHERE ProductID = " + id + ";";
        SetData(sql);
    }

    public ResultSet GetPurchases(){
        return GetData("SELECT * FROM purchase");
    }

    public ResultSet NewPurchase(int personId, int productId, int quan, int productQuan){
        String sql = "INSERT INTO purchase (PersonID, ProductID, PurchaseDate, Quantity) VALUES \n" +
                "(" + personId + "," + productId +  ", current_date(), " + quan + ");";
        SetData(sql);

        // Gotta update the quantity in inventory after a purchase
        sql = "UPDATE products SET Quantity = " + (productQuan - quan) + " WHERE ProductID = " + productId + ";";
        SetData(sql);

        // Since there can be non-unique purchases, there may be repeated records.
        // This will only grab the most recently added record
        sql = "SELECT PurchaseID FROM purchase\n" +
                "WHERE PersonID = " + personId + " AND ProductID = " + productId + "\n" +
                "ORDER BY PurchaseID DESC\n" +
                "LIMIT 1;";
        return GetData(sql);
    }
}