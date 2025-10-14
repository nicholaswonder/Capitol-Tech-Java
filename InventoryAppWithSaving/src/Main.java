import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Scanner scan = new Scanner(System.in);
        int option = -1;

        while (option != 0){
            option = ShowMenu(scan);
            switch (option){
                case 0:
                    // Exit
                    System.out.println("Exiting Program");
                    inv.SaveData();
                    break;

                case 1:
                    // Print Inv
                    inv.Print();
                    break;

                case 2:
                    // Search Inv
                    inv.FindItem(SearchItems(scan));

                case 3:
                    // New Item
                    inv.AddItem(NewItem(scan));
                    break;

                case 4:
                    // Edit Inv
                    inv.UpdateItem();
                    break;

                case 5:
                    // Delete from Inv
                    inv.DeleteItem();
                    break;

                default:
                    // Invalid Input
                    System.out.println("Invalid Selection");
                    break;
            }
        }
    }

    public static int ShowMenu(Scanner scan){
        System.out.println("Select an action");
        System.out.println("0. Save and Exit");
        System.out.println("1. Print Inventory");
        System.out.println("2. Search Items");
        System.out.println("3. Add New Inventory");
        System.out.println("4. Edit Existing Inventory");
        System.out.println("5. Delete Inventory");
        System.out.print("Option: ");
        return scan.nextInt();
    }

    public static Item NewItem(Scanner scan){
        Item i = new Item();
        System.out.print("Enter new name: ");
        i.SetName(scan.next());
        System.out.print("Enter new cost: ");
        i.SetUnitCost(scan.nextDouble());
        System.out.print("Enter new quantity: ");
        i.SetQuantity(scan.nextInt());
        return i;
    }

    public static String SearchItems(Scanner scan){
        System.out.print("Enter item name to search for: ");
        return scan.next();
    }
}