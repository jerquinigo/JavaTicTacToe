public class TicTacToe {


    public static void printGameBoard() {
        //using the static keyword allows for us to use the method without declaring a class or making a new instance of the class. (access them before/without instantiating the class)
        
                //five rows because of the game piece and the symbols in between
                char[] [] gameBoard = {{' ', '|',' ','|', ' '},
                {'-', '+','-','+', '-'},
                {' ', '|',' ','|', ' '},
                {'-', '+','-','+', '-'},
                {' ', '|',' ','|', ' '}};

        for(char[] row : gameBoard) {
            for(char c : row) {
             System.out.print(c);
            }
         System.out.println();
        }

    }

    public static void main(String[] arg) {
        printGameBoard();
    }

}