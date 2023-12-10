import java.util.Scanner;

public class Main {

    static char[][] board = {{'_','_','_'},{'_','_','_'},{'_','_','_'}};
    static String playerOne = "";
    static String playerTwo = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("What is player one's name?: ");
        playerOne = input.nextLine();
        System.out.println("What is player two's name?: ");
        playerTwo = input.nextLine();

        while (true)
        {
            playGame();
            System.out.println("Do you wish to rematch? (0: no, 1: yes)");
            if (checkInputForInt(input.nextLine(), 0) != 1)
            {
                break;
            }
            board = new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
        }
    }

    private static void playGame()
    {
        int turns = 6;
        printBoard();
        for (int i = 0; i < turns; i++)
        {
            if (i % 2 == 0)
            {
                playerTurn(playerOne);
            }
            else
            {
                playerTurn(playerTwo);
            }

            printBoard();
        }
    }
    private static void playerTurn(String player) {
        Scanner input = new Scanner(System.in);
        System.out.printf("%n%s, it's your turn! Where do you wish to move?%n", player);
        System.out.print("x: ");
        int moveOnXAxis = checkInputForInt(input.nextLine(), 1);
        System.out.print("y: ");
        int moveOnYAxis = checkInputForInt(input.nextLine(), 1);

        while (!checkIfSpaceClear(moveOnXAxis, moveOnYAxis))
        {
            System.out.println("That spot is taken");
            System.out.print("x: ");
            moveOnXAxis = checkInputForInt(input.nextLine(),1);
            System.out.print("y: ");
            moveOnYAxis = checkInputForInt(input.nextLine(),1);
        }
        if (player.equals(playerOne))
            board[moveOnYAxis-1][moveOnXAxis-1] = 'x';
        else
            board[moveOnYAxis-1][moveOnXAxis-1] = 'o';
    }


    private static boolean checkIfSpaceClear(int x, int y) {
        return board[y-1][x-1] == '_';
    }
    
    private static void printBoard() {
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static int checkInputForInt(String str, int checkCode)
    {
        Scanner input = new Scanner(System.in);
        if (checkCode == 1)
        {
            while (!isInt(str) || Integer.parseInt(str) > 3 || Integer.parseInt(str) < 1)
            {
                System.out.println("You have to input a number within the parameters.");
                str = input.next();
            }
        }
        else
        {
            while (!isInt(str) || Integer.parseInt(str) > 1 || Integer.parseInt(str) < 0)
            {
                System.out.println("You have to input a number within the parameters.");
                str = input.next();
            }
        }
        return Integer.parseInt(str);
    }

    public static boolean isInt(String str)
    {
        if (str == null) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}