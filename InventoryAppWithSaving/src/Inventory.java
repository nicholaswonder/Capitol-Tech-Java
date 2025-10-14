import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Inventory {
    // Inventory
    ArrayList<Item> inv;

    public Inventory() {
        inv = new ArrayList<Item>();
        ReadSave();
    }

    private void ReadSave(){
        File file = new File("InventoryData.txt");
        try {
            if (file.exists()) {
                System.out.println("Inventory save found!");
                System.out.println("Reading data...");
                Scanner scan = new Scanner(file);
                String data;
                String[] splitData;
                String name;
                int quantity;
                double cost;
                while (scan.hasNext()){
                    data = scan.next();
                    splitData = data.split(",");
                    name = splitData[0];
                    cost = Double.parseDouble(splitData[1]);
                    quantity = Integer.parseInt(splitData[2]);
                    AddItem(new Item(name,cost,quantity));
                }
                System.out.println("Save has been successfully read");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Inventory save not found!");
            System.out.println("Creating new save");
            try {
                if (file.createNewFile()){
                    System.out.println("Successfully created new save!");
                }
            } catch (IOException ex) {
                System.out.println("An error occurred creating new save");
            }
        }
    }

    public void SaveData() {
        try {
            FileWriter writer = new FileWriter("InventoryData.txt");
            for (Item item : inv) {
                writer.write(item.toCSV() + '\n');
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving data!");
        }
    }

    public void AddItem(Item NewItem){
        if (!inv.contains(NewItem)){
            inv.add(NewItem);
        } else {
            // Find index of item and add the quantities together
            int index = inv.indexOf(NewItem);
            inv.get(index).SetQuantity(inv.get(index).GetQuantity() + NewItem.GetQuantity());
        }
    }

    public void DeleteItem() {
        for (Item item : inv) {
            System.out.println(String.valueOf(inv.indexOf(item)) + ": " + item);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index of item you wish to delete");
        System.out.println("(-1 to cancel)");
        System.out.print("Index : ");
        int index = scan.nextInt();
        if (index >= 0) {
            inv.remove(index);
        }
    }

    public void FindItem(String ItemName){
        Item i = new Item(ItemName);
        if (inv.contains(i)){
            System.out.println(inv.get(inv.indexOf(i)));
        }
    }

    public void UpdateItem() {
        for (Item item : inv) {
            System.out.println(String.valueOf(inv.indexOf(item)) + ": " + item);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index of item you wish to edit");
        System.out.println("(-1 to cancel)");
        System.out.print("Index : ");
        int index = scan.nextInt();
        if (index >= 0) {
            System.out.println("Item Chosen");
            System.out.println(inv.get(index));
            System.out.print("Enter new name: ");
            inv.get(index).SetName(scan.next());
            System.out.print("Enter new cost: ");
            inv.get(index).SetUnitCost(scan.nextDouble());
            System.out.print("Enter new quantity: ");
            inv.get(index).SetQuantity(scan.nextInt());
        }
    }

    public void Print(){
        for (Item item : inv) {
            System.out.println(item);
        }
    }
}
