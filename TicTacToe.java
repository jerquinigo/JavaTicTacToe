//default package
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();


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

    public static void placePiece(int position, char[][] gameBoard, String user) {

        char symbol = ' ';
        if(user.equals("human")) {
            symbol = 'X';
            //this will add the integer value of the board location to the player ArrayList to check for winner later
            playerPositions.add(position);
        }
        else if(user.equals("cpu")) {
            symbol = 'O';
            //This will add the integer value of the board location to the cpu ArrayList to check for winner later
            cpuPositions.add(position);
        }

        switch(position) {
            case 1:
              gameBoard[0][0] = symbol;
              break;
  
              case 2:
              gameBoard[0][2] = symbol;
              break;
  
              case 3:
              gameBoard[0][4] = symbol;
              break;
  
              case 4:
              gameBoard[2][0] = symbol;
              break;
  
              case 5:
              gameBoard[2][2] = symbol;
              break;
  
              case 6:
              gameBoard[2][4] = symbol;
              break;
  
              case 7:
              gameBoard[4][0] = symbol;
              break;
  
              case 8:
              gameBoard[4][2] = symbol;
              break;
  
              case 9:
              gameBoard[4][4] = symbol;
              break;
          }
    }

    public static String checkWinner() {
        
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);

        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);

        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);
        

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
        
        for(List i : winning) {
          if(playerPositions.containsAll(i)) {
              return "Congratulations, you won";
          }
          else if(cpuPositions.containsAll(i)) {
            return "CPU Wins";
          }
          else if(playerPositions.size() + cpuPositions.size() == 9){
            return "Game is tie...";
          }
        }
        return "";
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


       

        //to keep the human and cpu method going
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int position = scan.nextInt();
            //this is so the player will not enter in the same location as the computer
            while(playerPositions.contains(position) || cpuPositions.contains(position)) {
                System.out.println("Position taken, enter a free location");
                position = scan.nextInt();
            }


            //System.out.println(position);
            placePiece(position, gameBoard, "human");
            //check to see if human won after putting down final choice
            String result = checkWinner();
            //check result after each human move
            if(result.length() > 0) {
                System.out.println(result);
                //print final board pieces
                printGameBoard(gameBoard);
                break;
            }
            
            Random rand = new Random();
            int randNum = rand.nextInt(10);
            // this will check to see that the computer will not put in the same location as you
            while(playerPositions.contains(randNum) || cpuPositions.contains(randNum)) {
                randNum = rand.nextInt(10);
            }

            placePiece(randNum, gameBoard, "cpu");

            printGameBoard(gameBoard);


             result = checkWinner();
            if(result.length() > 0) {
                //check result after each cpu move
                System.out.println(result);
                //print final board pieces
                printGameBoard(gameBoard);
                break;
            }

        }
    }

}