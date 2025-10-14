public class SelectSortThread extends Thread{
    private int[] temps;
    Printer printer;

    public SelectSortThread(int[] temps, Printer printer){
        this.temps = temps;
        this.printer = printer;
    }

    @Override
    public void run(){
        // Selection Sort
        for (int i = 0; i < temps.length; i++){
            int minIndex = i; // Assume the first num is the smallest

            for (int j = i+1; j < temps.length; j++){
                if (temps[j] < temps[minIndex]) {
                    minIndex = j; // Find a number smaller than first assumed
                }
            }

            // Put new smallest number into the lowest position
            int storage = temps[i];
            temps[i] = temps[minIndex];
            temps[minIndex] = storage;
        }

        // Array is in ascending order
        // Reversing array to put in descending order
        int[] reverse = new int[temps.length];
        for (int i = 0; i < temps.length; i++){
            reverse[(temps.length-1) - i] = temps[i];
        }

        // Print results
        synchronized (printer){
            printer.print(reverse, "Selection Sort, Descending", false);
        }
    }
}
