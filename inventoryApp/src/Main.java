import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<item> inv = new ArrayList<item>();
        int action = 0;

        while (action != 5){
            action = menu();

            switch(action)
            {
                case 1:
                    // Add New Item
                    item item = newItem();
                    if (!inv.contains(item)){
                        inv.add(item);
                    } else {
                        item foundItem = inv.get(inv.indexOf(item));
                        inv.get(inv.indexOf(item)).setQuantity(foundItem.getQuantity() + item.getQuantity());
                    }
                    break;
                case 2:
                    // Print Contents
                    printContents(inv);
                    break;
                case 3:
                    // Find Item
                    findItem(inv);
                    break;
                case 4:
                    // Delete Item
                    int select = deleteItem(inv);
                    if (select > -1){
                        inv.remove(select-1);
                    }
                    break;
                case 5:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("An error occurred...");
            }
        }

    }

    private static int menu(){
        Scanner scan = new Scanner(System.in);
        int option = -1;
        while (option < 1 || option > 5){
            System.out.println("Select an action");
            System.out.println("1. Add item");
            System.out.println("2. List items");
            System.out.println("3. Find item");
            System.out.println("4. Remove item");
            System.out.println("5. Exit Program");
            System.out.print("Action: ");
            option = scan.nextInt();
            if (option < 1 || option > 5){
                System.out.println("Invalid Selection");
            }
        }
        return option;
    }

    private static item newItem(){
        Scanner scan = new Scanner(System.in);
        String name;
        double cost;
        int quantity;

        System.out.print("Enter the name of the new item: ");
        name = scan.next();
        System.out.print("Enter the cost: $");
        cost = scan.nextDouble();
        System.out.print("Enter the quantity: ");
        quantity = scan.nextInt();

        return new item(name,cost,quantity);
    }

    private static void printContents(List<item> inv){
        if (!inv.isEmpty()){
            double total = 0;
            for (item currentItem : inv) {
                System.out.println(currentItem);
                total += currentItem.getTotalValue();
            }
            System.out.println("Total value of inventory: $" + total);
        } else {
            System.out.println("Inventory is empty!");
        }
    }

    private static void findItem(List<item> inv){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the items name: ");
        String name = scan.next();
        System.out.print("Enter the cost of the item: ");
        double cost = scan.nextDouble();
        item searchItem = new item(name, cost);
        if (inv.contains(searchItem)){
            System.out.println("Found item!");
            System.out.print(inv.get(inv.indexOf(searchItem)));
        } else {
            System.out.println("Item not found");
        }
    }

    private static int deleteItem(List<item> inv){ // Returns index of deletion
        if (!inv.isEmpty()){
            Scanner scan = new Scanner(System.in);
            int num = 1;
            for (item currentItem : inv) {
                System.out.println(num);
                System.out.println(currentItem);
            }
            System.out.println("Select item to delete (-1 to cancel)");
            return scan.nextInt();
        } else {
            System.out.println("Inventory is empty!");
            return -1;
        }
    }
}