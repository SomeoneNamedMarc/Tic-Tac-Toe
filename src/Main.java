import java.util.Scanner;

public class Main {

    static char[][] board = {{'_','_','_'},{'_','_','_'},{'_','_','_'}};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int turns = 6;
        String playerOne = "";
        String playerTwo = "";

        System.out.println("What is player one's name?: ");
        playerOne = input.nextLine();
        System.out.println("What is player two's name?: ");
        playerTwo = input.nextLine();
        printBoard();
        for (int i = 1; i <= turns; i++)
        {
            if (i % 2 == 0)
            {
                playerOneTurn(playerOne);
            }
            else
            {
                playerTwoTurn(playerTwo);
            }

            printBoard();
        }
    }

    private static void playerOneTurn(String player) {
        Scanner input = new Scanner(System.in);
        System.out.printf("%n%s, it's your turn! Where do you wish to move?%n", player);
        System.out.print("x: ");
        int moveOnXAxis = Integer.parseInt(input.nextLine());
        System.out.print("y: ");
        int moveOnYAxis = Integer.parseInt(input.nextLine());

        while (!checkIfSpaceClear(moveOnXAxis, moveOnYAxis))
        {
            System.out.println("That spot is taken");
            System.out.print("x: ");
            moveOnXAxis = Integer.parseInt(input.nextLine());
            System.out.print("y: ");
            moveOnYAxis = Integer.parseInt(input.nextLine());
        }

        board[moveOnYAxis-1][moveOnXAxis-1] = 'x';
    }

    private static void playerTwoTurn(String player) {
        Scanner input = new Scanner(System.in);
        System.out.printf("%n%s, it's your turn! Where do you wish to move?%n", player);
        System.out.print("x: ");
        int moveOnXAxis = Integer.parseInt(input.nextLine());
        System.out.print("y: ");
        int moveOnYAxis = Integer.parseInt(input.nextLine());

        while (!checkIfSpaceClear(moveOnXAxis, moveOnYAxis))
        {
            System.out.println("That spot is taken");
            System.out.print("x: ");
            moveOnXAxis = Integer.parseInt(input.nextLine());
            System.out.print("y: ");
            moveOnYAxis = Integer.parseInt(input.nextLine());
        }

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
}