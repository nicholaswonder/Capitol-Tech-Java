import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataAccessLayer dl = new DataAccessLayer();
        Scanner scan = new Scanner(System.in);

        // Program control variables
        int mainOption = 0; // Used for main loop
        int subOption = 0; // Used to control submenus without affecting main loop
        int selection = 0; // Used to select individual list items

        // For selection purposes
        Person personSelect;
        Product productSelect;

        // For object creation
        String fName;
        String lName;
        double price;
        int quantity;

        if (dl.TestConnection()) { // Program cannot run without a connection to database
            PersonList people = new PersonList();
            ProductList products = new ProductList();
            PurchaseList purchases = new PurchaseList(people, products);

            // BEGIN MAIN LOOP
            while (mainOption != 3){
                mainOption = mainMenu();
                subOption = 0;
                System.out.println();

                switch (mainOption){
                    case 1:
                        // Manage Products
                        // BEGIN SUB LOOP
                        while (subOption != 4){
                            subOption = manageProductsMenu();
                            System.out.println();

                            switch (subOption) {
                                case 1:
                                    // Add product
                                    System.out.println("Creating new product");
                                    System.out.print("Product Name: ");
                                    fName = scan.next();
                                    System.out.print("Product Price: $");
                                    price = scan.nextDouble();
                                    System.out.print("Product Quantity: ");
                                    quantity = scan.nextInt();

                                    products.NewProduct(fName, price, quantity);
                                    System.out.println();

                                    break;

                                case 2:
                                    // View All Products
                                    products.PrintData();
                                    break;

                                case 3:
                                    // Edit Product
                                    System.out.println("Editing a product");
                                    products.PrintSelection();
                                    System.out.print("Select a product: ");
                                    selection = scan.nextInt();
                                    productSelect = products.GetProduct(selection);
                                    System.out.println();

                                    productSelect = editProduct(productSelect);

                                    products.UpdateProduct(selection, productSelect);

                                    break;

                                // Case 4 returns to main menu, no need for code
                            }
                        }
                        // END LOOP
                        break;

                    case 2:
                        // Complete Transactions

                        // BEGIN SUB LOOP
                        while (subOption != 3){
                            subOption = completePurchaseMenu();
                            System.out.println();

                            switch (subOption){
                                case 1:
                                    // New person
                                    System.out.println("Adding new client");
                                    System.out.print("Enter first name: ");
                                    fName = scan.next();
                                    System.out.print("Enter last name: ");
                                    lName = scan.next();
                                    System.out.println();

                                    people.NewPerson(fName, lName);

                                    break;

                                case 2:
                                    // New purchase
                                    System.out.println("Creating new purchase");
                                    System.out.println("Select a client");
                                    people.PrintSelection();
                                    System.out.print("Selection: ");
                                    personSelect = people.GetPerson(scan.nextInt());
                                    System.out.println();

                                    System.out.println("Select a product");
                                    products.PrintSelection();
                                    System.out.print("Selection: ");
                                    productSelect = products.GetProduct(scan.nextInt());
                                    System.out.println();

                                    System.out.print("Quantity purchased: ");
                                    quantity = scan.nextInt();
                                    System.out.println();

                                    purchases.NewPurchase(personSelect, productSelect, quantity);

                                // Case 3 returns to main menu
                            }
                        }

                        break;

                    case 3:
                        // Exit Program
                        System.out.println("Exiting Program");
                        System.out.println("See you next time!");
                }
            }

            // END MAIN LOOP


        } else { // If a connection cannot be established
            System.out.println("Failed to establish connection to database");
            System.out.println("Exiting program...");
        }
    }

    private static int mainMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Super Database Manager!");
        System.out.println("Select an action:");
        System.out.println("1. Manage Products");
        System.out.println("2. Complete Transactions");
        System.out.println("3. Exit Program");
        System.out.print("Selection: ");
        return scan.nextInt();
    }

    private static int manageProductsMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Managing Products");
        System.out.println("Select an action:");
        System.out.println("1. Add new product");
        System.out.println("2. View all products");
        System.out.println("3. Edit existing products");
        System.out.println("4. Return to main menu");
        System.out.print("Selection: ");
        return scan.nextInt();
    }

    private static Product editProduct(Product p){
        Scanner scan = new Scanner(System.in);
        int option;
        String name;
        double price;
        int quantity;
        System.out.println("Select an aspect to edit");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Quantity");
        System.out.print("Selection: ");
        option = scan.nextInt();

        switch (option){
            case 1:
                System.out.print("Enter new name: ");
                name = scan.next();
                p.setName(name);
                break;

            case 2:
                System.out.print("Enter new price: $");
                price = scan.nextDouble();
                p.setPrice(price);
                break;

            case 3:
                System.out.print("Enter new quantity: ");
                quantity = scan.nextInt();
                p.setQuantity(quantity);
        }
        return p;
    }

    private static int completePurchaseMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Managing Purchases");
        System.out.println("Select an option");
        System.out.println("1. Add a client");
        System.out.println("2. Make a purchase");
        System.out.println("3. Return to main menu");
        System.out.print("Selection: ");
        return scan.nextInt();
    }
}