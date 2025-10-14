import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        Scanner scan = new Scanner(System.in);
        char playerOne = 'X';
        char playerTwo = 'O';
        int x = 0;
        int y = 0;

        System.out.println("Starting game!");

        do
        {
            System.out.println("Player 1's Turn!");
            System.out.println(game);
            System.out.println("Enter the x and y values of what square to play");
            System.out.print("X : ");
            x = scan.nextInt();
            System.out.print("Y : ");
            y = scan.nextInt();
            System.out.println(" "); // Prints nothing for white space

            game.playerTurn(x,y,playerOne);
            if(game.checkBoard())
            {
                System.out.println(game);
                System.out.println("Player One Wins!");
                break;
            }

            System.out.println("Player 2's Turn!");
            System.out.println(game);
            System.out.println("Enter the x and y values of what square to play");
            System.out.print("X : ");
            x = scan.nextInt();
            System.out.print("Y : ");
            y = scan.nextInt();
            System.out.println(" "); // Prints nothing for white space

            game.playerTurn(x,y,playerTwo);
            if(game.checkBoard())
            {
                System.out.println(game);
                System.out.println("Player Two Wins!");
                break;
            }
        } while (!game.checkBoard());
    }
}