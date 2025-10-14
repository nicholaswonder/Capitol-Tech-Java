import java.io.*;

public class Printer {
    public void print(int[] arr, String msg, boolean toFile){
        System.out.println(msg);
        for (int num : arr){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println(); // White Space

        // Since I have the printer as its own object, I figure I might as well put the file IO here
        // That makes implementation easier
        if (toFile){
            // New file object
            File file = new File("TemperatureArrays.txt");

            try {
                if (file.createNewFile()) { // Creates file if it doesn't already exist
                    System.out.println("File created at: " + file.getAbsolutePath());
                    FileWriter writer = new FileWriter("TemperatureArrays.txt");
                    writer.write(msg + "\n");
                    for (int num: arr){
                        writer.write(num + " ");
                    }
                    writer.write("\n");
                    writer.close();
                } else {
                    System.out.println("Writing to file!");
                    FileWriter writer = new FileWriter(file, true);
                    writer.write(msg + "\n");
                    for (int num: arr){
                        writer.write(num + " ");
                    }
                    writer.write("\n");
                    writer.close();
                }

            } catch (IOException e) {
                System.out.println("Error creating/accessing file!");
            }
        }
    }
}
