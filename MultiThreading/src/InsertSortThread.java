public class InsertSortThread extends Thread{
    private int[] temps;
    Printer printer;

    public InsertSortThread(int[] temps, Printer printer){
        this.temps = temps;
        this.printer = printer;
    }

    @Override
    public void run(){
        // Insert Sort Ascending
        for (int i = 0; i < temps.length; i++){
            int currentNum = temps[i];
            int j = i - 1;
            while (j >= 0 && temps[j] > currentNum){
                temps[j+1] = temps[j];
                j--;
            }
            temps[j+1] = currentNum;
        }

        // Print results
        synchronized (printer){
            printer.print(temps, "Insert Sort, Ascending", true);
        }
    }
}
