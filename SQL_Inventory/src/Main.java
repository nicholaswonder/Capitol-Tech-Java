import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataAccessLayer dl = new DataAccessLayer();
        Scanner scan = new Scanner(System.in);
        // For creating new entries
        String NewName;
        double NewPrice;
        int PurchaseIndex;
        int PersonIndex;
        int ProductIndex;
        if (dl.TestConnection()) {
            CustomerList c = new CustomerList();
            InventoryList i = new InventoryList();
            PurchaseList p = new PurchaseList();
            System.out.println("Finished retrieving data!");
            System.out.println();
            int option = -1;
            while (option != 0) {
                option = MainMenu();
                switch (option){
                    case 1:
                        // Display customers
                        c.PrintData();
                        break;

                    case 2:
                        // Add customer
                        ClearInputStream();
                        System.out.print("Enter new customers name: ");
                        NewName = scan.nextLine();
                        c.NewCustomer(NewName);
                        break;

                    case 3:
                        // Update customer
                        ClearInputStream();
                        c.PrintSelection();
                        System.out.print("Select which customer to edit: ");
                        PersonIndex = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Enter a new name for the customer: ");
                        NewName = scan.nextLine();
                        c.UpdateCustomer(PersonIndex, NewName);
                        break;

                    case 4:
                        // Display products
                        i.PrintData();
                        break;

                    case 5:
                        // Add product
                        System.out.print("Enter new products name: ");
                        NewName = scan.nextLine();
                        System.out.print("Enter new products price: $");
                        NewPrice = scan.nextDouble();
                        i.NewProduct(NewName, NewPrice);
                        break;

                    case 6:
                        // Update product
                        ClearInputStream();
                        i.PrintSelection();
                        System.out.print("Select a product to edit: ");
                        ProductIndex = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Enter a new name for the product: ");
                        NewName = scan.nextLine();
                        ClearInputStream();
                        System.out.print("Enter a new price for this product: $");
                        NewPrice = scan.nextDouble();
                        i.UpdateProduct(ProductIndex,NewName,NewPrice);
                        break;

                    case 7:
                        // Display purchases
                        p.PrintData();
                        break;

                    case 8:
                        // Add purchase
                        ClearInputStream();
                        System.out.println("Creating new purchase");
                        c.PrintSelection();
                        System.out.print("Select a customer: ");
                        PersonIndex = scan.nextInt();
                        ClearInputStream();
                        System.out.println();
                        i.PrintSelection();
                        System.out.print("Select a product: ");
                        ProductIndex = scan.nextInt();
                        System.out.println();
                        p.NewPurchase(c.GetId(PersonIndex), i.GetId(ProductIndex));
                        break;

                    case 9:
                        // Update purchase
                        p.PrintSelection();
                        System.out.print("Select a purchase to edit: ");
                        PurchaseIndex = scan.nextInt() - 1;
                        ClearInputStream();
                        c.PrintSelection();
                        System.out.print("Select customer for purchase: ");
                        PersonIndex = scan.nextInt();
                        ClearInputStream();
                        i.PrintSelection();
                        System.out.print("Select product for purchase: ");
                        ProductIndex = scan.nextInt();
                        p.UpdatePurchase(PurchaseIndex, c.GetId(PersonIndex), i.GetId(ProductIndex));
                        break;

                    case 0:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("You broke my program you rat");
                }
            }
        }
    }

    private static int MainMenu() {
        Scanner scan = new Scanner(System.in);
        int option = -1;
        System.out.println("Select an option:");
        System.out.println("1. Display all customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Update existing customer");
        System.out.println();
        System.out.println("4. Display all products");
        System.out.println("5. Add new product");
        System.out.println("6. Update existing product");
        System.out.println();
        System.out.println("7. Display all purchases");
        System.out.println("8. Create new purchase");
        System.out.println("9. Update existing purchase");
        System.out.println();
        System.out.println("0. Exit");
        System.out.println();
        while (option < 0 || option > 9){
            System.out.print("Select an option: ");
            option = scan.nextInt();
        }
        System.out.println();
        return option;
    }

    private static void ClearInputStream(){
        /*
            This method fixed an issue I was having with the input stream
            having more information than intended, leading to prompts getting skipped.
            This code utilizes the InputStream object to check how many bytes of information
            are in the input stream, and repeatedly calls a scanner until it is cleared.

            This solution may be considered a bit overkill, but I want to ensure the reliability
            of the program's basic input functions to ensure data doesn't get messed up in the db.

            There are some spots where this function doesn't work, so you see a few scan.nextLine()
            commands that lead nowhere. Not sure if its this function that's just under-performing
            or just something weird, but I've tested all the commands, and they seem to work fine for me
         */
        Scanner scan = new Scanner(System.in);
        InputStream stream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        try{
            while (stream.available() > 0){
                scan.nextLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred reading input stream");
        }

    }
}