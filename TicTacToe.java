//default package
import java.util.Scanner;

public class TicTacToe {



    public static void printGameBoard(char[][] gameBoard) {
        //using the static keyword allows for us to use the method without declaring a class or making a new instance of the class. (access them before/without instantiating the class)


        //cleaner nested two for loops
        for(char[] row : gameBoard) {
            for(char c : row) {
             System.out.print(c);
            }
         System.out.println();
        }

    }

    public static void main(String[] arg) {
    //five rows because of the game piece and the symbols in between
        char[] [] gameBoard = {{' ', '|',' ','|', ' '},
        {'-', '+','-','+', '-'},
        {' ', '|',' ','|', ' '},
        {'-', '+','-','+', '-'},
        {' ', '|',' ','|', ' '}};
        
        //passing in the char Array into the printGameBoardMethod
        printGameBoard(gameBoard);


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your placement (1-9): ");
        int position = scan.nextInt();

        System.out.println(position);

        switch(position) {
          case 1:
            gameBoard[0][0] = 'X';
            break;

            case 2:
            gameBoard[0][2] = 'X';
            break;

            case 3:
            gameBoard[0][4] = 'X';
            break;

            case 4:
            gameBoard[2][0] = 'X';
            break;

            case 5:
            gameBoard[2][2] = 'X';
            break;

            case 6:
            gameBoard[2][4] = 'X';
            break;

            case 7:
            gameBoard[4][0] = 'X';
            break;

            case 8:
            gameBoard[4][2] = 'X';
            break;

            case 9:
            gameBoard[4][4] = 'X';
            break;
        }
    }

}