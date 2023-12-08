import java.util.Scanner;

public class Main {

    static char[][] board = {{'_','_','_'},{'_','_','_'},{'_','_','_'}};
    static String playerOne = "";
    static String playerTwo = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int turns = 6;


        System.out.println("What is player one's name?: ");
        playerOne = input.nextLine();
        System.out.println("What is player two's name?: ");
        playerTwo = input.nextLine();
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
        int moveOnXAxis = checkInputForInt(input.nextLine());;
        System.out.print("y: ");
        int moveOnYAxis = checkInputForInt(input.nextLine());

        while (!checkIfSpaceClear(moveOnXAxis, moveOnYAxis))
        {
            System.out.println("That spot is taken");
            System.out.print("x: ");
            moveOnXAxis = checkInputForInt(input.nextLine());
            System.out.print("y: ");
            moveOnYAxis = checkInputForInt(input.nextLine());
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

    private static int checkInputForInt(String str)
    {
        Scanner input = new Scanner(System.in);
        while (!isInt(str) || Integer.parseInt(str) > 3 || Integer.parseInt(str) < 1)
        {
            System.out.println("You have to input a number within the parameters.");
            str = input.next();
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