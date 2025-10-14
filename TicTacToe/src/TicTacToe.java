public class TicTacToe
{
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public TicTacToe()
    {
        // Array is pre-initialized, so nothing is needed in the constructor
    }

    public void playerTurn(int x, int y, char player)
    {
        if ((0 <= x) && (x <= 2) && (0 <= y) && (y <= 2))
        {
            if (board[y][x] == ' ')
            {
                board[y][x] = player;
            }
        }
    }

    public boolean checkBoard()
    {
        for (int i = 0; i <= 2; i++)
        {
            if (checkRow(i) || checkCol(i))
            {
                return true;
            }
        }
        return checkDiags();
    }

    // FUNCTIONS FOR CHECKING TABLE STATUS
    private boolean checkRow(int row)
    {
        if ((board[row][0] == ' ') || (board[row][1] == ' ') || (board[row][2] == ' '))  // Making sure theres no empty spaces
        {
            return false;
        }
        else
        {
            return (board[row][0] == board[row][1]) && (board[row][1] == board[row][2]);
        }
    }

    private boolean checkCol(int col)
    {
        if ((board[0][col] == ' ') || (board[1][col] == ' ') || (board[2][col] == ' ')) // Making sure theres no empty spaces
        {
            return false;
        }
        else
        {
            return (board[0][col] == board[1][col]) && (board[1][col] == board[2][col]);
        }
    }

    private boolean checkDiags()
    {
        if ((board[0][0] == ' ') || (board[1][1] == ' ') || (board[2][2] == ' ')) // Making sure diag 1 doesnt have empty spaces
        {
            return false;
        }
        else if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
        {
            return true;
        }
        else if ((board[0][2] == ' ') || (board[1][1] == ' ') || (board[2][0] == ' ')) // Making sure diag 2 doesnt have empty spaces
        {
            return false;
        }
        else if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Using toString to print table
    public String toString()
    {
        return board[0][0] + "|" + board[0][1] + "|" + board[0][2] + " 0\n" +
                "-|-|-\n" +
                board[1][0] + "|" + board[1][1] + "|" + board[1][2] + " 1\n" +
                "-|-|-\n" +
                board[2][0] + "|" + board[2][1] + "|" + board[2][2] + " 2\n" +
                "0 1 2\n";
    }
}
