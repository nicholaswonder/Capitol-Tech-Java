import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Printer printer = new Printer();
        Scanner scan = new Scanner(System.in);
        int[] temps = new int[30];
        boolean randFill = false;
        System.out.println("Enter 'false' to fill temperature array manually, or 'true' to randomly fill");
        randFill = scan.nextBoolean();
        if (randFill){
            // Makes code easier to test
            System.out.println("Randomly filling array...");
            for (int i = 0; i < temps.length; i++){
                temps[i] = rand.nextInt(151);
            }
        } else {
            // Manual Filling of Array
            System.out.println("Manually filling");
            for (int i = 0; i < 30; i++){
                System.out.print("Enter temperature for day " + (i+1) + ": ");
                temps[i] = scan.nextInt();
            }
        }

        printer.print(temps, "Arrays Before Sorting", true);

        // Create threads
        InsertSortThread insert = new InsertSortThread(temps,printer);
        SelectSortThread select = new SelectSortThread(temps,printer);

        // Begin the multithreading
        insert.start();
        select.start();

        try{
            insert.join();
            select.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}